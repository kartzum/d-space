import numpy as np
from sklearn.linear_model import LinearRegression


def cost_function(X, y, W):
    n = len(X)
    return np.sum(((X.dot(W) - y) ** 2) / (2 * n))


def gradient_descent(X, y, W, epochs, alpha):
    n = len(X)
    cost_history = np.zeros(epochs)
    for i in range(epochs):
        pred = X.dot(W)
        loss = pred - y
        gradient = X.T.dot(loss) / n
        W = W - gradient * alpha
        cost_history[i] = cost_function(X, y, W)
    return cost_history, W


def gradient_descent_test():
    X = np.array([[1, 1], [1, 2], [2, 2], [2, 3]])
    y = np.dot(X, np.array([1, 2])) + 3
    W = np.zeros(2)

    print(X)
    print(y)
    print(W)

    costs, ws = gradient_descent(X, y, W, 100, 0.001)
    print(ws)

    lr = LinearRegression().fit(X, y)
    print(lr.coef_)


gradient_descent_test()
