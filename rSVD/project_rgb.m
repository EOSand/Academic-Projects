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

file = 'walking.tiff';

[im_name,im_format] = strtok(file,'.');

if strcmpi(im_format,'.tiff') || strcmpi(im_format,'.png')
    bits = 16;
else
    bits = 8;
end

X = double(imread([im_name,im_format]))/(2^bits);
R = X(:,:,1);
G = X(:,:,2);
B = X(:,:,3);

k = 300;

%% SVD
tic; 
% Compute the deterministic SVD of X
[UR,SR,VR] = svd(R,'econ');

% Compute the deterministic SVD of X
[UG,SG,VG] = svd(G,'econ');

% Compute the deterministic SVD of X
[UB,SB,VB] = svd(B,'econ');

svd_construction = cat(3,...
    UR(:,1:k)*SR(1:k,1:k)*VR(:,1:k)',...
    UG(:,1:k)*SG(1:k,1:k)*VG(:,1:k)',...
    UB(:,1:k)*SB(1:k,1:k)*VB(:,1:k)');

t_det = toc;

%% rSVD
tic; 
% Compute the random SVD on R component
[rUR,rSR,rVR] = rsvd(R,k,20,1);

% Compute the random SVD on G component
[rUG,rSG,rVG] = rsvd(G,k,20,1);

% Compute the random SVD on B component
[rUB,rSB,rVB] = rsvd(B,k,20,1);

rsvd_construction = cat(3,...
    rUR*rSR*rVR',...
    rUG*rSG*rVG',...
    rUB*rSB*rVB');

t_rsvd = toc;

%% Write the new image files
if bits == 16
    imwrite(im2uint16(svd_construction),[im_name,'svd_rgb',im_format]);
    imwrite(im2uint16(rsvd_construction),[im_name,'rsvd_rgb',im_format]);
else
    imwrite(im2uint8(svd_construction),[im_name,'svd_rgb',im_format]);
    imwrite(im2uint8(rsvd_construction),[im_name,'rsvd_rgb',im_format]);
end