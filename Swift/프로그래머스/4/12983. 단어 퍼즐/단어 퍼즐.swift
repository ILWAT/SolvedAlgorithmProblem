import Foundation

func solution(_ strs:[String], _ t:String) -> Int{
    let INF = 20001
    let n = t.count
    
    let wordSet = Set(strs)
    let sizes = Array(Set(strs.map { $0.count }))
    
    var indices: [String.Index] = []
    indices.reserveCapacity(n + 1)
    var idx = t.startIndex
    indices.append(idx)
    for _ in 0..<n {
        idx = t.index(after: idx)
        indices.append(idx)
    }
    
    var dp = Array(repeating: INF, count: n + 1)
    dp[0] = 0
    
    for i in 0..<n {
        if dp[i] == INF { continue }
        
        for size in sizes {
            let next = i + size
            if next > n { continue }
            
            let start = indices[i]
            let end = indices[next]
            let sub = String(t[start..<end])
            
            if wordSet.contains(sub) {
                dp[next] = min(dp[next], dp[i] + 1)
            }
        }
    }
    
    return dp[n] < INF ? dp[n] : -1
}