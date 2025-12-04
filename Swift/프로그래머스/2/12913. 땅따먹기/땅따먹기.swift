import Foundation

func solution(_ land:[[Int]]) -> Int{
    var dp: [[Int]] = [land[0]]
    for i in 1..<land.count {
        var row: [Int] = []
        for j in 0..<4 {
            var previousMax = 0
            for k in 0..<4 {
                guard k != j else { continue }
                previousMax = max(previousMax, dp[i-1][k])
            }
            row.append(previousMax + land[i][j])
        }
        dp.append(row)
    }
    return dp.last!.max()!
}