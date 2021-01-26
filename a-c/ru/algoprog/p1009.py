# https://algoprog.ru/material/p1009

# https://pastebin.com/sQctvtdL
# https://infourok.ru/dlinnaya-arifmetika-na-c-opisanie-modeli-realizaciya-zadachi-1959820.html
# https://ru.stackoverflow.com/questions/1184457/%D0%9F%D0%BE%D0%BC%D0%BE%D0%B3%D0%B8%D1%82%D0%B5-%D1%80%D0%B5%D1%88%D0%B8%D1%82%D1%8C-%D0%B7%D0%B0%D0%B4%D0%B0%D1%87%D1%83-%D0%A1%D1%82%D0%B5%D0%BF%D0%B5%D0%BD%D0%B8

def f(n):
    result = []
    d = 2
    while d * d <= n:
        if n % d == 0:
            result.append(d)
            n //= d
        else:
            d += 1
    if n > 1:
        result.append(n)
    return result


x = int(input())


def calc(x):
    if x == 1:
        return 1
    else:
        a = list(set(f(x)))
        y = 1
        for i in range(len(a)):
            y *= a[i]
        if a[0] != x:
            for i in range(40):
                t = (i + 1) * y
                if pow(t, t, x) == 0:
                    return (i + 1) * y
        else:
            return a[0]


print(calc(x))
