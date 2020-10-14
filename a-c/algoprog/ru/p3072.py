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
    for v in nums:
        if v > m:
            m = v
    count = 0
    for v in nums:
        if v == m:
            count += 1
    return count


def run():
    nums = params()
    result = calc(nums)
    print(result)


run()
