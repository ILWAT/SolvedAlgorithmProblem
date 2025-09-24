import Foundation

func solution(_ orders:[String], _ course:[Int]) -> [String] {
    var splitedOrders: [[String]] = orders.map { item in
        let startIndex = item.startIndex
        var result: [String] = [String(item[startIndex])]
        for i in 1..<item.count {
            let index = item.index(startIndex, offsetBy: i)
            result.append(String(item[index]))
        }
        result.sort()
        return result
    }
    
    //초기화
    for c in course {
        combiResult[c] = [:]
    }
    
    // 통계 내기
    for history in splitedOrders {
        combination(0, history, "")
    }
    
    //결과 도출
    var result: [String] = []
    for d in combiResult {
        guard !d.value.isEmpty else { continue }
        let sorted = d.value.sorted(by: { $0.value >= $1.value })
        var topCount: Int = sorted.first!.1
        guard topCount >= 2 else { continue }
        for item in sorted {
            guard topCount <= item.1 else { break }
            result.append(item.0)
        }
    }
    
    result.sort(by: {$0 < $1})
    
    return result
}

var combiResult: [Int: [String: Int]] = [:]

func combination(_ targetIndex: Int, _ origin: [String], _ inputItem: String) {
    if inputItem.count > 0, var targetMap = combiResult[inputItem.count] {
        targetMap[inputItem] = (targetMap[inputItem] ?? 0) + 1
        combiResult[inputItem.count] = targetMap
    }
    
    for i in targetIndex..<origin.count {
        combination(i+1, origin, inputItem + origin[i])
    }
}