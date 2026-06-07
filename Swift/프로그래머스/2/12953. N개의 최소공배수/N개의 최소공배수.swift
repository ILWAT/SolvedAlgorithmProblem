func solution(_ arr:[Int]) -> Int {
    var answer = arr[0]
    for num in arr {
        answer = (num * answer) / gcd(num, answer)
    }
    return answer
}

fileprivate func gcd(_ a: Int, _ b: Int) -> Int {
    var aCopy = a
    var bCopy = b
    while bCopy != 0 {
        let r = aCopy % bCopy
        aCopy = bCopy
        bCopy = r
    }
    
    return aCopy
}