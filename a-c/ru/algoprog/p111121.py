# https://algoprog.ru/material/p111121

# https://www.cyberforum.ru/python-beginners/thread2677798.html
# https://ideone.com/G8bmax

n, x = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

d = [(n - 1, b[n - 1])] * n
mxi = n - 1
mx = b[n - 1]
for i in range(n - 2, -1, -1):
    if b[i] > mx:
        mxi = i
        mx = b[i]
    d[i] = (mxi, mx)

top = x
top_buy = -1
top_sell = -1
m = 0
top_sell_new = 0

for i in range(n):
    h = x // a[i]
    o = x % a[i]
    if top_sell < i + 1:
        top_sell_new = d[i][0] + 1

    m = d[i][1]
    if m * h + o > top:
        top = m * h + o
        top_buy = i + 1
        top_sell = top_sell_new

print(top)
print(top_buy, top_sell)
