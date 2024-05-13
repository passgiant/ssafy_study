def power(a, b):
    global result
    if b == B:
        result = a
        return
    power(a * A, b + 1)
    return

T = 10

for _ in range(T):
    test_case = int(input())

    A, B = map(int, input().split())
    result = 0
    print(f'#{test_case}', end=" ")
    power(A, 1)
    print(f'{result}')