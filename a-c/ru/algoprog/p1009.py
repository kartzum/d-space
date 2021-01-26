# https://algoprog.ru/material/p1009

n = int(input())


def f(n):
    result = []
    d = 2
    while d * d <= n:
        if n % d == 0:
            result.append(d)
            n //= d
        else:
            d += 1
    if n > 1:
        result.append(n)
    return result


def calc(n):
    lst = f(n)
    s = set(lst)

    num = 1
    for i in s:
        a = lst.count(i)
        temp = i
        while temp < a:
            a = a % 2 + a // 2
            temp *= i
        num *= temp

    return num


print(calc(n))
