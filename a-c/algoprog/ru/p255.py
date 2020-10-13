# https://algoprog.ru/material/p255 - in progress.

r1 = int(input())
c1 = int(input())

r2 = int(input())
c2 = int(input())

if abs(r1 - r2) == abs(c1 - c2):
    print("YES")
else:
    print("NO")
