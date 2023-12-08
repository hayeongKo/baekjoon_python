import sys

input = sys.stdin.readline

n, k = map(int, input().split())
lst = list(map(int, input().split()))

print(sorted(lst)[len(lst)-k])
