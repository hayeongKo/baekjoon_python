sentence = input().split('-')

result = 0
for i in range(len(sentence)):
    nums = sentence[i].split('+')
    for n in range(len(nums)):
        if i == 0:
            result += int(nums[n])
        else:
            result -= int(nums[n])

print(result)