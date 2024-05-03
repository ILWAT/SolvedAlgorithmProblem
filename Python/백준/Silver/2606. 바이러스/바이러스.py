vertex = int(input())
edge = int(input())
graph = [[] for _ in range(vertex)]
visited = [False for _ in range(vertex)]
result = 0

for _ in range(edge):
  a, b = map(int, input().split())
  graph[a-1].append(b)
  graph[b-1].append(a)

def dfs(x):
  global result
  targetVertex = x - 1
  visited[targetVertex] = True
  for connected in graph[targetVertex]:
    if not visited[connected-1]:
      dfs(connected)
      result += 1


dfs(1)
print(result)