from collections import deque

n, m = map(int, input().split())
graph = []
dxy = [(-1, 0), (1, 0), (0, 1), (0, -1)]

for i in range(n):
    graph.append(list(map(int, input())))


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for move in dxy:
            dx = x + move[0]
            dy = y + move[1]
            if dx < 0 or dx >= m or dy < 0 or dy >= n:
                continue
            if graph[dy][dx] == 0:
                continue
            if graph[dy][dx] == 1:
                graph[dy][dx] = graph[y][x] + 1
                queue.append((dx, dy))
    return graph[n-1][m-1]


print(bfs(0, 0))