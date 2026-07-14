import Foundation

var numSet: Set<Int> = Set()

func solution(_ numbers:String) -> Int {
    makeNum("", numbers)
    return numSet.filter{ validate($0) }.count
}

func makeNum(_ s: String, _ remain: String) {
    if !s.isEmpty {
        numSet.insert(Int(s)!);
    } 
    
    for i in 0..<remain.count {
        let targetIndex = remain.index(remain.startIndex, offsetBy: i)
        makeNum(
            s + String(remain[targetIndex]),
            String(remain[..<targetIndex] + remain[remain.index(targetIndex, offsetBy: 1)...])
        )
    }
}

func validate(_ num: Int) -> Bool {
    guard num >= 2 else { return false }
    for i in 2..<num {
        if num % i == 0 {
            return false
        }
    }
    
    return true
}