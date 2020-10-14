# https://algoprog.ru/material/p235 - in progress.

a, b, c = map(int, input().split())

if a != 0:
    x = (c * c - b) // a
    if a * x + b >= 0 and c >= 0:
        print(x)
    else:
        print("NO SOLUTION")
else:
    print("NO SOLUTION")
