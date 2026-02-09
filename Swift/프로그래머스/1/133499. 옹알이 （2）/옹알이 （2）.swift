import Foundation

func solution(_ babbling:[String]) -> Int {
    let canSpeakWords = ["aya", "ye", "woo", "ma"]
    var count = 0
    
    for word in babbling {
        var tempWord = word
        var possible = true
        
        for speakWord in canSpeakWords {
            if tempWord.contains(speakWord + speakWord) {
                possible = false
                break
            }
        }
        
        guard possible else { continue }
        
        for speakWord in canSpeakWords {
            tempWord = tempWord.replacingOccurrences(of: speakWord, with: " ")
        }
        
        if tempWord.trimmingCharacters(in: .whitespaces).isEmpty {
            count += 1
        }
    }
    
    return count
}