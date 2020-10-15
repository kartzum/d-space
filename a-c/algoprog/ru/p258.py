# https://algoprog.ru/material/p258 - in progress.


m = int(input())
n = int(input())
k = int(input())

if k <= m % n and k <= n % m:
    print("YES")
else:
    print("NO")
