def solution(bandage, health, attacks):
    prev_at = 0
    full = health
    print(full)
    for at, damage in attacks:
        if(prev_at + 1 != at):
            for i in range(1, at-prev_at):
                if(health < full):
                    if(i % bandage[0] == 0):
                        health += bandage[2]
                    health += bandage[1]
                    if(health > full):
                        health = full
                else:
                    continue
                
        health -= damage
        if(health <= 0):
            return -1
        prev_at = at

    return health