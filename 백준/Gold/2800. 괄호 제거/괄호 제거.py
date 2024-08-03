import sys
from itertools import combinations

input = sys.stdin.readline

bracket = []
left = []
answers = []

sentence = input().rstrip()

for i in range(len(sentence)):
    if sentence[i] == '(':
        left.append(i)
    elif sentence[i] == ')':
        bracket.append([i, left.pop()])

for i in range(1, len(bracket)+1):
    for pair in list(combinations(bracket, i)):
        temp = list(sentence)
        for x, y in pair:
            temp[x], temp[y] = '', ''
        answers.append(''.join(temp))

for answer in sorted(set(answers)):
    print(answer)