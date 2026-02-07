import Foundation

func solution(_ babbling:[String]) -> Int {
    let canSpeakWords = ["aya", "ye", "woo", "ma"]
    var count = 0
    
    for word in babbling {
        var tempWord = word
        var possible = true
        
        for speakWord in canSpeakWords {
            if let range = tempWord.range(of: speakWord) {
                tempWord.replaceSubrange(range, with: " ")
            }
        }
        
        if tempWord.trimmingCharacters(in: .whitespaces).isEmpty {
            count += 1
        }
    }
    
    return count
}