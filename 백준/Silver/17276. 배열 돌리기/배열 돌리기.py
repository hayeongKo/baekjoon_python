# 17276
# 배열 돌리기

import sys
from copy import deepcopy

input = sys.stdin.readline

N = int(input())

def print_result(case):
    for line in case:
        print(*line)

for _ in range(N):
    L, degree = map(int, input().split(" "))
    case = []

    for _ in range(L):
        case.append(list(map(int, input().split(" "))))

    temp = deepcopy(case)
    center = (L+1)//2 - 1

    while(True):
        if degree < 0:
            for i in range(1, center+1):
                case[center][center+i] = temp[center+i][center+i]
                case[center][center-i] = temp[center-i][center-i]
                case[center-i][center] = temp[center-i][center+i]
                case[center-i][center+i] = temp[center][center+i]
                case[center-i][center-i] = temp[center-i][center]
                case[center+i][center] = temp[center+i][center-i]
                case[center+i][center+i] = temp[center+i][center]
                case[center+i][center-i] = temp[center][center-i]
            degree += 45
        else:
            for i in range(1, center+1):
                case[center][center+i] = temp[center-i][center+i]
                case[center][center-i] = temp[center+i][center-i]
                case[center-i][center] = temp[center-i][center-i]
                case[center-i][center+i] = temp[center-i][center]
                case[center-i][center-i] = temp[center][center-i]
                case[center+i][center] = temp[center+i][center+i]
                case[center+i][center+i] = temp[center][center+i]
                case[center+i][center-i] = temp[center+i][center]
            degree -= 45
        if (degree == 0):
            break
        temp = deepcopy(case)
    print_result(case)