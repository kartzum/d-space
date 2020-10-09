# https://algoprog.ru/material/p120 - comment.
# https://watermark.silverchair.com/11-2-229.pdf?token=AQECAHi208BE49Ooan9kkhW_Ercy7Dm3ZL_9Cf3qfKAc485ysgAAAqcwggKjBgkqhkiG9w0BBwagggKUMIICkAIBADCCAokGCSqGSIb3DQEHATAeBglghkgBZQMEAS4wEQQM3brqgO8JDd40OHcQAgEQgIICWvKIxp9PUv6EudSopmKdVYLZpH9J86Ai_fgjA3crjHZBUt0bnBAVJ4jP2wB7yy0rFFo94m5oYvwqXtHVqCpAzuHDekFdi5cdQ0HrCIcg3rgfvfj_jGGdSCURD3EhYru-es23X9Bi-kbzpaI3bx12xb-xpZfnwCIM_mxEG9Iu4yMihqOZLAXWPnzfo4Q-HC1lSgjbtqKjzdSloQsLdCwqleAhWJsJndflq6jXKku4YWjnImD-pboAreYKRMEDa97xFgaivxgUZ88UYmzZxZD_49SYG6IkCToKclSHd_mi9IACyQ8-UV5cWy73ei3kGDai4j5XXx3hiyUG_nXFsfK8X8M5YTRjRHB3pjOkB2ZeDcvTrRLZ8nuvo2lorcQqkZKcYUQGhdu6ZFKOfwmo5HF4LQNGze_xLxyilAGGNWPtRfOZGSXDyF8gmYwgOzSRzOBAmzTe9Cg6N1grFffWrJNMC6Mw63nRDhFy9zh28BlT-gS4Bp4va_DbNQB3RUaMaAl2k2eRvCxPQRUxH3j0nWzd2pKu0wuCkYIa9FzynUn9RbnXLiZTX6_1njK7qbCoQw30jxhVzKUclo8CLSlhOdgbJBCDlFG23FIbBBpcYW4WL0pcR2Mh79cOfNIscZYmmT3niHT1f06lQViN6oj1ZGJtUXxitH9jBsNkapgMIQoStR9ByuMpZEpvB8N89QHrgAiK-ukdt7Prt7Gkuh88NXw8l-G_Ge4mgXJASbgM_aZVRWBr5Ln9cJHEM-cRtUfq6lOhzDyDkz-8GG_mpjjpirRw-B_rtbtrLU43iQyy

debug = False
prod = True
test = False


def c(n):
    if n <= 0:
        return 1
    e = 1
    p = 1
    for i in range(1, n + 1):
        e = e + p / i
        p = p / i
    return e


def f():
    pass
    # import math
    # t = 0
    # for i in range(6):
    #    t += 1 / math.factorial(i)
    # return t


def tests():
    print(c(5))


if test:
    tests()

if prod:
    n = int(input())
    print(c(n))
