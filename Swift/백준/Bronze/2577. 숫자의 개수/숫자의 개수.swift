import Foundation

let a = Int(readLine()!)!
let b = Int(readLine()!)!
let c = Int(readLine()!)!

var total = a * b * c
var numCountArr = Array(repeating: 0, count: 10)

while total > 0 {
    numCountArr[total % 10] += 1
    total /= 10
}

for numCount in numCountArr {
    print(numCount)
}