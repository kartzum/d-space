# https://algoprog.ru/material/p264 - in progress.

n = int(input())


def check(n):
    if n <= 2 or n == 4 or n == 7:
        return "NO"
    v3 = n % 3
    v5 = n % 5
    if v3 == v5 == 2:
        return "NO"
    return "YES"


print(check(n))
