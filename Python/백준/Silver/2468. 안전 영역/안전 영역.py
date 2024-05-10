import sys
sys.setrecursionlimit(100000)

n = int(input())
array = []
dxy = [(1,0), (0, 1), (-1, 0), (0, -1)]
resultCount = 0

for i in range(n):
  array.append(list(map(int, input().split())))

maxHeight = max(map(max, array))


def dfs(x, y, height, visited):
  global array, dxy, n
  visited[y][x] = True
  for move in dxy:
    nx = x + move[0]
    ny = y + move[1]
    if nx < 0 or nx >= n or ny < 0 or ny >= n:
      continue
    if array[ny][nx] > height and not visited[ny][nx]:
      dfs(nx, ny, height, visited)
      

for height in range(maxHeight+1):
  visited = [[False] * n for _ in range(n)]
  count = 0
  for y in range(n):
    for x in range(n):
      if array[y][x] > height and not visited[y][x]:
        dfs(x, y, height, visited)
        count += 1
  resultCount = max(resultCount, count)
  

print(resultCount)