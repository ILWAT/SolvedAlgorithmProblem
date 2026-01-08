import Foundation

func solution(_ k:Int, _ d:Int) -> Int64 {
    var answer: Int64 = 0
    
    let D = Double(d)
    
    var x = 0
    while x <= d {
        let dX = Double(x)
        
        let maxY = sqrt(pow(D, 2) - pow(dX, 2))
        
        answer += (Int64(maxY / Double(k)) + 1)
        x += k
    }
    
    return answer
}