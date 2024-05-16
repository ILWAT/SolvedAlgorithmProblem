from collections import deque

dx = [50, 0, 0, -50]
dy = [0, 50, -50, 0]
#dfs
def bfs(x, y, visited):
  global n, homeX, homeY, destX, destY, con
  queue = deque()
  queue.append((x, y))
  while queue:
    currentX, currentY = queue.popleft()
    if abs(destX - currentX) + abs(destY - currentY) <= 1000:
      return True
    for index in range(n):
      if visited[index]:
        continue
      elif abs(con[index][0] - currentX) + abs(con[index][1] - currentY) <= 1000:
        queue.append((con[index][0], con[index][1]))
        visited[index] = True
  return False


#입력
#테스트 케이스: T / 편의점 갯수: N
#offsetMap의 첫번째는 시작, 중간은 편의점, 마지막은 도착
t = int(input())

for _ in range(t):
  n = int(input())
  con = []
  homeX, homeY = map(int, input().split())
  for _ in range(n):
    con.append(list(map(int, input().split())))
  visited = [False for _ in range(n)]
  destX, destY = map(int, input().split())
  if bfs(homeX, homeY, visited):
    print("happy")
  else:
    print("sad")