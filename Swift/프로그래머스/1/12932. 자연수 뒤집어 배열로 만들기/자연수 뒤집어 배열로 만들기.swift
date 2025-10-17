func solution(_ n:Int64) -> [Int] {
    var result: [Int] = []
    
    var number = Int(n)
    while number > 0 {
        result.append(number % 10)
        number /= 10
    }
    
    return result
}