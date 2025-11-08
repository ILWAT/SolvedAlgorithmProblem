import Foundation

func solution(_ N:Int, _ road:[[Int]], _ k:Int) -> Int {
    var adjList: [[Node]] = .init(repeating: [], count: N+1)
    
    for edge in road {
        adjList[edge[0]].append(Node(edge[1], edge[2]))
        adjList[edge[1]].append(Node(edge[0], edge[2]))
    }
    
    var dist: [Int] = .init(repeating: .max, count: N+1)
    
    var pq: [Node] = [Node(1, 0)]
    dist[1] = 0
    
    while (!pq.isEmpty) {
        var now = pq.removeFirst()
        
        guard dist[now.dest] >= now.cost else { continue }
        
        for next in adjList[now.dest] {
            if dist[next.dest] > (now.cost + next.cost) {
                dist[next.dest] = now.cost + next.cost
                pq.append(Node(next.dest, dist[next.dest]))
            }
        }
    }
    
    var answer = 0
    
    for i in 1...N {
        if dist[i] <= k {
            answer += 1
        }
    }

    return answer
}

struct Node {
    let dest: Int
    let cost: Int
    
    init(_ dest: Int, _ cost: Int) {
        self.dest = dest
        self.cost = cost
    }
}

