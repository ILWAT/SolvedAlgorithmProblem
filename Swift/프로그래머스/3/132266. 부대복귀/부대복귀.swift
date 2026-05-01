import Foundation

func solution(_ n:Int, _ roads:[[Int]], _ sources:[Int], _ destination:Int) -> [Int] {
    var adj: [[Int]] = Array(repeating: [], count: n+1)
    
    for road in roads {
        let point1 = road[0]
        let point2 = road[1]
        adj[point1].append(point2)
        adj[point2].append(point1)
    }
    
    let timeTable = bfs(destination, n, adj)
    
    var answer: [Int] = []
    for startPoint in sources {
        answer.append(timeTable[startPoint])
    }
    return answer
}

func bfs(_ start: Int, _ n: Int, _ adj: [[Int]]) -> [Int] {
    var timeTable: [Int] = Array(repeating: -1, count: n+1)
    
    var visited: [Bool] = Array(repeating: false, count: n+1)
    
    var ad: [Int] = []
    var currentIndex = 0;
    
    visited[start] = true
    ad.append(start)
    timeTable[start] = 0;
    
    while ad.count > currentIndex {
        let currentPoint = ad[currentIndex]
        for i in 0..<adj[currentPoint].count {
            let nextPoint = adj[currentPoint][i]
            if !visited[nextPoint] {
                visited[nextPoint] = true;
                ad.append(nextPoint)
                timeTable[nextPoint] = timeTable[currentPoint] + 1;
            }
        }
        currentIndex += 1
    }
    
    return timeTable
}