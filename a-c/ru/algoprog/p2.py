# https://algoprog.ru/material/p2

n, k = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

for i in b:
    l = 0
    r = n - 1
    while r - l > 1:
        M = (r + l) // 2
        if a[M] < i:
            l = M
        else:
            r = M
    if i - a[l] <= a[r] - i:
        print(a[l])
    else:
        print(a[r])
