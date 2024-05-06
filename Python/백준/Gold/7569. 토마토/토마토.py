from collections import deque

dxyh = [(1,0,0), (0,1,0), (0,0,1), (-1,0,0), (0,-1,0), (0,0,-1)]
dayCount = 0
queue = deque()
  
def bfs():
  global n, m, h, queue, tomatoBox
  
  while queue:
    x, y, z = queue.popleft()
    for move in dxyh:
          dx = x+move[0]
          dy = y+move[1]
          dh = z+move[2]
          if dx < 0 or dx >= m or dy < 0 or dy >= n or dh < 0 or dh >= h:
            continue
          if tomatoBox[dh][dy][dx] == 0:
            queue.append((dx, dy, dh))
            tomatoBox[dh][dy][dx] = tomatoBox[z][y][x]+1


m, n, h = map(int, input().split())

#3차원 구조를 다뤄야 하니 3차원 배열 사용
tomatoBox = []

for _ in range(h):
  fBox = []
  for _ in range(n):
    fBox.append(list(map(int, input().split())))
  tomatoBox.append(fBox)

for hOffset in range(h):
  for yOffset in range(n):
    for xOffset in range(m):
      if tomatoBox[hOffset][yOffset][xOffset] == 1:
        queue.append((xOffset, yOffset, hOffset))

bfs()

exit = False
for hOffset in range(h):
  for yOffset in range(n):
    for xOffset in range(m):
      if tomatoBox[hOffset][yOffset][xOffset] == 0:
        dayCount = -1
        exit = True
        break
      else:
        dayCount = max(dayCount, tomatoBox[hOffset][yOffset][xOffset]-1)
    if exit:
      break
  if exit:
    break

print(dayCount)
      