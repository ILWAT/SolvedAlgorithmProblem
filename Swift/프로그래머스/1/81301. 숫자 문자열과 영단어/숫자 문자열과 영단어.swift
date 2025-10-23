import Foundation

func solution(_ s:String) -> Int {
    
    let numberSet: Set<String> = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "0"]
    let numDic: [String : String] = ["zero" : "0", "one" : "1", "two" : "2", "three" : "3", "four" : "4", "five" : "5", "six" : "6", "seven" :  "7", "eight" : "8", "nine" : "9"]
    
    var resultString = ""
    var tempString = ""
    for i in 0..<s.count {
        let index = s.index(s.startIndex, offsetBy: i)
        let char = String(s[index])
        if numberSet.contains(char) {
            resultString += char
        } else {
            tempString += char
            if let number = numDic[tempString] {
                resultString += number
                tempString = ""
            }
        }
    }
    
    return Int(resultString)!
}