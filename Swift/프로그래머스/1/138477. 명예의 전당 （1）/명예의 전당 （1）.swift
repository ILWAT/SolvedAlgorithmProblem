import Foundation

func solution(_ k:Int, _ score:[Int]) -> [Int] {
    var answer: [Int] = []
    var list: [Int] = []
    for singer in score {
        if list.count < k {
            list.append(singer)
        } else if let first = list.first, first < singer {
            list.removeFirst()
            list.append(singer)
        }
        
        list.sort(by: { $0 < $1 })
        answer.append(list.first ?? 0)
    }
    return answer
}