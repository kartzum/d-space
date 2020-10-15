# https://algoprog.ru/material/p506 - in progress.
# https://acmp.ru/asp/champ/index.asp?main=download&id=502


def params():
    k_lines_in_page, n_number_of_line = map(int, input().split())
    return k_lines_in_page, n_number_of_line


def calc(k_lines_in_page, n_number_of_line):
    n_number_of_line -= 1
    print(n_number_of_line // k_lines_in_page + 1, n_number_of_line % k_lines_in_page + 1)


def run():
    k_lines_in_page, n_number_of_line = params()
    calc(k_lines_in_page, n_number_of_line)


def tests():
    #  1        2         3
    # [1,2,3], [4,5,6], [7,8,9]
    # calc(3, 7)
    # 1                    2                      3
    # [1, 2, 3, 4, 5, 6], [7, 8, 9, 10, 11, 12], [13, 14, 15, 16, 17, 18]
    # calc(6, 12)
    # print(7 // 3, 6 // 3, 8 // 3)
    calc(50, 1)
    calc(20, 25)
    calc(15, 43)


run()
# tests()
