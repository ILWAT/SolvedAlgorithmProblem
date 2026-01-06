import Foundation

func solution(_ wallpaper:[String]) -> [Int] {
    var minY = Int.max
    var minX = Int.max
    var maxY = Int.min
    var maxX = Int.min
    for y in 0..<wallpaper.count {
        let rowString = wallpaper[y]
        for x in 0..<rowString.count {
            let index = rowString.index(rowString.startIndex, offsetBy: x)
            let char = String(rowString[index])
            if char == "#" {
                minY = min(minY, y)
                minX = min(minX, x)
                maxY = max(maxY, y+1)
                maxX = max(maxX, x+1)
            }
        }
    }
    return [minY, minX, maxY, maxX]
}