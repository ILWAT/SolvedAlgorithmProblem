import Foundation

func solution(_ A:String, _ B:String) -> Int {
    let aCount = A.count
    var aCopy = A
    for movingCount in 0...aCount {
        if aCopy == B { return movingCount }
        let lastChar = aCopy.removeLast()
        aCopy = "\(lastChar)" + aCopy
    }
    return -1
}