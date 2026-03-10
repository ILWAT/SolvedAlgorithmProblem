import Foundation

func solution(_ k: Int, _ m: Int, _ score: [Int]) -> Int {
    let sortedScore = score.sorted(by: { $0 > $1 })
    var count = 0
    var answer = 0
    
    for item in sortedScore {
        count += 1
        if count == m {
            answer += (item * m)
            count = 0
        }
    }
    
    return answer
}
