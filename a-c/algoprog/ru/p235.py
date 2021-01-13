# https://algoprog.ru/material/p235

a, b, c = map(int, input().split())

if a == 0 and c >= 0:
    if c * c == b:
        print("MANY SOLUTIONS")
    else:
        print("NO SOLUTION")
elif a == 0 and c < 0:
    print("NO SOLUTION")
elif ((c * c - b) % a == 0) and (c >= 0):
    print((c * c - b) // a)
else:
    print("NO SOLUTION")
