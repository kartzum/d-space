n = int(input())

def calc(left, right, out):
    if right==0:
        return
    elif left==0:
        print(out+right*")")
    elif left==right:
        calc(left-1, right, out+"(")
    else:
        calc(left-1, right, out+"(")
        calc(left, right-1, out+")")

calc(n,n,"")
