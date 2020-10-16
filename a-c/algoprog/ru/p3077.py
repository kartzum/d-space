# https://algoprog.ru/material/p3077 - in progress.


def params():
    nums = []
    while True:
        x = int(input())
        if x == 0:
            break
        nums.append(x)
    return nums


def calc(nums):
    mm = 0
    mc = 1
    prev = 0
    for current in nums:
        if prev == current:
            mc += 1
        elif mc > mm:
            mm = mc
            mc = 1
        else:
            mc = 1
        prev = current
    return mm


def run():
    nums = params()
    result = calc(nums)
    print(result)


run()
