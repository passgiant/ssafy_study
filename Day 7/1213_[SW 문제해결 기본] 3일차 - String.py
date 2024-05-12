
def solution():
    p_len = len(p)
    s_len = len(s)
    
    cnt = 0

    for i in range(s_len - p_len + 1):
        if s[i] == p[0]:
            compair = s[i: i + p_len]
            if compair == p:
                cnt += 1
    

    return cnt

T = 10

for _ in range(1, T + 1):
    test_case = int(input())
    p = input()
    s = input()

    print(f'#{test_case} {solution()}')