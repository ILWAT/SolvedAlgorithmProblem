import Foundation

func solution(_ quiz:[String]) -> [String] {
    var answer: [String] = []
    for question in quiz {
        let subStrings = question.components(separatedBy: " ")
        let x: Int = Int(subStrings[0])!
        let cal = subStrings[1]
        let y: Int = Int(subStrings[2])!
        let quizAnswer: Int = Int(subStrings[4])!
        
        if cal == "+" {
            let calResult = x + y
            answer.append(generateOX(input: calResult == quizAnswer))
        } else if cal == "-" {
            let calResult = x - y
            answer.append(generateOX(input: calResult == quizAnswer))
        }
    }
    return answer
}

func generateOX(input: Bool) -> String {
    if input {
        return "O"
    } else {
        return "X"
    }
}