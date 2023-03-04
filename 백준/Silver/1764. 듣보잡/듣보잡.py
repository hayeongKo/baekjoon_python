N, M = map(int, input().split())

N_lst = set()
answer = 0
answer_lst = list()
for _ in range(N):
    i = input()
    N_lst.add(i)

for _ in range(M):
    k = input()
    if k in N_lst:
        answer += 1
        answer_lst.append(k)

print(answer)
answer_lst.sort()
print('\n'.join(answer_lst))