N = int(input())
price = [*map(int, input().split())]

for i in range(1, N):
  for j in range(1, i//2+2):
    price[i] = max(price[i], price[i-j]+price[j-1])

print(price[N-1])