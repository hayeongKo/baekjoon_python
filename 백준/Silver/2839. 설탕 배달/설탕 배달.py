kg = int(input())
kg_1 = kg
n5 = 0
n3 = 0
nn = 0



while True:

    if kg % 5 == 0:
        n = kg//5
        print(n)
        break

    if kg < 5:
        if kg == 3:
            n = n5 + 1
            print(n)
            break

        elif kg_1 % 3 == 0:
            n = kg_1//3
            if nn == 0 or nn > n:
                print(n)
                break
            else:
                print(nn)
                break
        else:
            if nn != 0:
                print(nn)
                break
            else:
                print('-1')
                break

    kg -= 5
    n5 += 1

    if kg > 5 and kg % 3 == 0:
        n3 = 0
        n3 = kg // 3
        nn = n5 + n3
        continue

    continue