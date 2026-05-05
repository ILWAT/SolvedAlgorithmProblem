import Foundation

func solution(_ dirs:String) -> Int {
    var answer = 0
    var x = 5
    var y = 5
    
    var hVisited: [[Bool]] = .init(repeating: .init(repeating: false, count: 10), count: 11)
    var vVisited: [[Bool]] = .init(repeating: .init(repeating: false, count: 11), count: 10)
    
    for c in dirs {
        let cToS = String(c)
        let dxy = calDxy(cToS)
        let nx = x + dxy.0
        let ny = y + dxy.1
        
        if nx < 0 || nx > 10 || ny < 0 || ny > 10 {
            continue
        }
        
        if cToS == "L" || cToS == "R" {
            let minX = min(x, nx)
            if !hVisited[y][minX] {
                hVisited[y][minX] = true
                answer += 1
            }
        } else {
            let minY = min(y, ny)
            if !vVisited[minY][x] {
                vVisited[minY][x] = true
                answer += 1
            }
        }
        
        x = nx
        y = ny
    }
    
    return answer
}

func calDxy(_ command: String) -> (Int, Int) {
    switch command {
        case "U":
            return (0, 1)
        case "D":
            return (0, -1)
        case "L":
            return (-1, 0)
        case "R":
            return (1, 0)
        default:
            return (0, 0)
    }
}