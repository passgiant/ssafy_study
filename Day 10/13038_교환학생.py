
def solution():
    # 최소 이수 일자
    cnt = 10**5 * 7 + 1
    for idx in range(class_cnt):
        # 현재 경우의 이수 일자
        _cnt = 0
        now_date = start_date[idx]
        left_date = n
        while left_date > 0:
            now_date %= 7
            _cnt += 1

            if plan[now_date] == 1:
                left_date -= 1

            now_date += 1

        cnt = min(cnt, _cnt)

    return cnt


T = int(input())

for t in range(1, T+1):
    n = int(input())
    plan = list(map(int, input().split()))
    start_date = []
    class_cnt = 0
    for i in range(7):
        if plan[i] == 1:
            start_date.append(i)
            class_cnt += 1
    print(f'#{t} {solution()}')