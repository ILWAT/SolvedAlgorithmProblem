import Foundation

func solution(_ n:Int, _ a:Int, _ b:Int) -> Int
{
    var answer = 0
    var aCopy = a
    var bCopy = b

    while(aCopy != bCopy) {
        aCopy = (aCopy + 1)/2
        bCopy = (bCopy + 1)/2
        answer += 1
    }

    return answer
}