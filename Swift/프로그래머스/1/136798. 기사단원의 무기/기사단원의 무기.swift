import Foundation

func solution(_ number:Int, _ limit:Int, _ power:Int) -> Int {
    var result = 0
    for i in stride(from:0, through: number, by:1) {
        var target = 0
        var j = 1
        while j*j <= i {
            if (j * j) == i {
                target += 1
            } else if (i % j == 0) {
                target += 2
            }
            j += 1
        }
        
        if target > limit {
            target = power
        }
        result += target
    }
    return result
}