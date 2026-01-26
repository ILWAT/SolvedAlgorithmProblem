import Foundation

func solution(_ storey:Int) -> Int {
    var current = storey
    var result = 0
    while current > 0 {
        let remaind = current % 10
        let nextDigit = (current / 10) % 10
        
        if remaind > 5 {
            result += (10 - remaind)
            current = (current / 10) + 1
        } else if remaind < 5 {
            result += remaind
            current /= 10
        } else {
            result += 5
            if nextDigit >= 5 {
                current = (current / 10) + 1
            } else {
                current /= 10
            }
        }
    }
    return result
}