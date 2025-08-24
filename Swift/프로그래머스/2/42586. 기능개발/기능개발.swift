import Foundation

struct Queue<T> {
    private var queue: [T] = []
    
    var getQueue: [T] {
        return queue
    }
    
    var count: Int {
        return queue.count
    }
    
    mutating func add(_ element: T) {
        queue.append(element)
    }
    
    mutating func poll() -> T? {
        return queue.isEmpty ? nil : queue.removeFirst()
    }
}

func solution(_ progresses:[Int], _ speeds:[Int]) -> [Int] {
    let n = progresses.count
    var solution: Queue<Int> = Queue()
    
    var completed: [Int] = []
    for progressIndex in 0..<n {
        let progress = Double(progresses[progressIndex])
        let speed = Double(speeds[progressIndex])
        let spendedTime = Int(ceil((100.0-progress)/speed))
        completed.append(spendedTime)
    }
    
    var maxDay = completed[0]
    var feat = 0
    for day in completed {
        if day <= maxDay {
            feat += 1
        } else {
            solution.add(feat)
            maxDay = day
            feat = 1
        }
    }
    
    solution.add(feat)
    return solution.getQueue
}