from collections import deque

def solution():
    get_index = False
    get_cnt = False
    idx = 0
    while command:
        now = command.popleft()
        if now == "I":
            get_index = True
            continue
        if get_index == True:
            idx = int(now) - 1
            get_index = False
            get_cnt = True
            continue
        if get_cnt == True:
            get_cnt = False
            continue

        idx += 1
        code.insert(idx, now)


T = 10

for t in range(1, T + 1):
    N = int(input())
    code = list(map(str, input().split()))
    command_N = int(input())
    command = deque(list(map(str, input().split())))

    solution()

    result = code[:10]

    print(f'#{t} {" ".join(result)}')