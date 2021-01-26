# https://algoprog.ru/material/p111589

# https://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.367.8868&rep=rep1&type=pdf
# https://stackoverflow.com/questions/24228398/memoryerror-on-my-python-code-how-to-optimize
# http://algolist.ru/olimp/ar_prb.php

k = int(input())


def find_digit(k):
    start = 0
    while k:
        start += 1
        length = k.bit_length()
        k -= 2 ** (length - 1)
    return start % 3


print(find_digit(k - 1))
