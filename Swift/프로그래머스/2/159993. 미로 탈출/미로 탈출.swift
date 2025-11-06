import Foundation

struct Point {
    let x: Int
    let y: Int
    
    init(_ x: Int, _ y:Int) {
        self.x = x
        self.y = y
    }
}

var map: [[String]] = []
let move: [(Int, Int)] = [(1, 0), (-1, 0), (0, 1), (0, -1)]
var xCount: Int = 0
var yCount: Int = 0

func solution(_ maps:[String]) -> Int {
    yCount = maps.count
    xCount = maps.first!.count
    
    for mapString in maps {
        map.append(mapString.map{ String($0) })
    }
    
    var start: Point = Point(0, 0)
    var lever: Point = Point(0, 0)
    var end: Point = Point(0, 0)
    
    
    for y in 0..<yCount {
        for x in 0..<xCount {
            let road = map[y][x]
            if road == "S" {
                start = Point(x, y)
            } else if road == "L" {
                lever = Point(x, y)
            } else if road == "E" {
                end = Point(x, y)
            }
        }
    }
    
    let stol = bfs(start, lever)
    let ltoe = bfs(lever, end)
    
    guard stol >= 0, ltoe >= 0 else { return -1 }
    
    return stol + ltoe
}

func bfs(_ start: Point, _ end: Point) -> Int {
    var distance: [[Int]] = .init(repeating: .init(repeating: 0, count: xCount), count: yCount)
    var queue: [Point] = []
    queue.append(start)
    distance[start.y][start.x] = 1
    
    while !queue.isEmpty {
        let current = queue.removeFirst()
        for dxy in move {
            let movedY = current.y + dxy.1
            let movedX = current.x + dxy.0
            
            guard movedY >= 0, movedY < yCount, movedX >= 0, movedX < xCount else { continue }
            guard distance[movedY][movedX] <= 0 else { continue }
            let road = map[movedY][movedX]
            if road != "X" {
                queue.append(Point(movedX, movedY))
                distance[movedY][movedX] = distance[current.y][current.x] + 1
            }
            if movedY == end.y && movedX == end.x {
                return distance[movedY][movedX] - 1
            }
        }
    }
    return -1
}