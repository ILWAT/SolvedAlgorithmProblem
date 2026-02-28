if let line = readLine(), let n = Int(line) {
    
    var ropes = [Int]()
    for _ in 0..<n {
        if let input = readLine(), let weight = Int(input) {
            ropes.append(weight)
        }
    }

    ropes.sort(by: >)

    var maxWeight = 0

    for i in 0..<n {
        let currentWeight = ropes[i] * (i + 1)
        
        if currentWeight > maxWeight {
            maxWeight = currentWeight
        }
    }

    print(maxWeight)
}