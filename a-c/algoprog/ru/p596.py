# https://algoprog.ru/material/p596 - comment.

x = int(input())
y = int(input())


def c(x, y):
    k = 2
    while (True):
        if x + x * 0.7 <= y:
            x += x * 0.7
            k += 1
        else:
            break
    return k


print(c(10, 50))
