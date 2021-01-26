# https://algoprog.ru/material/p111121

n, x = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

top = x
top_buy = -1
top_sell = -1
m = 0
top_sell_new = 0

for i in range(n):
    h = x // a[i]
    o = x % a[i]
    if top_sell < i + 1:
        c = b[i:]
        m = max(c)
        top_sell_new = c.index(m) + i + 1
    if m * h + o > top:
        top = m * h + o
        top_buy = i + 1
        top_sell = top_sell_new

print(top)
print(top_buy, top_sell)
