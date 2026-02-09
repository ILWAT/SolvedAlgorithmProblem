let intArr = readLine()!.split(separator: " ").map{ Int($0)! }
let first = intArr[0]
let second = intArr[1]
let result = first * second
print(result)