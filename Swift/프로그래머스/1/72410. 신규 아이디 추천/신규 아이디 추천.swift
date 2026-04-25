import Foundation

func solution(_ new_id:String) -> String {
    var answer = new_id
    
    // step 1
    answer = answer.lowercased()
    
    // step 2
    let allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789-_."
    answer = answer.filter { allowedChars.contains($0) }.map { String($0) }.joined()
    
    // step 3
    while answer.contains("..") {
        answer = answer.replacingOccurrences(of: "..", with: ".")
    }
    
    // step 4
    if answer.hasPrefix(".") {
        answer.removeFirst()
    }
    if answer.hasSuffix(".") {
        answer.removeLast()
    }
    
    // step 5
    if answer.isEmpty {
        answer = "a"
    }
    
    // step 6
    if answer.count >= 16 {
        let index = answer.index(answer.startIndex, offsetBy: 15)
        answer = String(answer[..<index])
        
        if answer.hasSuffix(".") {
            answer.removeLast()
        }
    }
    
    // step 7: 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 붙임
    while answer.count <= 2 {
        answer.append(answer.last!)
    }
    
    return answer
}