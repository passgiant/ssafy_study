from collections import deque

# 현재 라운드, 규영 점수, 인영 점수, 현재 인영 카드조합
def back_tracking(round, gyu_score, in_score, _in_yeong):
    global win, lose, draw
    if round > len:
        if gyu_score > in_score:
            win += 1
        elif gyu_score < in_score:
            lose += 1
        return

    for _ in range(len - round + 1):
        now_inyeong = _in_yeong.popleft()
        if now_inyeong > gyu_yeong[round - 1]:
            in_score += (now_inyeong + gyu_yeong[round - 1])
        else:
            gyu_score += (now_inyeong + gyu_yeong[round - 1])
        
        back_tracking(round + 1, gyu_score, in_score, _in_yeong)
        _in_yeong.append(now_inyeong)
        if now_inyeong > gyu_yeong[round - 1]:
            in_score -= (now_inyeong + gyu_yeong[round - 1])
        else:
            gyu_score -= (now_inyeong + gyu_yeong[round - 1])
    
        

T = int(input())

len = 9

for test_case in range(1, T + 1):
    gyu_yeong = list(map(int, input().split()))

    in_yeong = deque([])
    for i in range(1, 2 * len + 1):
        if i not in gyu_yeong:
            in_yeong.append(i)

    
    win, lose = 0, 0
    back_tracking(1, 0, 0, in_yeong)

    print(f'#{test_case} {win, lose}')