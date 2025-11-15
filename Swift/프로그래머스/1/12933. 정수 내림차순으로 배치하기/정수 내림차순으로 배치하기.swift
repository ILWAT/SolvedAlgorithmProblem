func solution(_ n:Int64) -> Int64 {
    var N = n
    var intArr: [Int64] = []
    while N > 0 {
        intArr.append(N%10)
        N /= 10
    }
    
    intArr.sort(by: { $0 < $1 })
    var result: Int64 = 0
    var mul: Int64 = 1
    for element in intArr {
        result += element * mul
        mul *= 10
    }
    return result
}