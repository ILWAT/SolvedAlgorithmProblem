import Foundation

func solution(_ board:[[Int]]) -> Int {
    let dx = [-1, 0, 1]
    let dy = [-1, 0, 1]
    
    var boardCopy = board
    let n: Int = board.count
    let totalCoorArea = n * n
    
    var bombCoor: [[Int]] = []
    
    //폭탄 좌표 찾기
    for y in 0..<n {
        for x in 0..<n {
            if board[y][x] == 1 {
                bombCoor.append([y, x])
            } 
        }
    }
    
    var warningAreaCount = 0
    for coor in bombCoor {
        for moveY in dy {
            let warningY = coor[0] + moveY
            if warningY > (n-1) || warningY < 0 { continue }
            for moveX in dx {
                let warningX = coor[1] + moveX
                if warningX > (n-1) || warningX < 0 { continue }
                if boardCopy[warningY][warningX] == 1 { continue }
                else { boardCopy[warningY][warningX] = 1 }
            }
        } 
    }
    
    var resultCount = 0
    for y in 0..<n {
        for x in 0..<n {
            if boardCopy[y][x] == 0 {
                resultCount += 1
            } 
        }
    }
    
    return resultCount
}