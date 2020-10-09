# https://algoprog.ru/material/p595 - in progress.

prod = True
test = False

eps = 1e-7


def read():
    xyz = input().split()
    x = float(xyz[0])
    y = float(xyz[1])
    z = float(xyz[2])
    n = int(input())
    t = []
    for i in range(n):
        abcq = input().split()
        a = float(abcq[0])
        b = float(abcq[1])
        c = float(abcq[2])
        q = float(abcq[3])
        l = [a, b, c, q]
        t.append(l)
    return x, y, z, t


def c(x, y, z, t):
    a = 0
    b = 0
    c = 0
    for l in t:
        a += l[0] * l[3]
        b += l[1] * l[3]
        c += l[2] * l[3]

    result = (a >= x - eps) and (b >= y - eps) and (c >= z - eps)
    return result


def tests():
    r1 = c(x=1.0, y=1.0, z=1.0, t=[
        [1, 0, 0, 1],
        [0, 0.5, 0, 2],
        [0, 0, 0.3, 4]
    ])
    if r1:
        print("YES")
    else:
        print("NO")


if test:
    tests()

if prod:
    x, y, z, t = read()
    r = c(x, y, z, t)
    if r:
        print("YES")
    else:
        print("NO")
