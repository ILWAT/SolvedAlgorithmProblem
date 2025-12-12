import Foundation

func solution(_ sequence:[Int], _ k:Int) -> [Int] {
    var pointerOne: Int = 0
    var pointerTwo: Int = 0
    var total: Int = 0
    var answer: [Int] = [0, 0]
    var min = Int.max
    while pointerOne < sequence.count {
        while pointerTwo < sequence.count && total < k {
            total += sequence[pointerTwo]
            pointerTwo += 1
        }
        
        if total == k && min > (pointerTwo - pointerOne + 1) {
            answer[0] = pointerOne
            answer[1] = pointerTwo - 1
            min = pointerTwo - pointerOne + 1
        } 
        
        total -= sequence[pointerOne]
        pointerOne += 1
    }
    
    return answer
}