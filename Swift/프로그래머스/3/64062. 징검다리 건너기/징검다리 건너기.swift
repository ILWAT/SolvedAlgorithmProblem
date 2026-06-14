import Foundation

func solution(_ stones:[Int], _ k:Int) -> Int {
var answer = Int.max
        var deque = [Int]()
        var head = 0
        
        for i in 0..<stones.count {
            if head < deque.count && deque[head] <= i - k {
                head += 1
            }
            
            while head < deque.count && stones[deque.last!] <= stones[i] {
                deque.removeLast()
            }
            
            deque.append(i)
            
            if i >= k - 1 {
                let currentWindowMax = stones[deque[head]]
                answer = min(answer, currentWindowMax)
            }
        }
        
        return answer
}