import Foundation

func solution(_ want:[String], _ number:[Int], _ discount:[String]) -> Int {
    var target: [String: Int] = [:]
    
    for i in 0 ..< want.count {
        target[want[i]] = number[i]
    }
    
    var answer = 0
    for i in 0 ..< discount.count-9 {
        var itemsFor10d: [String: Int] = [:]
        for j in i ..< i+10 {
            let item = discount[j]
            if let _ = target[item] {
                itemsFor10d[item] = (itemsFor10d[item] ?? 0) + 1
            }
        }
        
        if itemsFor10d == target {
            answer += 1
        }
    }
    return answer
}