# https://algoprog.ru/material/p111648

m = 1
k = 0
n, *s = list(map(int,input().split())) + [10]
while m!=k:
    m=k
    i = 0
    while i < len(s) - 2:
        if s[i]==s[i+1] and s[i]==s[i+2]:
            k+=3
            del s[i+2]
            del s[i+1]
            while s[i]==s[i+1]:
                k+=1
                del s[i+1]
            del s[i]
            break
        i+=1
print(k)