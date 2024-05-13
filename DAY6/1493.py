import sys
sys.stdin = open("input.txt", "r")

# 2차원 평면 제 1사분면 위의 격자점 만드는 과정
# 좌표 값을 담을 딕셔너리
dct = {}
# 값을 넣을 딕셔너리
r_dct = {}
# 초기 i,j 값을 1로 초기화, (1,1)
i, j = 1, 1
for n in range(1, 50000):
    # 값 -> 좌표, dct[n]에 좌표값 넣기
    dct[n] = (i, j)
    # 좌표 -> 값, r_dct에 좌표값 넣기
    r_dct[(i, j)] = n
    # 좌표, 값을 넣고 나서 i, j 초기화
    i, j = i -1, j + 1
    # i가 1보다 작으면 n값을 넣을 수 없기 때문에 i, j 재조정
    if i < 1:
        i, j = j , 1

T = int(input())

for test_case in range(1, T + 1):
    #연산할 p, q 값을 받는다.(p★q)
    p, q = map(int, input().split())
    # dct 에 p값을 넣으면 p값에 대한 i,j 값을 pi, pj 변수에 할당
    pi, pj = dct[p]
    # dct 에 q값을 넣으면 q값에 대한 i,j 값을 qi, qj 변수에 할당
    qi, qj = dct[q]
    # 안쪽 좌표 끼리 더하고 그 좌표를 r_dct에 넣으면 값을 알 수 있다.
    ans = r_dct[(pi + qi, pj + qj)]
    print(f"#{test_case} {ans}")
