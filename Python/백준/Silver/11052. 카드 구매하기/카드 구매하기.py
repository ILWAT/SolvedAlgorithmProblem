n = int(input())
price = [0]
priceList = list(map(int, input().split()))

for element in priceList:
  price.append(element)

memoi = [0] * (n+1) #dp 테이블

# 원하는 카드 갯수를 구매하는 방법
# 1. 처음부터 갯수에 맞는 카드를 구매 
# 2. 원하는 카드 갯수-1 & 1개 카드 구매
# 3. 원하는 카드 갯수의 공약수 구매
# 4. 1개 구매 (memoi[0]*n)
# 상향식
for i in range(1, n+1):
  for j in range(1, i+1):
    memoi[i] = max(memoi[i], memoi[i-j] + price[j])

    
      
print(memoi[n])