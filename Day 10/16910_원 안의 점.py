
def solution():
    cnt = 0
    for x in range(1, N):
        for y in range(1, N):
            if x**2 + y**2 <= N**2:
                cnt += 1
            else:
                break

    cnt *= 4
    cnt += (4 * N + 1)

    return cnt

T = int(input())

for t in range(1, T + 1):
    N = int(input())
    print(f'#{t} {solution()}')