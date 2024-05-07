n = int(input())
x, y = map(int, input().split())
count = int(input())

tree = [[] for _ in range(n)]
visited = [False for _ in range(n)]

for _ in range(count):
  a, b = map(int, input().split())
  tree[a-1].append(b-1)
  tree[b-1].append(a-1)

def dfs(start, dest, visited, count):
  visited[start] = True
  for node in tree[start]:
    if node == dest:
      return count + 1
    if not visited[node]:
      result = dfs(node, dest, visited, count+1)
      if result != -1:
        return result
  return -1

print(dfs(x-1, y-1, visited, 0))