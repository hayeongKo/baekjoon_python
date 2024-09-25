from collections import deque

def bfs(x, y, maps, visited):
    temp = int(maps[x][y])
    queue = deque([(x, y)])
    visited.add((x, y))
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, 1, -1]
    
    while(len(queue) != 0):
        current_x, current_y = queue.popleft()
        for i in range(4):
            nx = current_x + dx[i]
            ny = current_y + dy[i]
            if(0 <= nx < len(maps) and 0 <= ny < len(maps[0])):
                if((nx, ny) not in visited and maps[nx][ny] != "X"):
                    visited.add((nx, ny))
                    queue.append((nx, ny))
                    temp += int(maps[nx][ny])
    
    return temp

def solution(maps):
    answer = []
    visited = set()
    
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if((i, j) not in visited and maps[i][j] != "X"):
                answer.append(bfs(i, j, maps, visited))
                
    answer.sort()
    if len(answer) == 0:
        return [-1]
    else: 
        return answer

                
    
    