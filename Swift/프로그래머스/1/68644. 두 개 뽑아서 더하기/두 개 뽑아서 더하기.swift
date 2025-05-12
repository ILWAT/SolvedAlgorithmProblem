import Foundation

func solution(_ numbers:[Int]) -> [Int] {
    let numberCount = numbers.count
    var resultSet: Set<Int> = Set()
    for firstIndex in 0...numberCount-2 {
        for secondIndex in firstIndex+1...numberCount-1 {
            resultSet.insert(numbers[firstIndex]+numbers[secondIndex])
        }
    }
    let result = resultSet.map({$0}).sorted()
    return result
}