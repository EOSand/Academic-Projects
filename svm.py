import numpy as np
from scipy.optimize import minimize

def linear_kernel(X1, X2):
    """    Matrix multiplication.

    Given two matrices, A (m X n) and B (n X p), multiply: AB = C (m X p).

    Recall from hw 1. Is there a more optimal way to implement using numpy?
    :param X1:  Matrix A
    type       np.array()
    :param X2:  Matrix B
    type       np.array()

    :return:    C Matrix.
    type       np.array()
    """
    return np.dot(X1,X2)


def objective_function(X, y, a, kernel):
    """
    Compute the value of the objective function for a given set of inputs.

    Args:
        X (numpy.ndarray): An array of shape (n_samples, n_features) representing the input data.
        y (numpy.ndarray): An array of shape (n_samples,) representing the labels for the input data.
        a (numpy.ndarray): An array of shape (n_samples,) representing the values of the Lagrange multipliers.
        kernel (callable): A function that takes two inputs X and Y and returns the kernel matrix of shape (n_samples, n_samples).

    Returns:
        The value of the objective function for the given inputs.
    """
    # Compute the value of the objective function
    # The first term is the sum of all Lagrange multipliers
    # The second term involves the kernel matrix, the labels and the Lagrange multipliers

    result = 0
    for i in range(len(X)):
        for j in range(len(X)):
            result += a[i]*a[j]*y[i]*y[j]*kernel(X[i],X[j])

    return np.sum(a) - 0.5 * result

class SVM(object):
    """
    Linear Support Vector Machine (SVM) classifier.

    Parameters
    ----------
    C : float, optional (default=1.0)
        Penalty parameter C of the error term.
    max_iter : int, optional (default=1000)
        Maximum number of iterations for the solver.

    Attributes
    ----------
    w : ndarray of shape (n_features,)
        Coefficient vector.
    b : float
        Intercept term.

    Methods
    -------
    fit(X, y) 
        Fit the SVM model according to the given training data.

    predict(X)
        Perform classification on samples in X.

    outputs(X)
        Return the SVM outputs for samples in X.

    score(X, y)
        Return the mean accuracy on the given test data and labels.
    """

    def __init__(self, kernel=linear_kernel, C=1.0, max_iter=1e3):
        """
        Initialize SVM

        Parameters
        ----------
        kernel : callable
          Specifies the kernel type to be used in the algorithm. If none is given,
          ‘rbf’ will be used. If a callable is given it is used to pre-compute 
          the kernel matrix from data matrices; that matrix should be an array 
          of shape (n_samples, n_samples).
        C : float, default=1.0
          Regularization parameter. The strength of the regularization is inversely
          proportional to C. Must be strictly positive. The penalty is a squared l2
          penalty.
        """
        self.kernel = kernel
        self.C = C
        self.max_iter = max_iter
        self.a = None
        self.w = None
        self.b = None

    def fit(self, X, y):
        """
        Fit the SVM model according to the given training data.

        Parameters
        ----------
        X : {array-like, sparse matrix} of shape (n_samples, n_features) or (n_samples, n_samples)
          Training vectors, where n_samples is the number of samples and n_features 
          is the number of features. For kernel=”precomputed”, the expected shape 
          of X is (n_samples, n_samples).

        y : array-like of shape (n_samples,)
          Target values (class labels in classification, real numbers in regression).

        Returns
        -------
        self : object
          Fitted estimator.
        """
        # save alpha parameters, weights, and bias weight
        self.a = np.zeros(len(X))
        self.w = np.zeros(len(y))
        self.b = 0.0
        
        # Define the constraints for the optimization problem
        constraints = [{'type': 'ineq', 'fun': lambda a: a},
                       {'type': 'eq', 'fun': lambda a: np.dot(a,y)}]

        # Use minimize from scipy.optimize to find the optimal Lagrange multipliers
        res = minimize(fun = lambda a: -objective_function(X, y, a, self.kernel), 
                       x0 = self.a,
                       constraints = constraints,
                       )
        self.a = np.array(res.x)

        # Substitute into dual problem to find weights
        self.w = np.dot(X.T, self.a * y)

        # Substitute into a support vector to find bias
        support_vectors_X = X[self.a > 1e-8]
        support_vectors_y = y[self.a > 1e-8]

        self.b = np.mean(support_vectors_y - np.dot(support_vectors_X, self.w))

        return self

    def predict(self, X):
        """
        Perform classification on samples in X.

        For a one-class model, +1 or -1 is returned.

        Parameters
        ----------
        X : {array-like, sparse matrix} of shape (n_samples, n_features) or (n_samples_test, n_samples_train)

        Returns
        -------
        y_pred : ndarray of shape (n_samples,)
          Class labels for samples in X.
        """
        y_pred = np.zeros(X.shape[0])
        for i in range(len(X)):
            y_pred[i] = np.sign(np.dot(self.w, X[i]) + self.b)

        return y_pred
