n = int(input())
people = list(map(int, input().split()))
totalResult = 0
waitTime = 0
people.sort()

for i in people:
  totalResult = totalResult + waitTime +i
  waitTime += i

print(totalResult)