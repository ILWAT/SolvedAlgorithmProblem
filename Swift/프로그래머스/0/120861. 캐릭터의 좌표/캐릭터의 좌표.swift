import Foundation

let dPoint: [String: (Int, Int)] = ["up" : (0,1), "down" : (0, -1), "left": (-1, 0), "right" : (1, 0)]

func solution(_ keyinput:[String], _ board:[Int]) -> [Int] {
    let halfWidth = (board[0] - 1) / 2
    let halfHeight = (board[1] - 1) / 2
    var point: [Int] = [0, 0]
    
    for key in keyinput {
        guard let dxy = dPoint[key], (abs(point[0]+dxy.0) <= halfWidth && abs(point[1]+dxy.1) <= halfHeight) else { continue }
        point[0] += dxy.0
        point[1] += dxy.1
    }
    
    return point
}