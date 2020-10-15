# https://algoprog.ru/material/p506 - in progress.

k, t = map(int, input().split())
temp = (t - 1) % (2 * k)
print(k - abs(temp - k + 1))
