def solution(hp):
    answer = 0
    army = [5, 3, 1]
    for soldier in army:
        if hp >= soldier:
            answer += (hp//soldier)
            hp %= soldier
    return answer