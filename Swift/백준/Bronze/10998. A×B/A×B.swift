let inputArr = readLine()!.split(separator: " ").map{ Int($0)! }
let first = inputArr[0]
let second = inputArr[1]
let result = first * second
print(result)