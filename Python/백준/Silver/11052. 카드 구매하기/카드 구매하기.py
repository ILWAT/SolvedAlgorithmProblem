n = int(input())
price = list(map(int, input().split()))

memoi = [0] * n #dp 테이블

# 원하는 카드 갯수를 구매하는 방법
# 1. 처음부터 갯수에 맞는 카드를 구매 
# 2. 원하는 카드 갯수-1 & 1개 카드 구매
# 3. 원하는 카드 갯수의 공약수 구매
# 4. 1개 구매 (memoi[0]*n)
# 상향식
for i in range(n):
  memoi[i] = price[i]
  for j in range(i-1, -1, -1):
    if j == 0:
      memoi[i] = max(memoi[i], memoi[j]*(i+1))
      continue
      
    if (i+1) % (j+1) == 0:
      memoi[i] = max(memoi[i], memoi[j] * ((i+1)//(j+1)))
    
    k = i-j-1
    if k >= 0 and k <= j:
      memoi[i] = max(memoi[i], memoi[j]+memoi[k])

    
      
print(memoi[n-1])

