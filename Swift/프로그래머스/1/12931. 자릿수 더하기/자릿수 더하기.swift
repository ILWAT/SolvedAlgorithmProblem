import Foundation

func solution(_ n:Int) -> Int
{
    var answer = 0
    var current = n
    while current > 0 {
        answer += (current % 10)
        current /= 10
    }
    
    return answer
}