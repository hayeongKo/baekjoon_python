def solution(mats, park):
    answer = 0
    mats.sort()
    
    for mat_len in mats:
        for i in range(len(park)):
            for j in range(len(park[0])):
                if(i+mat_len > len(park) or j+mat_len > len(park[0])):
                    continue
                flag = True
                for k in range(mat_len):
                    for u in range(mat_len):
                        if(park[i+k][j+u] != "-1"): flag = False
                if(flag): answer = mat_len
                
    if(answer == 0): 
        return -1
    else:
        return answer