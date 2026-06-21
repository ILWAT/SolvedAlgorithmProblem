import Foundation

func solution(_ targets:[[Int]]) -> Int {
    var targetsC = targets
    targetsC.sort(by: { $0[1] < $1[1] })
    
    var msPoint = targetsC[0][1]
    var answer = 1
    for target in targetsC {
        if target[0] >= msPoint {
            answer += 1
            msPoint = target[1]
        }
    }
    
    return answer
}