# https://algoprog.ru/material/p1620

def check(ty):
    h = 0
    u = 0
    for i in range(len(tyu)):
        u -= 1
        if u < 1 and tyu[i] <= ty:
            h += 1
            u = c
    if h >= r:
        return True
    return False


n, r, c = map(int, input().split())
hs = sorted([int(input()) for line in range(n)])
tyu = [hs[i + c - 1] - hs[i] for i in range(len(hs) - c + 1)]

leg = -1
reg = hs[-1] - hs[0]
if r > 1:
    while leg + 1 != reg:
        m = (leg + reg) // 2
        if check(m):
            reg = m
        else:
            leg = m
    print(reg)
else:
    print(min(tyu))