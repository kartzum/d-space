# https://algoprog.ru/material/p258


m = int(input())
n = int(input())
k = int(input())

if ((k % m == 0) or (k % n == 0)) and (m * n >= k):
    print("YES")
else:
    print("NO")
