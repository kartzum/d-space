# https://algoprog.ru/material/p111648

import itertools

n, *s = list(map(int, input().split()))

min_len = 3


def calc(s: list, res=0) -> int:
    c = 0
    for num, group in itertools.groupby(s):
        lg = len(list(group))
        c += lg
        if lg >= min_len:
            return calc(s[:c - lg] + s[c:], res + lg)
    return res


print(calc(s))
