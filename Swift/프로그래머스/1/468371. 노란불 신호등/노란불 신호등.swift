import Foundation

func solution(_ signals:[[Int]]) -> Int {
    var cycles: [Int] = []
    for signal in signals {
        cycles.append(signal[0] + signal[1] + signal[2])
    }
    
    
    for t in 1...2000000 {
        var yCount = 0
        
        for i in 0..<signals.count {
            let g = signals[i][0]
            let y = signals[i][1]
            let cycle = cycles[i]
            
            var currentTime = t % cycle
            if currentTime == 0 { currentTime = cycle }
            
            if currentTime > g && currentTime <= g+y {
                yCount += 1
            } else {
                break
            }
        }
        
        if yCount == signals.count {
            return t
        }
    }
    return -1
}