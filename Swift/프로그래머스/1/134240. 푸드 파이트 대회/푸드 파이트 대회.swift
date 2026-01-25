import Foundation

func solution(_ food:[Int]) -> String {
    var leftSide = ""
    
    for i in 1..<food.count {
        let count = Int(food[i] / 2)
        leftSide += String(repeating: String(i), count: count)
    }
    
    return leftSide + "0" + String(leftSide.reversed())
}