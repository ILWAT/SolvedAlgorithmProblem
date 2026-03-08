import Foundation

func solution(_ s: String) -> Int {
    var answer = 0
    var firstChar: Character? = nil
    var sameCount = 0
    var diffCount = 0
    
    for char in s {
        if firstChar == nil {
            firstChar = char
            sameCount = 1
            continue
        }
        
        if char == firstChar {
            sameCount += 1
        } else {
            diffCount += 1
        }
        
        if sameCount == diffCount {
            answer += 1
            firstChar = nil
            sameCount = 0
            diffCount = 0
        }
    }
    
    if firstChar != nil {
        answer += 1
    }
    
    return answer
}