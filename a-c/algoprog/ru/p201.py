# https://algoprog.ru/material/p201 - in progress.


def params():
    return int(input())


def calc(n):
    a = 0
    b = 1
    if n == 0:
        return 0
    if n == 1:
        return 1
    for i in range(2, n + 1):
        c = a + b
        a = b
        b = c
    return b


def run():
    n = params()
    print(calc(n))


run()
