# 21608
# 상어 초등학교

import sys

def determine_seat(id, like_students, classroom):
    scores = []
    for x in range(1, N+1):
        for y in range(1, N+1):
            if classroom[x][y] == 0: #해당 자리가 비어있을 때
                adjacent = 0
                # 인접한 자리에 좋아하는 학생
                if classroom[x-1][y] in like_students:
                    adjacent += 1
                if classroom[x+1][y] in like_students:
                    adjacent += 1
                if classroom[x][y-1] in like_students:
                    adjacent += 1
                if classroom[x][y+1] in like_students:
                    adjacent += 1
                
                # 빈자리 세기
                empty = 0
                if classroom[x-1][y] == 0:
                    empty += 1
                if classroom[x+1][y] == 0:
                    empty += 1
                if classroom[x][y-1] == 0:
                    empty += 1
                if classroom[x][y+1] == 0:
                    empty += 1

                scores.append([adjacent, empty, x, y])
    
    scores.sort(key=lambda score: (-score[0], -score[1], score[2], score[3]))
    classroom[scores[0][2]][scores[0][3]] = id
    return classroom

input = sys.stdin.readline
N = int(input())
            
classroom = [[0 for _ in range(N+2)] for _ in range(N+2)]

for i in range(N+2): # 벽 설정
    classroom[0][i] = -1
    classroom[N+1][i] = -1
    classroom[i][0] = -1
    classroom[i][N+1] = -1

students = []
for _ in range(N**2):
    student = list(map(int, input().split(" ")))
    students.append(student)
    classroom = determine_seat(student[0], student[1:], classroom)

answer = 0
for x in range(1, N+1):
    for y in range(1, N+1):
        like_students = []
        for student in students:
            if student[0] == classroom[x][y]:
                like_students = student[1:]
        tmp = 0
        if classroom[x-1][y] in like_students:
            tmp += 1
        if classroom[x+1][y] in like_students:
            tmp += 1
        if classroom[x][y-1] in like_students:
            tmp += 1
        if classroom[x][y+1] in like_students:
            tmp += 1
        answer += 0 if tmp == 0 else 10**(tmp-1)

print(answer)