# https://algoprog.ru/material/p120 - comment.

n = int(input())


def c(n):
    factorial = None
    v = 0
    for i in range(0, n + 1):
        if i <= 1:
            factorial = 1
        else:
            factorial *= i
        v += 1 / factorial
    return v


print("{:.5f}".format(c(n)))
