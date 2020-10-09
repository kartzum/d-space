# https://algoprog.ru/material/p596 - comment.

debug = False
prod = True
test = False

eps = 1e-7


def read():
    input_values = input().split()
    x = float(input_values[0])
    y = float(input_values[1])
    if debug:
        print(x, y)
    return x, y


def c(x, y):
    k = 1
    while x <= y + eps:
        x += x * .7
        k += 1
    return k


def tests():
    # print(10, 10 + 10 * 0.7, 17.0 + 17.0 * 0.7, 28.9 + 28.9 * 0.7)
    # assert c(10, 30) == 4
    # assert c(10, 50) == 5
    # assert c(10, 10) == 1
    # assert c(10, 20) == 3
    assert c(15.5, 35.5) == 3


if test:
    tests()

if prod:
    x, y = read()
    print(c(x, y))
