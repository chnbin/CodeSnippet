# http://acm.timus.ru/print.aspx?space=1&num=1083
# 0.078 376KB
def computefactorials(n, k, reminder):
    if n == 1 and reminder != 0:
        return 1
    elif n == k and reminder == 0:
        return k
    else:
        return n * computefactorials(n-k, k, reminder)

n, k = input().split(" ")
k = len(k)

reminder = int(n) % int(k)
n = int(n)
k = int(k)

total=n

while n >= k:
    if reminder !=0:
        total = total * (n-k)
    elif reminder == 0 and n > k:
        total = total * (n-k)
    n = n - k

print(total)


