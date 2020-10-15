def nm():
    n, m = map(int, input().split())
    return n, m


def ar_int_with_zero():
    nums = []
    while True:
        x = int(input())
        if x == 0:
            break
        nums.append(x)
    return nums


def ar_int_one_line():
    nums = list(map(int, input().split()))
    return nums
