import Foundation

var visited: [Bool] = []
var com: [[Int]] = []

func solution(_ n:Int, _ computers:[[Int]]) -> Int {
    var result: Int = 0
    com = computers
    visited = .init(repeating: false, count: n)
    
    for i in 0..<n {
        guard !visited[i] else { continue }
        dfs(i)
        result += 1
    }
    
    return result
}

func dfs(_ current: Int) {
    visited[current] = true
    
    let connecting = com[current]
    for i in 0..<connecting.count {
        guard i != current else { continue }
        guard connecting[i] == 1, !visited[i] else { continue }
        dfs(i)
    }
}
