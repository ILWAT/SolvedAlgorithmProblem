import Foundation


var defaultMoney = 0;
var defaultTime = 0;
var amountMoney = 0;
var amountTime = 0;

func solution(_ fees:[Int], _ records:[String]) -> [Int] {
    defaultMoney = fees[1]
    defaultTime = fees[0]
    amountMoney = fees[3]
    amountTime = fees[2]
    
    var parking: [String : Int] = [:]
    var result: [String : Int] = [:]
    
    for record in records {
        let recordCate = record.split(separator: " ").map({ String($0) })
        let timeString = recordCate[0].split(separator: ":").map({ String($0) })
        let timeInt = timeToInt(Int(timeString[0])!, Int(timeString[1])!)
        let car = recordCate[1]
        
        if recordCate[2] == "IN" {
            parking[car] = timeInt
        } else {
            let inTime = parking.removeValue(forKey: car) ?? 0
            result[car] = (result[car] ?? 0) + timeInt - inTime
        }
    }
    
    let finalTime = timeToInt(23, 59)
    for car in parking.keys {
        let inTime = parking[car]!
        result[car] = (result[car] ?? 0) + finalTime - inTime
    }
    
    return result.sorted(by: { Int($0.key)! < Int($1.key)! }).map({ calMoney($0.value) })
}

func timeToInt(_ hour: Int, _ min: Int) -> Int {
    return (hour * 60) + min
}

func calMoney(_ totalTime: Int) -> Int {
    if totalTime <= defaultTime {
        return defaultMoney;
    } else {
        return defaultMoney + Int(ceil((Double(totalTime - defaultTime) / Double(amountTime)))) * amountMoney
    }
}