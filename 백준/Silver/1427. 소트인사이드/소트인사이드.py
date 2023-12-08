import sys

input = sys.stdin.readline

n = int(input())
k = len(str(n))

n_lst = []

for i in range(1, k+1):
    n_lst.append(n%10)
    n = n//10

n_lst.sort()
result = ""

while True:
    if (len(n_lst)==0):
        break
    result += str(n_lst.pop())

print(result)