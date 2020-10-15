# https://algoprog.ru/material/p1456 - in progress.


def params():
    n = int(input())
    nums = list(map(int, input().split()))
    k = int(input())
    return n, nums, k


def calc(n, nums, k):
    p = n + 1
    for i in range(len(nums)):
        if k > nums[i]:
            p = i + 1
            break
    return p


def tests():
    print(calc(8, [165, 163, 160, 160, 157, 157, 155, 154], 162))
    print(calc(3, [165, 163, 160], 164))
    print(calc(3, [165, 165, 165], 166))
    print(calc(3, [165, 165, 165], 163))


def run():
    n, nums, k = params()
    print(calc(n, nums, k))


run()

# tests()
