import Foundation

func solution(_ id_list:[String], _ report:[String], _ k:Int) -> [Int] {
    var idxMap: [String: Int] = [:]
    for (idx, user) in id_list.enumerated() {
        idxMap[user] = idx
    }
    
    var reportingMap: [String: Set<String>] = [:] //신고 받은 유저 : 신고자
    
    var reportingList = report.map({ $0.split(separator: " ") })
    for reporting in reportingList {
        let reportedUser = String(reporting[1])
        let reportingUser = String(reporting[0])
        var r: Set<String> = reportingMap[reportedUser] ?? Set()
        r.insert(reportingUser)
        reportingMap[reportedUser] = r
    }
    
    let userSetArr = reportingMap.filter({ $0.value.count >= k }).map({ $0.value })
    
    var results: [Int] = .init(repeating: 0, count: id_list.count)
    for userSet in userSetArr {
        for user in userSet {
            guard let idx = idxMap[user] else { continue }
            results[idx] = results[idx] + 1
        }
    }
    
    return results
}