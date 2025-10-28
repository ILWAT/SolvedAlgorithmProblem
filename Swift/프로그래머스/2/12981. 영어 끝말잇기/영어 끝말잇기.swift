import Foundation

func solution(_ n:Int, _ words:[String]) -> [Int] {
    var turnCount: [Int: Int] = [:] //index : count
    var wordSet: Set<String> = Set()
    
    var lastChar: String = String(words.first![words.first!.startIndex])
    var result: [Int] = [0, 0]
    for wordIndex in 0..<words.count {
        let person: Int = (wordIndex % n) + 1
        var count = (turnCount[person] ?? 0) + 1
        turnCount[person] = count
        let word = words[wordIndex]
        guard lastChar == String(word[word.startIndex]), !wordSet.contains(word) else { 
            result[0] = person
            result[1] = count
            return result
        }
        lastChar = String(word[word.index(before:word.endIndex)])
        wordSet.insert(word)
    }
    
    return result
}