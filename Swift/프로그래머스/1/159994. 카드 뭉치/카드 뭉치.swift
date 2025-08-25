import Foundation

struct Queue<T> {
    private var queue: [T] = []
    
    init(_ elements: [T]) {
        self.queue = elements
    }
    
    var peek: T? {
        return queue.first
    }
    
    var isEmpty: Bool {
        return queue.isEmpty
    }
    
    mutating func addLast(_ element: T) {
        queue.append(element)
    }
    
    mutating func pollFirst() -> T? {
        return isEmpty ? nil : queue.removeFirst()
    }
}

func solution(_ cards1:[String], _ cards2:[String], _ goal:[String]) -> String {
    var cards1Queue: Queue<String> = Queue<String>(cards1)
    var cards2Queue: Queue<String> = Queue<String>(cards2)
    var goalQueue: Queue<String> = Queue<String>(goal)
    
    while (!cards1Queue.isEmpty || !cards2Queue.isEmpty) {
        guard let target = goalQueue.peek else { break }
        if cards1Queue.peek == target {
            let _ = cards1Queue.pollFirst()
            let _ = goalQueue.pollFirst()
        } else if cards2Queue.peek == target {
            let _ = cards2Queue.pollFirst()
            let _ = goalQueue.pollFirst()
        } else {
            break
        }
    }
    
    return goalQueue.isEmpty ? "Yes" : "No"
}