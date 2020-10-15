# https://algoprog.ru/material/p235 - in progress.

a, b, c = map(int, input().split())

if a == 0 and c >= 0:
    print("NO SOLUTION")
elif a == 0 and c < 0:
    print("NO SOLUTION")
elif c >= 0:
    x = (c * c - b) // a
    print(x)
else:
    print("NO SOLUTION")
