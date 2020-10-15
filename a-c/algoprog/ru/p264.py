# https://algoprog.ru/material/p264 - in progress.

n = int(input())


def check(n):
    if n != 0 and n != 1 and n != 2 and n != 4 and n != 7:
        return "YES"
    return "NO"


print(check(n))
