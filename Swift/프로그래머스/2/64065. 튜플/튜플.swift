import Foundation

func solution(_ s:String) -> [Int] {
     let S = s.dropLast(2)
    
    let replaced = S.replacingOccurrences(of: "},", with: "|")
    
    let arr = replaced
        .split(separator: "|")
        .map { String($0) }

    var sorted = arr.sorted { $0.count < $1.count }

    var set = Set<String>()
    var answer: [Int] = .init(repeating: 0, count: sorted.count)

    for i in 0..<sorted.count {
        let numbers = sorted[i]
            .replacingOccurrences(of: "{", with: "")
            .split(separator: ",")

        for number in numbers {
            let str = String(number)
            if !set.contains(str) {
                answer[i] = Int(str)!
                set.insert(str)
            }
        }
    }

    return answer
}