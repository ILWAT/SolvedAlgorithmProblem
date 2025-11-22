import Foundation

func solution(_ numbers:[Int]) -> String {
     var list: [String] = []
    for number in numbers {
        list.append(String(number))
    }
    
    list.sort(by: {
        let a: Int = Int($0 + $1)!
        let b: Int = Int($1 + $0)!
        return b < a
    })
    
    var result = ""
    for s in list {
        result += s
    }
    
    return result[result.startIndex] == "0" ? "0" : result
}