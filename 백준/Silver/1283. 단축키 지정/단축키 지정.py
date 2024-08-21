# 단축키 지정
# 1283

import sys

input = sys.stdin.readline

N = int(input())
short_cut = []

def get_result(word, flag):
    if flag == 1: # 이미 단축어로 등록되어 있으면 그대로 리턴
        return ''.join(word), flag
    
    temp = ""
    # 단축어로 등록이 안되어 있고
    for i in range(len(word)):
        if word[i].lower() not in short_cut: # 해당 문자로 단축된 단어가 없다면
            short_cut.append(word[i].lower())
            temp += "[" + word[i] + "]" + ''.join(word[i+1:])
            flag = 1
            return temp, flag
        else:
            temp += word[i]
    
    return temp, flag

def find_not_sc(words):
    idx = 0
    for i in range(len(words)):
        if words[i][0].lower() in short_cut:
            idx += 1
        else:
            return idx
    return idx

for _ in range(N):
    words = list(input().rstrip().split(" "))
    idx = find_not_sc(words)
    flag = 0
    result = ""

    # 첫번째 문자가 단축키가 아닌 것이 없다면
    if idx >= len(words):
        for word in words:
            temp, flag = get_result(list(word), flag)
            result += temp + " "
    else:
        for i in range(len(words)):
            if idx != i:
                result += words[i] + " "
            else:
                short_cut.append(words[i][0].lower())
                result += "[" + words[i][0] + "]" + words[i][1:] + " "

    print(result.removesuffix(" "))
