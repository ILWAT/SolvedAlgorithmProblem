import Foundation

func solution(_ numbers:[Int]) -> Int {
    var answer = 0
    
    for i in 0..<10 {
        guard !numbers.contains(i) else { continue }  
        answer += i
    }
    
    return answer
}