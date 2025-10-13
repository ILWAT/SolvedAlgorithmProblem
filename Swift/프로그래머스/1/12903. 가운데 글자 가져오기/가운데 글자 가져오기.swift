func solution(_ s:String) -> String {
    let halfInt = Int(s.count/2)
    let halfIndex = s.index(s.startIndex, offsetBy: halfInt)
    var resultString: String = String(s[halfIndex])
    
    if s.count % 2 == 0 {
        resultString = String(s[s.index(s.startIndex, offsetBy: halfInt-1)]) + resultString
    }
    
    return resultString
}