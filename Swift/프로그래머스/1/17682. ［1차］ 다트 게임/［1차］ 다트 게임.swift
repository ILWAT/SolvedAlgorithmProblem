func solution(_ dartResult:String) -> Int {
    var scores: [Int] = []
    var currentNumber = ""
    
    let dartArray = Array(dartResult)
    let numSet: Set<Character> = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "0"]
    
    for i in 0..<dartArray.count {
        let char = dartArray[i]
        
        if numSet.contains(char) {
            currentNumber.append(char)
        } else if char == "S" || char == "D" || char == "T" {
            guard let score = Int(currentNumber) else { continue }
            
            if char == "S" {
                scores.append(score)
            } else if char == "D" {
                scores.append(score * score)
            } else if char == "T" {
                scores.append(score * score * score)
            }
            currentNumber = ""
        } else if char == "*" {
            let count = scores.count
            if count >= 1 {
                scores[count - 1] *= 2
            }
            if count >= 2 {
                scores[count - 2] *= 2
            }
        } else if char == "#" {
            let count = scores.count
            if count >= 1 {
                scores[count - 1] *= -1
            }
        }
    }
    
    var answer = 0
    for score in scores {
        answer += score
    }
    return answer
}