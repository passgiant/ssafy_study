def isValid(i):
    for j in range(i):
        if col[i] == col[j] or abs(col[i] - col[j]) == abs(i - j):
            return False

    return True

def back_tracking(n):
    global cnt

    if n == N:
        cnt += 1
        return
    for i in range(N):
        col[n] = i
        if isValid(n):
            back_tracking(n + 1)


T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    cnt = 0
    col = [0 for _ in range(N)]

    back_tracking(0)

    print(f'#{test_case} {cnt}')