import Foundation

func solution(_ a:Int, _ b:Int, _ n:Int) -> Int {
    var myBottle: Int = n
    
    var result: Int = 0
    
    while myBottle >= a {
        let receiveBottle: Int = (myBottle / a) * b
        result += receiveBottle
        myBottle = (myBottle % a) + receiveBottle
    }
    
    
    return result
}