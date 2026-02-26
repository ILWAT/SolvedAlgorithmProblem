import Foundation

let input = readLine()!.split(separator: " ").map { Int($0)! }
let n = input[0]
let m = input[1]

var groupToMembers: [String: [String]] = [:]
var memberToGroup: [String: String] = [:]

for _ in 0..<n {
    let groupName = readLine()!
    let memberCount = Int(readLine()!)!
    var members = [String]()
    
    for _ in 0..<memberCount {
        let name = readLine()!
        members.append(name)
        memberToGroup[name] = groupName
    }

    groupToMembers[groupName] = members.sorted()
}

for _ in 0..<m {
    let quizName = readLine()!
    let quizType = Int(readLine()!)!
    
    if quizType == 0 {
        if let members = groupToMembers[quizName] {
            members.forEach { member in
                print(member)
            }
        }
    } else {
        if let groupName = memberToGroup[quizName] {
            print(groupName)
        }
    }
}