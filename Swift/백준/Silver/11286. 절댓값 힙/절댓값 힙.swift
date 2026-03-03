import Foundation

struct AbsoluteHeap {
    private var heap: [Int] = []
    
    private func compare(_ a: Int, _ b: Int) -> Bool {
        let absA = abs(a)
        let absB = abs(b)
        if absA == absB {
            return a < b
        }
        return absA < absB
    }
    
    mutating func insert(_ n: Int) {
        heap.append(n)
        var curr = heap.count - 1
        
        while curr > 0 {
            let parent = (curr - 1) / 2
            if compare(heap[curr], heap[parent]) {
                heap.swapAt(curr, parent)
                curr = parent
            } else {
                break
            }
        }
    }
    
    mutating func pop() -> Int {
        if heap.isEmpty { return 0 }
        if heap.count == 1 { return heap.removeFirst() }
        
        let result = heap[0]
        heap[0] = heap.removeLast()
        var curr = 0
        
        while true {
            let left = curr * 2 + 1
            let right = curr * 2 + 2
            var target = curr
            
            if left < heap.count && compare(heap[left], heap[target]) {
                target  = left
            }
            if right < heap.count && compare(heap[right], heap[target]) {
                target = right
            }
            
            if target == curr { break }
            heap.swapAt(curr, target)
            curr = target
        }
        
        return result
    }
}

guard let line = readLine(), let n = Int(line) else { exit(0) }

var absHeap = AbsoluteHeap()
var output = ""

for _ in 0..<n {
    if let input = readLine(), let x = Int(input) {
        if x == 0 {
            output += "\(absHeap.pop())\n"
        } else {
            absHeap.insert(x)
        }
    }
}

print(output)