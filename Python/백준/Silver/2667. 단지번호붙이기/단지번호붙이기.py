n = int(input())
mapArray = []
visited = [[False for _ in range(n)] for _ in range(n)]
dxy = [(1,0), (-1,0), (0,1), (0,-1)]
partCount = 0
separateCount = 0
result = []

for _ in range(n):
  mapArray.append(list(map(int, input())))

def dfs(x, y):
  global separateCount, visited
  
  visited[x][y] = True
  separateCount += 1
  
  for move in dxy:
    nx = x + move[0]
    ny = y + move[1]
    if 0 <= nx < n and 0 <= ny < n:
      if not visited[nx][ny] and mapArray[nx][ny] == 1:
        dfs(nx, ny)

for xOffset in range(n):
  for yOffset in range(n):
    if not visited[xOffset][yOffset] and mapArray[xOffset][yOffset] == 1:
      partCount += 1
      separateCount = 0
      dfs(xOffset, yOffset)
      result.append(separateCount)

result.sort()
print(partCount)
for a in result:
  print(a)