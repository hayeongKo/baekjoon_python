import sys

input = sys.stdin.readline
people = []

for i in range(int(input())):
    name, status = map(str, input().split())

    if status == "enter":
        people.append(name)
    else: 
        people.remove(name)

people.sort(reverse=True)

for person in people:
    print(person)