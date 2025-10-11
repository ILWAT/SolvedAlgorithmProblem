func solution(_ s:String) -> String {
    return String(s.sorted(by: { $0 > $1 }))
}