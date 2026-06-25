import Foundation

func solution(_ p:String) -> String {
    return program(p)
}

func program(_ w: String) -> String {
    if w.isEmpty {
        return w
    }
    let divided = divide(w)
    let u = divided.0
    let v = divided.1
    if validate(u) {
        return u + program(v)
    } else {
        var result = "("
        result.append(program(v))
        result.append(")")
        for i in 1..<u.count-1 {
            result.append(u[u.index(u.startIndex, offsetBy: i)] == "(" ? ")" : "(")
        }
        return result
    }
}

func divide(_ w: String) -> (String, String) {
    var balance = 0
    var index: String.Index = w.startIndex
    var u: String = ""
    var v: String = ""
    
    for i in 0..<w.count {
        index = w.index(w.startIndex, offsetBy: i)
        let c = w[index]
        
        u.append(c)
        
        if c == "(" {
            balance += 1
        } else {
            balance -= 1
        }
        
        if balance == 0 {
            break;
        }
    }
    
    if index < w.endIndex {
        let vIndex = w.index(index, offsetBy: 1)
        v = String(w[vIndex..<w.endIndex])
    }
    
    return (u, v)
}

func validate(_ w: String) -> Bool {
    var balance = 0
    for i in 0..<w.count {
        let index = w.index(w.startIndex, offsetBy: i)
        if w[index] == "(" {
            balance += 1
        } else {
            balance -= 1
        }
        
        if (balance < 0) {
            return false
        }
    }
    
    return balance == 0
}