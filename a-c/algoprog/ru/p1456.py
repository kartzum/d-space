# https://algoprog.ru/material/p1456 - in progress.


def params():
    n = int(input())
    nums = list(map(int, input().split()))
    k = int(input())
    return n, nums, k


def calc(n, nums, k):
    left = 0
    right = len(nums) - 1
    while left <= right:
        pivot = (right + left) // 2
        if nums[pivot] == k:
            return pivot - 1
        elif k > nums[pivot]:
            right = pivot - 1
        else:
            left = pivot + 1
    return left + 1


def tests():
    print(calc(8, [165, 163, 160, 160, 157, 157, 155, 154], 162))
    print(calc(3, [165, 163, 160], 164))
    print(calc(3, [165, 165, 165], 166))


def run():
    n, nums, k = params()
    print(calc(n, nums, k))


run()

# tests()
