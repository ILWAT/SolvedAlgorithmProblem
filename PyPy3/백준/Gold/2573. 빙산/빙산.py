from collections import deque
import copy
#행: n 열: m
#탐색: 덩이가 몇개인지 탐색해야 한다. -> BFS, DFS
#변경: 빙산이 1년뒤에 얼마나 녹는지를 반영해야 한다. -> 상하좌우에 물이 얼마나 있는지 확인
array = []
time = 0

#덩이를 파악하면서 1년후에 얼마나 녹는지를 파악한다.
def bfs(x, y, visited):
  global n, m, array, newArray
  queue = deque()
  queue.append((x, y))
  visited[y][x] = True
  while queue:
    x, y = queue.popleft()
    for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
      nx = x + dx
      ny = y + dy
      if nx < 0 or nx >= m or ny < 0 or ny >= n:
        continue
      if array[ny][nx] <= 0:
        newArray[y][x] -= 1
      elif not visited[ny][nx]:
        queue.append((nx, ny))
        visited[ny][nx] = True
    


#입력
n, m = map(int, input().split())

for _ in range(n):
  array.append(list(map(int, input().split())))

newArray = copy.deepcopy(array)
#탐색
while True:
  visited = [[False] * m for _ in range(n)]
  partCount = 0
  for y in range(n):
    for x in range(m):
      if array[y][x] > 0 and not visited[y][x]:
        bfs(x, y, visited)
        partCount += 1
      if partCount >= 2:
        break
    if partCount >= 2:
      break
  if partCount == 0:
    time = 0
    break
  elif partCount >= 2:
    break
  time += 1
  array = copy.deepcopy(newArray)
  

print(time)