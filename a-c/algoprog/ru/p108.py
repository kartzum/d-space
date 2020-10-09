# https://algoprog.ru/material/p108 - in progress.

def c(p):
    l = 0
    r = len(p) - 1
    while l < r:
        lc = p[l]
        rc = p[r]
        if lc != rc:
            return False
        l += 1
        r -= 1
    return True


p = input()
if c(p):
    print("yes")
else:
    print("no")
