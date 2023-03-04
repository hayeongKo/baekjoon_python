n = int(input())
k = set(map(int, input().split()))
e = int(input())
j = list(map(int, input().split()))

for l in j:
    if l in k:
        print(1, end=" ")
    else:
        print(0, end=" ")