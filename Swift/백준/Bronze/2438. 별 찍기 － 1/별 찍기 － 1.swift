if let input = readLine(), let n = Int(input) {
    for i in 1...n {
        print(String(repeating: "*", count: i))
    }
}