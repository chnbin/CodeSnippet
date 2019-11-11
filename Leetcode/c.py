n = int(input())
dp = [0] * (n + 1)
m = int(input())

dp[0] = 1
dp[1] = 1

for i in range(m):
    a = int(input())
    dp[a] = -1
print(dp)
for i in range(2, len(dp)):
    if dp[i] == -1:
        dp[i] = 0
    else:
        dp[i] = dp[i-1] + dp[i-2]

print(dp[len(dp)-1] % 1000000007)
