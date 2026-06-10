import Foundation

func solution(_ n:Int64) -> Int64 {
    guard n >= 0 else { return -1 }
    
    let rootN = Int64(round(sqrt(Double(n))))
    
    if pow(Double(rootN), 2) == Double(n) {
        return Int64(pow(Double(rootN+1), 2))
    } else {
        return -1
    }
}