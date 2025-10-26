import Foundation

func solution(_ priorities:[Int], _ location:Int) -> Int {
    
    var priQueue = priorities.sorted(by: { $0 > $1 }) //precess rank
    var position:[Int] = [] //index
    var posPri: [Int: Int] = [:] //indx : priority
    
    for i in 0..<priorities.count {
        position.append(i)
        posPri[i] = priorities[i]
    }
    
    var result: Int = 0
    while !priQueue.isEmpty {
        guard let item = position.first, let itempPri = posPri[item] else { break }
        position.removeFirst()
        if priQueue.first == itempPri {
            priQueue.removeFirst()
            result += 1
            if item == location { 
                return result
            }
        } else {
            position.append(item)
        }
    }
    
    return result
}