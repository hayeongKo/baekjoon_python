n = int(input())

n_lst = list()
for _ in range(n):
    a = int(input())
    if a == 0:
        n_lst.pop()
    else:
        n_lst.append(a)
print(sum(n_lst))