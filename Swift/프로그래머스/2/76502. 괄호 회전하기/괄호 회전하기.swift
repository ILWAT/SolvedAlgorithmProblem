import Foundation

struct Stack<T> {
    private var arr: [T] = []
    
    var count: Int {
        return arr.count
    }
    
    mutating func add(_ element: T) {
        arr.append(element)
    }
    
    mutating func popLast() -> T? {
        return arr.popLast()
    }
    
    var peek: T? {
        return arr.last
    }
    
    var isEmpty: Bool {
        return arr.isEmpty
    }
}

func solution(_ s:String) -> Int {
    var answer: Int = 0
    let pair: [String: String] = ["[": "]", "{" : "}", "(" : ")"]
    let allString = s + s
    let sCount = s.count
    
    for shiftCount in 0..<sCount {
        var stack: Stack<String> = Stack<String>()
        var isPoped: Bool = false
        for i in shiftCount..<sCount + shiftCount {
            var index = allString.index(allString.startIndex, offsetBy: i)
            let target: String = String(allString[index])
            
            if let openItem = pair[target] {
                stack.add(target)
            } else {
                guard let peek = stack.peek, pair[peek] == target else { break }
                _ = stack.popLast()
                isPoped = true
            }
            
            if i == sCount + shiftCount - 1 && stack.isEmpty {
                answer += 1
            }
        }
    }
    
    
    return answer
}