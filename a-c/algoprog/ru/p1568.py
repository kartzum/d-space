# https://algoprog.ru/material/p1568 - in progress.


def params():
    nums = list(map(int, input().split()))
    del nums[-1]
    return nums


def calc(nums):
    result = [0, 0, 0, 0, 0, 0, 0, 0, 0]
    for n in nums:
        result[n - 1] += 1
    return result


def run():
    nums = params()
    result = calc(nums)
    for x in result:
        print(x, end=" ")


run()
