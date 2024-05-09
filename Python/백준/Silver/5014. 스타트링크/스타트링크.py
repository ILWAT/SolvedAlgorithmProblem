from collections import deque
#전체 층: f, 시작 층: s, 목표 층: g, up: u, down: d
f, s, g, u, d = map(int, input().split())
visited = [False for _ in range(f)]

def bfs(start, dest, visited):
  queue = deque()
  queue.append((start, 0))
  visited[start-1] = True
  while queue:
    parentsNode, count = queue.popleft()
    if parentsNode == dest:
      return count
    for childNode in (parentsNode + u, parentsNode - d):
      if childNode < 1 or childNode > f:
        continue
      elif not visited[childNode-1]:
        visited[childNode-1] = True
        queue.append((childNode, count+1))
  return -1

result = bfs(s, g, visited)
if result == -1:
  print("use the stairs")
else:
  print(result)
  