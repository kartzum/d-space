# https://algoprog.ru/material/p3077


prev = -1
cur = 0
m = 0
v = int(input())
while v != 0:
    if prev == v:
        cur += 1
    else:
        prev = v
        m = max(m, cur)
        cur = 1
    v = int(input())
m = max(m, cur)
print(m)
