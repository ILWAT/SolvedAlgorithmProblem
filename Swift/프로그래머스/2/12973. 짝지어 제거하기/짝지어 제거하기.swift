import Foundation

func solution(_ s:String) -> Int{
    var answer:Int = -1
    var stack: Stack<Character> = Stack()
    
    for char in s {
        if stack.peek() == char {
            stack.pop()
        } else {
            stack.push(char)
        }
    }

    return stack.isEmpty ? 1 : 0
}

fileprivate struct Stack<T> {
    private var list: [T] = []
    
    func peek() -> T? {
        return  list.last
    }
    
    var isEmpty: Bool {
        return list.isEmpty
    }
    
    mutating func push(_ element: T) {
        list.append(element)
    }
    
    mutating func pop() -> T? {
        return list.popLast()
    }
    
}