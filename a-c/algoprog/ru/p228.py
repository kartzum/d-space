# https://algoprog.ru/material/p228 - in progress.


def p():
    n = int(input())
    nums = list(map(int, input().split()))
    return n, nums


def c(n, nums):
    m = -10000
    i = -1
    for k in range(n):
        v = nums[k]
        if v > m:
            m = v
            i = k

    return i


def run():
    n, nums = p()
    print(c(n, nums) + 1)


run()
