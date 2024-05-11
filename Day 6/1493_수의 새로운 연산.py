
def solution():
    p_point = []
    p_cross_start = -1
    p_cross_start_point = []
    
    for i in range(1, cross_start_len - 2):
        if cross_start[i] <= p < cross_start[i + 1]:
            p_cross_start = cross_start[i]
            p_cross_start_point = [i, 1]
            break
    
    p_point = [p_cross_start_point[0] - (p - p_cross_start), p_cross_start_point[1] + (p - p_cross_start)]
    
    q_point = []
    q_cross_start = -1
    q_cross_start_point = []

    for i in range(1, cross_start_len - 2):
        if cross_start[i] <= q < cross_start[i + 1]:
            q_cross_start = cross_start[i]
            q_cross_start_point = [i, 1]
            break
    
    q_point = [q_cross_start_point[0] - (q - q_cross_start), q_cross_start_point[1] + (q - q_cross_start)]

    re_point = [p_point[0] + q_point[0], p_point[1] + q_point[1]]
    gap = 0
    while True:
        if re_point[1] == 1:
            break
        re_point[0] += 1
        re_point[1] -= 1
        gap += 1

    return cross_start[re_point[0]] + gap


T = int(input())

gap = 1

# 4번째 인덱스 값이 7 = 4행1열의 값은 7이다 
cross_start = [0, 1]

while True:
    if cross_start[-1] > 40000:
        break
    cross_start.append(cross_start[-1] + gap)
    gap += 1

cross_start_len = len(cross_start)


for test_case in range(1, T + 1):
    p, q = map(int, input().split())
    
    print(f'#{test_case} {solution()}')