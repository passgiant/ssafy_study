def isValid(row, col):
    global board
    if 0 <= row < H and 0 <= col < W:
        return True
    return False
                

def solution():
    global board
    global now_r, now_c

    for idx in range(N):
        # 전차 방향을 위로 하고, 위쪽이 평지면 위로 한 칸 이동
        if command[idx] == "U":
            # 일단 전차를 뺌
            board[now_r][now_c] = "."
            # 진행 방향으로 한 칸 갈수 있는지 확인
            if isValid(now_r - 1, now_c):
                # 갈 수 있는 칸이면
                if board[now_r - 1][now_c] == ".":
                    # 현재 전차 위치를 갱신
                    now_r -= 1
            # 현재 전차 위치에 전차를 다시 놓음
            board[now_r][now_c] = "^"

        # 전차 방향을 아래로 하고, 아래쪽이 평지면 아래로 한 칸 이동
        elif command[idx] == 'D':
            board[now_r][now_c] = "."
            # 진행 방향으로 한 칸 갈수 있는지 확인
            if isValid(now_r + 1, now_c):
                # 갈 수 있는 칸이면
                if board[now_r + 1][now_c] == ".":
                    # 현재 전차 위치를 갱신
                    now_r += 1
            # 현재 전차 위치에 전차를 다시 놓음
            board[now_r][now_c] = "v"

        # 전차 방향을 왼쪽으로 하고, 왼쪽이 평지면 왼쪽으로 한 칸 이동
        elif command[idx] == "L":
            board[now_r][now_c] = "."
            # 진행 방향으로 한 칸 갈수 있는지 확인
            if isValid(now_r, now_c - 1):
                # 갈 수 있는 칸이면
                if board[now_r][now_c - 1] == ".":
                    # 현재 전차 위치를 갱신
                    now_c -= 1
            # 현재 전차 위치에 전차를 다시 놓음
            board[now_r][now_c] = "<"
        # 전차 방향을 오른쪽으로 하고, 오른쪽이 평지면 오른쪽으로 한 칸 이동

        elif command[idx] == "R":
            board[now_r][now_c] = "."
            # 진행 방향으로 한 칸 갈수 있는지 확인
            if isValid(now_r, now_c + 1):
                # 갈 수 있는 칸이면
                if board[now_r][now_c + 1] == ".":
                    # 현재 전차 위치를 갱신
                    now_c += 1
            # 현재 전차 위치에 전차를 다시 놓음
            board[now_r][now_c] = ">"

        # 전차가 바라보는 방향으로 포탄 발사
        # 벽돌 (*)에 닿는다면 벽돌 부수고 포탄 사라짐
        # 포탄은 맵 끝까지 갈 수 있음
        # 강철 (#)에 닿으면 그냥 포탄만 사라짐
        elif command[idx] == "S":
            # 포탄을 쏘기 시작한 위치
            shoot_r = now_r
            shoot_c = now_c
            # 전차가 바라보는 위치
            if board[now_r][now_c] == "^":
                dr, dc = -1, 0
            elif board[now_r][now_c] == "v":
                dr, dc = 1, 0
            elif board[now_r][now_c] == ">":
                dr, dc = 0, 1
            else:
                dr, dc = 0, -1

            while True:
                shoot_r += dr
                shoot_c += dc

                if isValid(shoot_r, shoot_c):
                    if board[shoot_r][shoot_c] == "*":
                        board[shoot_r][shoot_c] = "."
                        break
                    elif board[shoot_r][shoot_c] == "#":
                        break
                else:
                    break
                                    

T = int(input())

for test_case in range(1, T  + 1):
    H, W = map(int, input().split())
    
    board = []

    for i in range(H):
        temp = list(input())
        if "<" in temp:
            now_r, now_c = i, temp.index("<")
        elif ">" in temp:
            now_r, now_c = i, temp.index(">")
        elif "^" in temp:
            now_r, now_c = i, temp.index("^")
        elif "v" in temp:
            now_r, now_c = i, temp.index("v")

        board.append(temp)
        
    
    N = int(input())
    
    command = input()

    solution()

    print(f'#{test_case}', end=" ")
    for row in board:
        print("".join(row))