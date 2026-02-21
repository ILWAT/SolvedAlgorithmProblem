import Foundation

let firstInput = readLine()!.split(separator: " ").map { Int($0)! }
let n: Int = firstInput[0]
let m: Int = firstInput[1]


var arr: [Int] = []
for i in 0..<n {
    if let line = readLine(), let num = Int(line) {
        arr.append(num)
    }
}

arr.sort()

var p1: Int = 0
var p2: Int = 0

var answer = Int.max

while p1 < n && p2 < n {
    let diff = arr[p2] - arr[p1]
    
    if diff >= m {
        answer = min(answer, diff)
        
        p1 += 1
        
        if answer == m {
            break
        }
    } else {
        p2 += 1
    }
}

print(answer)