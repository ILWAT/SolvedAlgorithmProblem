import Foundation

func solution(_ survey:[String], _ choices:[Int]) -> String {
    let orderedArray: [[String]] = [["R", "T"], ["C", "F"], ["J", "M"], ["A", "N"]]
    var countDic: [String: Int] = [:]
    
    let count = survey.count
    for i in 0..<count {
        let s = survey[i]
        let choice = choices[i]
        let first = String(s[s.startIndex])
        let second = String(s[s.index(s.endIndex, offsetBy: -1)])
        guard choice != 4 else { continue }
        let cate = choice < 4 ? first : second
        countDic[cate] = (countDic[cate] ?? 0) + Int(abs(choice-4))
    }
    
    var answer: String = ""
    for cates in orderedArray {
        answer += (countDic[cates[0]] ?? 0) >= (countDic[cates[1]] ?? 0) ? cates[0] : cates[1]
    }
    
    
    return answer
}