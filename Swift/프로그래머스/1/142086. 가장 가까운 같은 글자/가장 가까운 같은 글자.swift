import Foundation

func solution(_ s:String) -> [Int] {
    var charDic: [String: Int] = [:]
    var result: [Int] = []
    
    for i in 0..<s.count {
        let cs = String(s[s.index(s.startIndex, offsetBy: i)])
        let index = (charDic[cs] == nil) ? -1 : i-charDic[cs]!
        result.append(index)
        charDic[cs] = i;
    }
    return result
}