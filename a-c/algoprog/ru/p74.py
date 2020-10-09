# https://algoprog.ru/material/p74 - comment.
# https://notes.algoprog.ru/python_basics/5_float.html

# from math import *

eps = 1e-7

a = float(input())
b = float(input())
c = float(input())

if abs(a + b - c) < eps:
    print("YES")
else:
    print("NO")
