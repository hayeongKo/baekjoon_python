import sys

input = sys.stdin.readline
N, K, P, X = map(int, input().split(" "))

num_lst = [
    [1, 1, 1, 0, 1, 1, 1], #0
    [0, 0, 1, 0, 0, 1, 0], #1
    [1, 0, 1, 1, 1, 0, 1], #2
    [1, 0, 1, 1, 0, 1, 1], #3
    [0, 1, 1, 1, 0, 1, 0], #4
    [1, 1, 0, 1, 0, 1, 1], #5
    [1, 1, 0, 1, 1, 1, 1], #6
    [1, 0, 1, 0, 0, 1, 0], #7
    [1, 1, 1, 1, 1, 1, 1], #8
    [1, 1, 1, 1, 0, 1, 1], #9
]

reversal = [[] for _ in range(10)] # 반전에 필요한 수

for i in range(10):
    for j in range(10):
        tmp = 0
        for k in range(7):
            if num_lst[i][k] != num_lst[j][k]:
                tmp += 1
        reversal[i].append(tmp)

real = str(X).zfill(K)

def dfs(depth, cnt, string):
    if depth >= len(string):
        if int(string) == X:
            return 0
        elif 1 <= int(string) <= N:
            return 1
        else:
            return 0
    
    rst, cur = 0, int(string[depth])
    for i in range(10):
        if cur != i and (reversal[cur][i] <= cnt):
            dx = string[:depth] + str(i) + string[depth+1:]
            rst += dfs(depth+1, cnt-reversal[cur][i], dx)

        elif cur == i:
            rst += dfs(depth+1, cnt, string)

    return rst

print(dfs(0, P, real))
    