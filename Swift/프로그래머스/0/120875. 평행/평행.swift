import Foundation

func solution(_ dots:[[Int]]) -> Int {
    if calculateIncline(dots[0][0], dots[0][1], dots[1][0], dots[1][1]) == calculateIncline(dots[2][0], dots[2][1], dots[3][0], dots[3][1]) {return 1}
    if calculateIncline(dots[0][0], dots[0][1], dots[2][0], dots[2][1]) == calculateIncline(dots[1][0], dots[1][1], dots[3][0], dots[3][1]) {return 1}
    if calculateIncline(dots[0][0], dots[0][1], dots[3][0], dots[3][1]) == calculateIncline(dots[2][0], dots[2][1], dots[1][0], dots[1][1]) {return 1}
    
    return 0
}

func calculateIncline(_ x1: Int, _ y1: Int, _ x2: Int, _ y2:Int) -> Double {
    return Double(y2-y1)/Double(x2-x1)
}