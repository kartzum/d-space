# https://algoprog.ru/material/p506 - in progress.

k, t = map(int, input().split())
n = t % (2 * k)
if n > k: n = 2 * k - n
print(n)
