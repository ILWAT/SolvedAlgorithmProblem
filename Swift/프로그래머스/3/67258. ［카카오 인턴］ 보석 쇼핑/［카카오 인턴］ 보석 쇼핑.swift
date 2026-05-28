import Foundation

func solution(_ gems:[String]) -> [Int] {
    var set: Set<String> = Set(gems)
    let gemsCount = set.count
    
    var dic: [String: Int] = [:]
    var answer: [Int] = [0, 0]
    var start = 0
    var min = Int.max
    
    for end in 0..<gems.count {
        let endGem = gems[end]
        dic[endGem] = (dic[endGem] ?? 0) + 1
        
        while dic.count == gemsCount {
            if (end - start < min) {
                min = end - start
                answer[0] = start + 1
                answer[1] = end + 1
            }
            
            let firstGem = gems[start]
            dic[firstGem] = (dic[firstGem] ?? 0) - 1
            if (dic[firstGem] ?? 0) <= 0 {
                dic.removeValue(forKey: firstGem)
            }
            
            start += 1
        }
    }
    
    return answer
}