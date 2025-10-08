import Foundation

func solution(_ enroll:[String], _ referral:[String], _ seller:[String], _ amount:[Int]) -> [Int] {
    var parent: [String: String] = [:]
    for i in 0..<enroll.count {
        parent[enroll[i]] = referral[i]
    }
    
    var total: [String: Int] = [:]
    
    for i in 0..<seller.count {
        var name = seller[i]
        var money = amount[i] * 100
        
        while money > 0 && name != "-" {
            total[name] = (total[name] ?? 0) + money - (money / 10)
            name = parent[name] ?? ""
            
            money /= 10
        }
    }
    
    var answer: [Int] = .init(repeating: 0, count: enroll.count)
    for i in 0..<enroll.count {
        answer[i] = total[enroll[i]] ?? 0
    }
    return answer
}