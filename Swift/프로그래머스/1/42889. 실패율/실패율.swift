import Foundation

func solution(_ N:Int, _ stages:[Int]) -> [Int] {
    var stageCount: [Int] = Array(repeating: 0, count: N+2)
    for stage in stages {
        stageCount[stage] += 1;
    }
    
    var result: [(Int, Double)] = []
    var totalPlayer: Int = stages.count
    
    for i in 1...N {
        let failRate: Double
        if totalPlayer > 0 {
            failRate = Double(stageCount[i]) / Double(totalPlayer)
            totalPlayer -= stageCount[i]
        } else {
            failRate = 0
        }
        
        result.append((i, failRate))
    }
    
    return result.sorted(by: {(a, b) in
        return (a.1 == b.1) ? (a.0 < b.0) : (a.1 > b.1)
    }).map(\.0)
}