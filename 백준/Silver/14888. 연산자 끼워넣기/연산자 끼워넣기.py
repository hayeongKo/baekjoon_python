import sys
from itertools import permutations

input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
how = list(map(int, input().split()))
hows = []

for i in range(4):
    if i == 0:
        for _ in range(how[i]):
            hows.append("+")
    elif i == 1:
        for _ in range(how[i]):
            hows.append("-")
    elif i == 2:
        for _ in range(how[i]):
            hows.append("*")
    elif i == 3:
        for _ in range(how[i]):
            hows.append("/")

result_lst = []

for how in list(permutations(hows, n-1)):
    result = nums[0]
    for i in range(1, n):
        x = how[i-1]
        if x == "+":
            result += nums[i]
        elif x == "-":
            result -= nums[i]
        elif x == "*":
            result *= nums[i]
        elif x == "/":
            if result < 0:
                result *= -1
                result //= nums[i]
                result *= -1
            else:
                result //= nums[i]
    result_lst.append(result)

print(max(result_lst))
print(min(result_lst))

