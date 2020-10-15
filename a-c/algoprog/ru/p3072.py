# https://algoprog.ru/material/p3072 - in progress.


def params():
    nums = []
    while True:
        x = int(input())
        if x == 0:
            break
        nums.append(x)
    return nums


def calc(nums):
    m = -10000
    mn = 0
    for n in nums:
        if n > m:
            mn = 1
            m = n
        elif n == m:
            mn += 1
    return mn


def run():
    nums = params()
    result = calc(nums)
    print(result)


run()
