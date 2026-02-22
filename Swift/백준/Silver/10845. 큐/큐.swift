import Foundation

struct Queue {
    var queue: [Int] = []
    private var front: Int = 0
    
    mutating func push(_ value: Int) {
        queue.append(value)
    }
    
    mutating func pop() -> Int {
        guard let item = queue.first else { return -1 }
        queue.removeFirst()
        return item
    }
    
    mutating func size() -> Int {
        return queue.count
    }
    
    mutating func empty() -> Int {
        return queue.isEmpty ? 1 : 0
    }
    
    mutating func frontValue() -> Int {
        return queue.first ?? -1
    }
    
    mutating func backValue() -> Int {
        return queue.last ?? -1
    }
}

let inputNumber = Int(readLine()!)!


var resultQueue: Queue = Queue()

for _ in 0..<inputNumber {
    let inputArr = readLine()!.split(separator: " ")
    switch inputArr[0] {
    case "push":
        resultQueue.push(Int(inputArr[1])!)
    case "pop":
        print(resultQueue.pop())
    case "size":
        print(resultQueue.size())
    case "empty":
        print(resultQueue.empty())
    case "front":
        print(resultQueue.frontValue())
    case "back":
        print(resultQueue.backValue())
    default:
        break
    }
}