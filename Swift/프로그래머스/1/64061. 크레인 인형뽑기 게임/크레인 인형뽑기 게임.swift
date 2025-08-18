import Foundation

fileprivate class Stack {
    private var stack: [Int] = []
    
    var isEmpty: Bool {
        return stack.isEmpty
    }
    
    var count: Int {
        return stack.count
    }
    
    var peek: Int? {
        return stack.last
    }
    
    func pop() -> Int? {
        return stack.popLast()
    }
    
    func push(_ element: Int) {
        stack.append(element)
    }
}

func solution(_ board:[[Int]], _ moves:[Int]) -> Int {
    let n: Int = board.count
    var result: Int = 0
    
    var columnStack: [Stack] = (0..<n).map { _ in Stack() }
    var stack: Stack = Stack()
    
    for column in 0..<n {
        let rStack = columnStack[column]
        for row in 0..<n {
            let item = board[n-1-row][column]
            guard item != 0 else { continue }
            rStack.push(item)
        }
    }
    
    for move in moves {
        let moveIndex: Int = move - 1
        guard let item = columnStack[moveIndex].pop() else { continue }
        if !stack.isEmpty && (stack.peek == item) {
            stack.pop()
            result += 2
        } else {
            stack.push(item)
        }
    }
    

    return result
}