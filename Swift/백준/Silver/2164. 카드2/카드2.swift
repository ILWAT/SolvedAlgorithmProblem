let n = Int(readLine()!)!

var queue: [Int] = Array(1...n)
var headP = 0

while queue.count - headP > 1 {
    headP += 1
    
    if queue.count - headP > 1 {
        queue.append(queue[headP])
        headP+=1
    }
}

print(queue[headP])