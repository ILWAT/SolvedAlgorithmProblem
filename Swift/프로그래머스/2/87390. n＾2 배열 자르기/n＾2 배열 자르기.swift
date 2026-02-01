import Foundation

func solution(_ n:Int, _ left:Int64, _ right:Int64) -> [Int] {
    var answer: [Int] = []
    for i in left...right {
        let row = Int(i / Int64(n))
        let col = Int(i % Int64(n))
        
        answer.append(max(row, col) + 1)
    }
    return answer
}