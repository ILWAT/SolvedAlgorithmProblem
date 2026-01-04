import Foundation

func solution(_ book_time:[[String]]) -> Int {
    let sortedBookings = book_time.map { 
        [timeToMinutes($0[0]), timeToMinutes($0[1]) + 10]
    }.sorted { $0[0] < $1[0] }
    
    var outTimeArr = [Int]()
    
    for booking in sortedBookings {
        let start = booking[0]
        let end = booking[1]
        
        outTimeArr.sort()
        
        if !outTimeArr.isEmpty && outTimeArr[0] <= start {
            outTimeArr.removeFirst()
        }
        
        outTimeArr.append(end)
    }
    
    return outTimeArr.count
}

func timeToMinutes(_ time: String) -> Int {
        let components = time.split(separator: ":")
        let hours = Int(components[0])! * 60
        let minutes = Int(components[1])!
        return hours + minutes
    }