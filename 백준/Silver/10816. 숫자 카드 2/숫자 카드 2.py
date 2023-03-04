import sys
input = sys.stdin.readline
N = int(input())
n_lst = list(map(int, input().split()))
M = int(input())
M_lst = list(map(int, input().split()))
hashmap = {}
for n in n_lst:
    if n in hashmap:
        hashmap[n] += 1
    else:
        hashmap[n] = 1
print(' '.join(str(hashmap[m]) if m in hashmap else '0' for m in M_lst))