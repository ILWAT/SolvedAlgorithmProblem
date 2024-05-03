import copy
from collections import deque

n, m, v = map(int, input().split())

graph = [[] for _ in range(n)]
visited = [False for number in range(n)]
visited2 = copy.deepcopy(visited)

for _ in range(m):
    first, second = map(int, input().split())
    graph[first-1].append(second)
    graph[second-1].append(first)

for vertexNumber in range(n):
    graph[vertexNumber-1].sort()


def dfs(graph, number, visited):
    visited[number-1] = True
    print(number, end=' ')
    for vertex in graph[number-1]:
        if visited[vertex-1] == False:
            dfs(graph, vertex, visited)





def bfs(graph, number, visited):
    queue = deque([number])

    visited[number-1] = True
    print(number, end=' ')

    while queue:
        v = queue.popleft()

        for i in graph[v-1]:
            if not visited[i-1]:
                queue.append(i)
                visited[i-1] = True
                print(i, end=' ')



dfs(graph, v, visited)
print()
bfs(graph, v, visited2)