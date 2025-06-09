import Foundation

struct Stack<T> {
    private var stack: [T] = []
    
    var isEmpty: Bool {
        return stack.isEmpty
    }
    
    var count: Int {
        return stack.count
    }
    
    mutating func push(_ element: T) {
        stack.append(element)
    }    
    
    mutating func pop() -> T? {
        return isEmpty ? nil : stack.popLast()
    }
}

func solution(_ s:String) -> Bool
{
    var stack = Stack<Character>()

    for char in s {
        if char == "(" {
            stack.push(char)
        } else {
            guard stack.pop() != nil else { return false }
        }
    }

    return stack.isEmpty
}