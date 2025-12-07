import Foundation

func solution(_ d:[Int], _ budget:Int) -> Int {
    var viaB: [Int: Int] = [:]
    for money in d {
        viaB[money] = (viaB[money] ?? 0) + 1
    }
    
    var result: Int = 0
    var remainBudget = budget
    for (money, teams) in viaB.sorted(by: { $0.key < $1.key }) {
        if money * teams <= remainBudget {
            remainBudget -= money * teams
            result += teams
        } else {
            let receivedTeam = remainBudget / money
            result += receivedTeam
            break
        }
    } 
    return result
}