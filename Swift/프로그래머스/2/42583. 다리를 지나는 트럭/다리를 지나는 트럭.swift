import Foundation

struct Queue<T> {
    private var queue: [T] = []
    
    init(_ elements: [T]) {
        self.queue = elements
    }
    
    var isEmpty: Bool {
        return queue.isEmpty
    }
    
    var count: Int {
        return queue.count
    }
    
    func peek() -> T? {
        return queue.first
    }
    
    mutating func addLast(_ element: T) {
        queue.append(element)
    }
    
    mutating func pollFirst() -> T? {
        return queue.removeFirst()
    }
}

func solution(_ bridge_length:Int, _ weight:Int, _ truck_weights:[Int]) -> Int {
    var answer: Int = 0
    var bridgeWeight: Int = 0
    var trucks: Queue<Int> = Queue<Int>(truck_weights)
    var destTime: Queue<Int> = Queue<Int>([])
    var passingTruck: Queue<Int> = Queue<Int>([])
    var completedPassingTruck: Int = 0
    
    while (completedPassingTruck < truck_weights.count) {
         if destTime.peek() == answer {
            bridgeWeight -= passingTruck.pollFirst()!
            _ = destTime.pollFirst()
            completedPassingTruck += 1
        }
        
        if let truckPeek = trucks.peek(), bridgeWeight+truckPeek <= weight, passingTruck.count < bridge_length {
            destTime.addLast(answer+bridge_length)
            let truck = trucks.pollFirst()!
            passingTruck.addLast(truck)
            bridgeWeight += truck
        }
        
        answer += 1
    }
    
    return answer
}