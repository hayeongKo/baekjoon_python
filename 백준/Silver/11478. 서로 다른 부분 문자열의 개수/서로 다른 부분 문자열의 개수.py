import sys

input = sys.stdin.readline

string = input().removesuffix("\n")
result = set()

for i in range(len(string)):
    for j in range(i+1, len(string)+1):
        result.add(string[i:j])

print(len(result))


