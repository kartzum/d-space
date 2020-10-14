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
    count = 1
    result = 1
    for i in range(1, len(nums)):
        if nums[i-1] != nums[i]:
            count = 1
        else:
            count += 1
            result = max(count, result)
    return result


def run():
    nums = params()
    result = calc(nums)
    print(result)


run()
