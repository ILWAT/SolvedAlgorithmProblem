import Foundation

func solution(_ cipher:String, _ code:Int) -> String {
    var result: String = ""
    var number = -1
    while number < cipher.count {
        number += code
        if number >= cipher.count { break }
        let stringIndex = cipher.index(cipher.startIndex, offsetBy: number)
        result += "\(cipher[stringIndex])"
    }
   
    return result
}