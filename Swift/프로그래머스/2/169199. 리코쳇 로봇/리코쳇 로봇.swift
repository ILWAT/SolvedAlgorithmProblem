import Foundation

func solution(_ board:[String]) -> Int {
    var startX = 0, startY = 0
    var endX = 0, endY = 0
    let dxyArr = [[1, 0], [-1, 0], [0, 1], [0, -1]]

    var ad: [[Int]] = []

    let maxX = board[0].count
    let maxY = board.count

    var boardNote = Array(repeating: Array(repeating: 0, count: maxX), count: maxY)
        
    for i in 0..<maxY {
        let row = Array(board[i])
        for j in 0..<maxX {
            let currentItem = row[j]
            if currentItem == "D" {
                boardNote[i][j] = -1
            } else if currentItem == "R" {
                startX = j
                startY = i
                boardNote[i][j] = 0
            } else {
                if currentItem == "G" {
                    endX = j
                    endY = i
                }
                boardNote[i][j] = Int.max
            }
        }
    }

    ad.append([startX, startY])
    
    var head = 0 
        
    while head < ad.count {
        let offset = ad[head]
        head += 1
        
        for dxy in dxyArr {
            var nowX = offset[0]
            var nowY = offset[1]
            let count = boardNote[nowY][nowX] + 1
            while nowX >= 0 && nowX <= (maxX - 1) && nowY >= 0 && nowY <= (maxY - 1) {
                let nextX = nowX + dxy[0]
                let nextY = nowY + dxy[1]
                if nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY {
                    if boardNote[nowY][nowX] > count {
                        boardNote[nowY][nowX] = count
                        ad.append([nowX, nowY])
                    } 
                    break
                } else if boardNote[nextY][nextX] == -1 {
                    if boardNote[nowY][nowX] > count {
                        boardNote[nowY][nowX] = count
                        ad.append([nowX, nowY])
                    }
                    break 
                }
                
                nowX = nextX
                nowY = nextY
            }
        }
    }


    let result = boardNote[endY][endX]
    
    return result == Int.max ? -1 : result
}