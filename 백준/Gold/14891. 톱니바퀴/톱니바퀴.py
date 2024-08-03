import sys
from collections import deque

input = sys.stdin.readline

gears = []
for _ in range(4):
    gears.append(deque(list(input().rstrip())))

K = int(input())

def rotate_left(index, rotates):
    for i in range(0, index):
        if gears[index-i][6] != gears[index-i-1][2]:
            rotates[index-i-1] = rotates[index-i]*(-1)
        else:
            return

def rotate_right(index, rotates):
    for i in range(index, 3):
        if gears[i][2] != gears[i+1][6]:
            rotates[i+1] = rotates[i]*(-1)
        else:
            return

for _ in range(K):
    rotates = [0, 0, 0, 0]
    index, rotate = map(int, input().split(" "))
    rotates[index-1] = rotate

    #회전
    rotate_left(index-1, rotates)
    rotate_right(index-1, rotates)

    # print()
    # print(rotates)
    for i in range(len(rotates)):
        gears[i].rotate(rotates[i])

answer = 0
for i in range(4):
    if gears[i][0] == '1':
        answer += 2**i
print(answer)
    