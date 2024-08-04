# 7490
# 0 만들기
import sys

input = sys.stdin.readline

k = int(input())

def dfs(index, temp):
    # 반환조건 : index가 끝까지 갔을 때
    if index == N:
        if eval(temp.replace(' ', '')) == 0:
            answer.append(temp)
        return
    else:
        index += 1
        dfs(index, temp + ' ' + str(index))
        dfs(index, temp + '+' + str(index))
        dfs(index, temp + '-' + str(index))
    
            
for _ in range(k):
    N = int(input())
    answer = []
    index = 1
    dfs(index, '1')
    for x in sorted(answer):
        print(x)
    print()