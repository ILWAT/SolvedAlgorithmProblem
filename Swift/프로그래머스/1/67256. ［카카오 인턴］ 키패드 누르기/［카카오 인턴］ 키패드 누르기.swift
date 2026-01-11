import Foundation

func solution(_ numbers:[Int], _ hand:String) -> String {
    let keypad: [Int: [Int]] = [
        1: [0, 0], 2: [0, 1], 3: [0, 2],
        4: [1, 0], 5: [1, 1], 6: [1, 2],
        7: [2, 0], 8: [2, 1], 9: [2, 2],
        0: [3, 1]
    ]
    let leftHandN = [1, 4, 7]
    let rightHandN = [3, 6, 9]
    
    var leftPos = [3, 0]
    var rightPos = [3, 2] 
    
    var result = ""
    for number in numbers {
        if leftHandN.contains(number) {
            result += "L"
            leftPos = keypad[number]!
        } else if rightHandN.contains(number) {
            result += "R"
            rightPos = keypad[number]!
        } else {
            let currentPos = keypad[number]!
            
            let leftDist = abs(leftPos[0] - currentPos[0]) + abs(leftPos[1] - currentPos[1])
            let rightDist = abs(rightPos[0] - currentPos[0]) + abs(rightPos[1] - currentPos[1])
            
            if leftDist == rightDist {
                if hand == "left" {
                    result += "L"
                    leftPos = currentPos
                } else {
                    result += "R"
                    rightPos = currentPos
                }
                continue
            }
            
            if leftDist < rightDist {
                result += "L"
                leftPos = currentPos
            } else {
                result += "R"
                rightPos = currentPos
            }
        }
    }
    
    return result
}