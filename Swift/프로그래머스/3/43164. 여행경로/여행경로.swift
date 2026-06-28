import Foundation

var answer: [String] = []
var visited: [String : [Bool]] = [:]
var roadMap: [String : [String]] = [:]

func solution(_ tickets:[[String]]) -> [String] {
    for ticket in tickets {
        var roads = roadMap[ticket[0]] ?? []
        roads.append(ticket[1])
        roadMap[ticket[0]] = roads
    }
    
    for key in roadMap.keys {
        roadMap[key] = roadMap[key]!.sorted(by: { $0 < $1 }) 
        visited[key] = .init(repeating: false, count: roadMap[key]!.count)
    }
    
    dfs("ICN", "ICN", tickets.count, 0)
    
    return answer.first!.split(separator: " ").map { String($0) }
}


func dfs(_ current: String, _ path: String, _ totalTickets: Int, _ count: Int) {
    if (count == totalTickets) {
        answer.append(path)
        return
    }
    
    guard let neighbors = roadMap[current], let _ = visited[current] else { return }
    
    for i in 0..<neighbors.count {
        if !visited[current]![i] {
            visited[current]![i] = true
            let next = neighbors[i]
            
            dfs(next, path + " " + next, totalTickets, count + 1)
            
            visited[current]![i] = false
        }
    }
    
}