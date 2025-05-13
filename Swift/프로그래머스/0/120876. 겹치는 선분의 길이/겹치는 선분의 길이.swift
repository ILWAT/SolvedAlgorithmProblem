import Foundation

func solution(_ lines:[[Int]]) -> Int {
    var result = 0
    
    var array = Array(repeating: 0, count: 200)
    
    for point in allPoint(lines[0]) {
        array[point+100] += 1
    }
    
    for point in allPoint(lines[1]) {
        array[point+100] += 1
    }
    
    for point in allPoint(lines[2]) {
        array[point+100] += 1
    }
    
    
    for point in array {
        if point >= 2 {
            result += 1
        }
    }
    
    return result
}

func allPoint(_ line: [Int]) -> [Int] {
    var array: [Int] = []
    guard line.count >= 2 else { return [] }
    for point in line[0]..<line[1] {
        array.append(point)
    }
    return array
}