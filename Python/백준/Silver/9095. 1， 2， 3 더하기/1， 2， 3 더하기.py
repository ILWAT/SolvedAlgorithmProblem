memoi = [0 for _ in range(12)]
memoi[1] = 1
memoi[2] = 2
memoi[3] = 4

T = []

nCount = int(input())

for _ in range(nCount):
  T.append(int(input()))

for i in range(nCount):
  n = T[i]
  for j in range(4, n+1, +1):
    memoi[j] = memoi[j-1]+memoi[j-2]+memoi[j-3]
  print(memoi[n])