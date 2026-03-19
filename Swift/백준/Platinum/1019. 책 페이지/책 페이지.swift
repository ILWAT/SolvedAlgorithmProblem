import Foundation

var result: [Int] = Array(repeating: 0, count: 10)
var point: Int = 1

func counting(_ num: Int) {
    var mutableNum = num
    while (mutableNum > 0) {
        result[mutableNum % 10] += point
        mutableNum /= 10
    }
}

var n = Int(readLine()!)!
var start = 1
var end = n

while start <= end {
    while start % 10 != 0 && start <= end {
        counting(start)
        start += 1
    }
    
    if start > end { break }
    
    while end % 10 != 9 && start <= end {
        counting(end)
        end -= 1
    }
    
    let upPointCount = (end / 10) - (start / 10) + 1
    for i in 0..<10 {
        result[i] += upPointCount * point
    }
    
    start /= 10
    end /= 10
    point *= 10
}

print(result.map{ String($0) }.joined(separator: " "))