def solution():
    cnt = 0
    bit = 0
    for idx in range(len(memory)):
        if int(memory[idx]) != bit:
            cnt += 1
            bit += 1
            bit %= 2

    return cnt

T = int(input())

for test_case in range(1, T + 1):
    memory = input()

    print(f'#{test_case} {solution()}')