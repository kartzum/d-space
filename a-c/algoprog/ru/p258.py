# https://algoprog.ru/material/p258 - in progress.


m = int(input())
n = int(input())
k = int(input())

if m >= k / n and n >= k / m:
    print("YES")
else:
    print("NO")
