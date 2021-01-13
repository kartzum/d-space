# https://algoprog.ru/material/p227


def p():
    n = int(input())
    nums = list(map(int, input().split()))
    return n, nums


def c(n, nums):
    m = -10000
    for v in nums:
        if v > m:
            m = v
    return m


def run():
    n, nums = p()
    print(c(n, nums))


run()
