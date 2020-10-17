# https://algoprog.ru/material/p3072 - in progress.


def params():
    pass


def calc():
    mx = -10000
    mn = 0
    curr = -1
    while curr != 0:
        curr = int(input())
        if curr > mx:
            mn = 1
            mx = curr
        elif curr == mx:
            mn += 1
    return mn


def run():
    result = calc()
    print(result)


run()
