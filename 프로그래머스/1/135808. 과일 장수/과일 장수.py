def solution(k, m, score):
    answer = 0
    score.sort(reverse=True)
    temp = []
    for i in score:
        temp.append(i)
        if len(temp) == m:
            answer += min(temp) * m
            temp = []
    return answer