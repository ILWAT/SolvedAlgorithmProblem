import Foundation

func solution(_ genres:[String], _ plays:[Int]) -> [Int] {
    var idxMap: [String: [Int]] = [:] // 장르: [idx]
    var genresCount: [String: Int] = [:] //장르: 총합
    for idx in 0..<genres.count {
        let genre = genres[idx]
        let play = plays[idx]
        genresCount[genre] = (genresCount[genre] ?? 0) + play
        
        var newValue = idxMap[genre] ?? []
        newValue.append(idx)
        newValue.sort(by: { plays[$0] != plays[$1] ? plays[$0] > plays[$1] : $0 < $1 })
        if newValue.count > 2{
            newValue.removeLast()
        }
        idxMap[genre] = newValue
    }
    
    let sortedBestGenre = genresCount.sorted{ $0.value > $1.value }.map{ $0.key }
    var answer: [Int] = []
    for genre in sortedBestGenre {
        answer.append(contentsOf: idxMap[genre]!)
    }
    
    return answer
}