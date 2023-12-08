import sys

input = sys.stdin.readline

n = int(input())
k = [0]*(10000+1)

for i in range(n):
    k[int(input())] += 1
    
for i in range(len(k)):
    if (k[i] == 0):
        pass
    else:
        for _ in range(k[i]):
            print(i)