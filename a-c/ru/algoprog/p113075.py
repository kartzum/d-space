# https://algoprog.ru/material/p113075

# https://pastebin.com/ShvrTc5q

n, k = map(int, input().split())
a = list(map(int, input().split()))

s = a[0]
a[0] = 0
a.append(n)
dist = k
fuel = 0
i = 0

while i < len(a) - 1:
    dist = k
    while (i < len(a) - 1) and (dist >= a[i + 1] - a[i]):
        dist -= a[i + 1] - a[i]
        i += 1
    if dist == k:
        fuel = -1
        break
    if i != len(a) - 1:
        fuel += 1

print(fuel)
