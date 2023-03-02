n = int(input())

for _ in range(n):
    lst = list()
    flag = 0
    sentence = input()
    for i in range(len(sentence)):
        if sentence[i] == '(':
            lst.append(1)
        else:
            if len(lst) == 0:
                print('NO')
                flag = 1
                break
            lst.pop()

    if len(lst) != 0:
        print('NO')
    else:
        if flag == 0:
            print('YES')