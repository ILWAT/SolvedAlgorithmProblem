import Foundation

func solution(_ record:[String]) -> [String] {
    let splitedRecord = record.map({ $0.split(separator: " ") })
    var userNick: [String: String] = [:]
    var messages: [(String, Bool)] = []
    var result: [String] = []
    
    for recordLine in splitedRecord {
        let command = String(recordLine[0])
        let userID = String(recordLine[1])
        if command == "Enter" {
            userNick[userID] = String(recordLine[2])
            messages.append((userID, true))
        } else if command == "Leave" {
            messages.append((userID, false))
        } else if command == "Change" {
            userNick[userID] = String(recordLine[2])
        }
    }
    
    for message in messages {
        if let nickName = userNick[message.0] {
            if message.1 {
                result.append("\(nickName)님이 들어왔습니다.")
            } else {
                result.append("\(nickName)님이 나갔습니다.")
            }
        }
    }
    return result
}