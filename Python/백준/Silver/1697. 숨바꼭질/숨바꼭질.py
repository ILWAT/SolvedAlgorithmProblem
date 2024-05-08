from collections import deque

n, k = map(int, input().split())
visited = [False for _ in range(100001)]

def bfs(start, dest, visited):
  queue = deque()
  queue.append((start, 0))
  visited[start] = True
  
  while queue:
    parentsNode, second = queue.popleft()
    if parentsNode == dest:
      return second
    for childNode in (parentsNode - 1, parentsNode + 1, parentsNode * 2):
      if childNode < 0 or childNode > 100000:
        continue
      else:
        if not visited[childNode]:
          visited[childNode] = True
          queue.append((childNode, second + 1))
      
print(bfs(n, k, visited))