func solution(_ phone_number:String) -> String {
    let count = phone_number.count
    var answer = ""
    for i in 0..<count-4 {
        answer.append("*")
    }
    answer.append(String(phone_number[phone_number.index(phone_number.endIndex, offsetBy: -4)...]))
    return answer
}