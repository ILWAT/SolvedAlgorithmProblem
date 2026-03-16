import Foundation

let a = Int(readLine()!)!
var totalString: String = ""
var count = 0

func hanoi(_ board: Int, _ start: Int, _ via: Int, _ end: Int) {
    count += 1
    if board == 1 {
        totalString.append("\(start) \(end)\n")
        return
    }
    
    
    hanoi(board - 1, start, end, via)
    
    totalString.append("\(start) \(end)\n")
    
    hanoi(board - 1, via, start, end)
    
}

hanoi(a, 1, 2, 3)
print("\(count)\n\(totalString)")
