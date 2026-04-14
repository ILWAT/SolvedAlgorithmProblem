import Foundation

let s: String = readLine()!
let index = Int(readLine()!)!

print(s[s.index(s.startIndex, offsetBy: index-1)])