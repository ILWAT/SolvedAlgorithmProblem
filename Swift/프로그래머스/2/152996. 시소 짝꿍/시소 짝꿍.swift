import Foundation

func solution(_ weights:[Int]) -> Int64 {
    var weightDic: [Int : Int64] = [:]
    for weight in weights {
        weightDic[weight] = (weightDic[weight] ?? 0) + 1
    }

    var answer: Int64 = 0
    for dic in weightDic {
        let key = dic.key
        let value = dic.value
        
        if value > 1 {
            answer += (((value) * (value - 1)) / 2)
        }
        
        if (key * 2) % 3 == 0,let pair = weightDic[(key * 2) / 3] {
            answer += pair * value
        }
        
        if (key * 3) % 4 == 0, let pair = weightDic[(key * 3) / 4] {
            answer += pair * value
        }
        
        if key % 2 == 0, let pair = weightDic[key / 2] {
            answer += pair * value
        }
    }
    
    return answer
}