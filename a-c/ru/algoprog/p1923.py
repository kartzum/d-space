# https://algoprog.ru/material/p1923

w, h, n = map(int, input().split())
l = max(w, h)
r = l * n
while r - l > 1:
    m = (r + l) // 2
    res = (m // w) * (m // h)
    if res < n:
        l = m
    else:
        r = m
print(r)
