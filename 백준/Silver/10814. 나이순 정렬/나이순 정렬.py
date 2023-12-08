import sys

input = sys.stdin.readline
p_lst = [[] for _ in range(200+1)]

for _ in range(int(input())):
    age, name = map(str, input().split())
    p_lst[int(age)].append(name)

for person in p_lst:
    if len(person) != 0:
        while True:
            if len(person) == 0:
                break
            print(p_lst.index(person), person.pop(0))
