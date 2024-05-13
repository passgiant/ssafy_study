import sys
sys.stdin = open("sample_input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    # 보드판의 크기. 돌을 넣는 횟수
    N, M = map(int, input().split())
    # 2차원 배열 N * N 크기 만큼 0으로 초기화
    arr = [[0] * (N+1) for _ in range(N+1)]
    # 보드판의 중앙 행과 열의 인덱스 계산
    m = N//2
    # 초기 보드판 정가운데 백돌 흑돌 세팅
    arr[m][m] = arr[m+1][m+1] = 2
    arr[m][m+1] = arr[m+1][m] = 1


    for _ in range(M):
        # 내가 놓을 행,열 좌표에 흑돌(1) 또는 백돌(2) 놓기
        si, sj, d = map(int,input().split())
        arr[si][sj] = d
        # 돌을 놓은 위치(si, sj)를 기준으로 8방향으로 탐색을 진행합니다. (좌상대, 위, 우상대, 우, 우하대, 하, 좌하대, 좌)
        for di, dj in ((-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)):
            # 반전 시킬 후보들을 저장할 리스트
            r = []
            # 다음 방향으로 탐색할 횟수
            for mul in range(1, N):
                ni, nj = si + di * mul, sj + dj * mul
                # ni, nj가 보드판 내에 있으면
                if 1 <= ni <= N and 1 <= nj <= N:
                    # ni, nj 좌표 값이 비어져 있으면 종료(같은 돌 사이에 있어야 반전시키는데 빈 값이면 바꿀 수 없기 때문에 종료)
                    if arr[ni][nj] == 0:
                        break
                    # 이동한 위치에 같은 돌이 있다면, 반전시킬 후보에서 값들을 꺼내 반전, 만약 같은 돌이 있어도
                    # 다음 이동한 곳에다른 돌이 없다면 반전이 안된다.
                    elif arr[ni][nj] == d:
                        while r:
                            ti, tj = r.pop()
                            arr[ti][tj] = d
                        break
                    # 이동한 위치에 다른 돌이 있다면, 반전시킬 후보에 값을 추가
                    else:
                        r.append((ni, nj))
                # ni, nj가 보드판 내에 없으면 범위에 벗어났기 때문에 종료, 다음 방향으로 탐색
                else:
                    break
    # 흑돌, 백돌 초기화
    bcnt = wcnt = 0
    # 보드판에서 백돌과 흑돌에 숫자 카운트
    for lst in arr:
        bcnt += lst.count(1)
        wcnt += lst.count(2)

    print(f"#{test_case} {bcnt} {wcnt}")
