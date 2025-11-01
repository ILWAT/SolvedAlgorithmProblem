import Foundation

var parent: [Int] = []

func solution(_ n:Int, _ costs:[[Int]]) -> Int {
    let orderCosts = costs.sorted(by: { $0[2] < $1[2] })
    
    parent = []
    
    for i in 0..<n {
        parent.append(i)
    }
    
    var answer: Int = 0
    var edges: Int = 0
    
    for edge in orderCosts {
        if edges == n-1 {
            break
        }
        
        if find(edge[0]) != find(edge[1]) {
            union(edge[0], edge[1])
            answer += edge[2]
            edges += 1
        }
    }
    
    return answer
}

func find(_ x: Int) -> Int {
    if parent[x] == x {
        return x
    } else {
        let result: Int = find(parent[x])
        parent[x] = result
        return result
    }
}

func union(_ x: Int, _ y: Int) {
    let root1: Int = find(x)
    let root2: Int = find(y)
    
    parent[root2] = root1
}