import Foundation

var termsLimit: [String : Int] = [:]

func solution(_ today:String, _ terms:[String], _ privacies:[String]) -> [Int] {
    splitTermsLimit(terms)
    let todayTotalDays = dateToDays(today)
    var expiredList: [Int] = []
    
    for i in 0..<privacies.count {
        let splitPrivacy = privacies[i].split(separator: " ").map({ String($0) })
        let dateStr = String(splitPrivacy[0])
        let termType = String(splitPrivacy[1])
        let collectedDays = dateToDays(dateStr)
        let limitMonth = termsLimit[termType] ?? 0
        
        if (collectedDays + (limitMonth * 28)) <= todayTotalDays {
            expiredList.append(i+1)
        }
    }
    return expiredList
}

func splitTermsLimit(_ terms: [String]) {
    for term in terms {
        let termSplited = term.split(separator: " ").map({ String($0) })
        termsLimit[termSplited[0]] = Int(termSplited[1])!
    }
}

func dateToDays(_ date: String) -> Int {
    let dateSplited = date.split(separator: ".")
    let year = Int(dateSplited[0])!
    let month = Int(dateSplited[1])!
    let day = Int(dateSplited[2])!
    
    return (year * 12 * 28) + (month * 28) + day
}