import Foundation

func solution(_ answers:[Int]) -> [Int] {
    let student1 = [1, 2, 3, 4, 5]
    let student2 = [2, 1, 2, 3, 2, 4, 2, 5]
    let student3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    var scores: [(Int, Int)] = [(1, 0), (2, 0), (3, 0)]
    
    let s1Count = student1.count
    let s2Count = student2.count
    let s3Count = student3.count
    
    for i in 0..<answers.count {
        let currentAnswer = answers[i]
        
        if currentAnswer == student1[i % s1Count] {
            scores[0] = (scores[0].0, scores[0].1 + 1)
        }
        
        if currentAnswer == student2[i % s2Count] {
            scores[1] = (scores[1].0, scores[1].1 + 1)
        }
        
        if currentAnswer == student3[i % s3Count] {
            scores[2] = (scores[2].0, scores[2].1 + 1)
        }
    }
    
    let sorted = scores.sorted(by: { $0.1 > $1.1 })
    let topScore = sorted.first!.1
    
    var result: [Int] = []
    for person in sorted {
        if person.1 == topScore {
            result.append(person.0)
        }
    }
    
    
    
    return result
}