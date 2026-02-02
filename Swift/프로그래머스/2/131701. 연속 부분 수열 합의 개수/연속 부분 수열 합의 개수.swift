import Foundation

func solution(_ elements:[Int]) -> Int {
    let length = elements.count
    var sumSet: Set<Int> = Set<Int>()
    let circularArray = elements + elements
    
    for i in 0..<length {
        var sum = 0
        for j in 0..<length {
            sum += circularArray[i+j]
            sumSet.insert(sum)
        }
    }
    
    return sumSet.count
}