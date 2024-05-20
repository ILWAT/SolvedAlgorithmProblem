n = int(input())
price = [0]
priceList = list(map(int, input().split()))

for element in priceList:
  price.append(element)

memoi = [0] * (n+1) #dp 테이블

# 상향식
for i in range(1, n+1):
  for j in range(1, i+1):
    memoi[i] = max(memoi[i], memoi[i-j] + price[j])

    
      
print(memoi[n])