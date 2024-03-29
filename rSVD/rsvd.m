%% script

%-------------------------------------------------------------------------------------
% MATH 123 project script
%
% usage : 
%
%  input:
%  * file : the input image file to analyze
%
%  output:
%  * writes out the SVD and rSVD images to new files
%-------------------------------------------------------------------------------------
% Thomas Anzalone and Elijah Sanderson, 2021

file = 'walking.jpg';

[im_name,im_format] = strtok(file,'.');

if strcmpi(im_format,'.tiff') || strcmpi(im_format,'.png')
    bits = 16;
else
    bits = 8;
end

X = double(rgb2gray(imread([im_name,im_format])))/(2^bits);

k = 300;

% Compute the deterministic SVD of X
tic; [U,S,V] = svd(X,'econ'); t_det = toc;

% rSVD #1 - Compute the random SVD with no techniques
tic; [rU1,rS1,rV1] = rsvd(X,k); t_rsvd1 = toc;

% rSVD #2 - Compute the random SVD with just oversampling the intrinsic rank by 5
tic; [rU2,rS2,rV2] = rsvd(X,k,20); t_rsvd2 = toc;

% rSVD #3 - Compute the random SVD with oversampling the intrinsic rank by 5 and doing 2 power iterations
tic; [rU3,rS3,rV3] = rsvd(X,k,20,1); t_rsvd3 = toc;

% Observe the errors in each method from the actual image
err_det = norm(X-U(:,1:k)*S(1:k,1:k)*V(:,1:k)',2)/norm(X,2);
err_rsvd1 = norm(X-rU1*rS1*rV1',2)/norm(X,2);
err_rsvd2 = norm(X-rU2*rS2*rV2',2)/norm(X,2);
err_rsvd3 = norm(X-rU3*rS3*rV3',2)/norm(X,2);

% Write the new image files
if bits == 16
    imwrite(im2uint16(U(:,1:k)*S(1:k,1:k)*V(:,1:k)'),[im_name,'svd',im_format]);
    imwrite(im2uint16(rU1*rS1*rV1'),[im_name,'rsvd1',im_format]);
    imwrite(im2uint16(rU2*rS2*rV2'),[im_name,'rsvd2',im_format]);
    imwrite(im2uint16(rU3*rS3*rV3'),[im_name,'rsvd3',im_format]);
else
    imwrite(im2uint8(U(:,1:k)*S(1:k,1:k)*V(:,1:k)'),[im_name,'svd',im_format]);
    imwrite(im2uint8(rU1*rS1*rV1'),[im_name,'rsvd1',im_format]);
    imwrite(im2uint8(rU2*rS2*rV2'),[im_name,'rsvd2',im_format]);
    imwrite(im2uint8(rU3*rS3*rV3'),[im_name,'rsvd3',im_format]);
end


%% rSVD function

function [U,S,V] = rsvd(X,k,o,q)
%-------------------------------------------------------------------------------------
% random SVD
% Extremely fast computation of the truncated Singular Value Decomposition, using
% randomized algorithms as described in Halko et al. 'finding structure with randomness'
%
% usage : 
%
%  input:
%  * X : matrix whose SVD we want in R(m by n)
%  * k : target rank of X
%  * o : oversampling parameter (optional)
%  * q : # of power iterations (optional)
%
%  output:
%  * rU,rS,rV : SVD of our randomly projected matrix, truncated to the
%               target rank k
%-------------------------------------------------------------------------------------
% Thomas Anzalone and Elijah Sanderson, 2021
% Citations:    Antoine Liutkus, Inria 2014
%               Steve Brunton, 2020

[m,n] = size(X);

transpose_flag = false;
if m < n
    % Fat matrix - compute rSVD on X' and swap U and V in result
    transpose_flag = true;
    X = X';
    [~,n] = size(X);
end

switch nargin
    case 2
        o = 0;
        q = 0;
    case 3
        q = 0;
end

% Step 1: Random Projection Matrix P in R(n by r)
r = k;
P = randn(n,r+o);
Z = X*P;

% Perform the Power iterations - order of operations matters!
% X'*Z is much less computational than X*X'
for i = 1:q
    Z = X*(X'*Z);
end

% Step 2: Find an orthogonal basis, Q, for Z (and X) using QR decomposition
[Q,~] = qr(Z,0);

% Step 3: Project X into the orthogonal basis, Q
Y = Q'*X;
[U,S,V] = svd(Y,'econ');

U = Q*U;
U = U(:,1:r);
S = S(1:r,1:r);
V = V(:,1:r);

if transpose_flag
    U_mem = U;
    U = V;
    V = U_mem;
end

end