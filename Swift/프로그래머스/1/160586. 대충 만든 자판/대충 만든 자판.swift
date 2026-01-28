import Foundation

func solution(_ keymap:[String], _ targets:[String]) -> [Int] {
    var keyDic: [String : Int] = [:]
    for keyMatch in keymap {
        for i in 0..<keyMatch.count {
            let index = keyMatch.index(keyMatch.startIndex, offsetBy: i)
            let keyChar = String(keyMatch[index])
            if let keyMin = keyDic[keyChar], keyMin <= i+1 {
                continue
            } else {
                keyDic[keyChar] = i+1
            }
        }
    }
    
    var answer: [Int] = []
    for target in targets {
        var result: Int = 0
        for i in 0..<target.count {
            let index = target.index(target.startIndex, offsetBy: i)
            let keyChar = String(target[index])
            if let keyMin = keyDic[keyChar] {
                result += keyMin
            } else {
                result = -1
                break
            }
        }
        answer.append(result)
    }
    
    return answer
}