def solution(N, building):
    num = 0

    for i in range(2, N - 2):
        standard = building[i]
        compair = building[i - 2 : i + 3]
        highest = 0
        for j in range(5):
            if j == 2:
                continue
            if compair[j] > standard:
                highest = standard
                break
            else:
                highest = max(highest, compair[j])
        num += (standard - highest)

    return num

T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    building = list(map(int, input().split()))

    result = solution(N, building)
    print(f'#{test_case} {result}')
