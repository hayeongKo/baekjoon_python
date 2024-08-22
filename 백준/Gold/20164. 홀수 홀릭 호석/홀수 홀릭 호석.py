# 20164
# 홀수 홀릭 호석

import sys

input = sys.stdin.readline
N = list(input().rstrip())

answers = []

def check_odd(N, odd):
    for num in N:
        if int(num) % 2 == 1:
            odd += 1
    return odd

def dfs(N, odd):
    odd = check_odd(N, odd)

    if len(N) == 1: 
        answers.append(odd)
        return
    elif len(N) == 2:
        N = int(N[0]) + int(N[1])
        dfs(list(str(N)), odd)
    
    elif len(N) >= 3:
        for i in range(1, len(N)-1):
            for j in range(i+1, len(N)):
                dfs(list(str(int(''.join(N[:i])) + int(''.join(N[i:j])) + int(''.join(N[j:])))), odd)

    

dfs(N, 0)
print(min(answers), max(answers))