# https://algoprog.ru/material/p3612 - completed.


h = int(input())
m = int(input())
s = int(input())


def c(h, m, s):
    v = v = (h + m / 60.0 + s / 3600.0) * (360 / 12)
    print(v)


c(h, m, s)
