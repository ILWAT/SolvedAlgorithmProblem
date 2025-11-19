import Foundation

func getResult(_ array: [Int], _ command: [Int]) -> Int {
    let i = command[0]-1
    let j = command[1]-1
    let k = command[2]-1
    
    var result: [Int] = .init(repeating: 0, count: j-i+1)
    var resultIndex = 0
    for index in i...j {
        result[resultIndex] = array[index]
        resultIndex += 1
    }
    
    result.sort()
    
    return result[k]
}
func solution(_ array:[Int], _ commands:[[Int]]) -> [Int] {
    var answer: [Int] = .init(repeating: 0, count: commands.count)
    var resultIndex = 0
    for command in commands {
        answer[resultIndex] = getResult(array, command)
        resultIndex += 1
    }
    return answer
}