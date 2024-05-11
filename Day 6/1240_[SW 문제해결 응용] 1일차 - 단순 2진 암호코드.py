def decoding(s):
    result = ""

    now = s[0]
    cnt = 0
    for i in range(7):
        if s[i] == now:
            cnt += 1
        else:
            result += str(cnt)
            now = s[i]
            cnt = 1
        
        if i == 6:
            result += str(cnt)
    
    if result == "3211":
        return 0
    elif result == "2221":
        return 1
    elif result == "2122":
        return 2
    elif result == "1411":
        return 3
    elif result == "1132":
        return 4
    elif result == "1231":
        return 5
    elif result == "1114":
        return 6
    elif result == "1312":
        return 7
    elif result == "1213":
        return 8
    elif result == "3112":
        return 9

    # 예외사항 있는지 확인
    else:
        print("예외 있음")
        exit(0)


def solution():
    idx = 0
    
    decoded_result = []

    sliced = ""
    while idx < len(code):
        if (idx + 1) % 7 == 0:
            sliced += code[idx]

            num = decoding(sliced)
            decoded_result.append(num)

            sliced = ""
        else:
            sliced += code[idx]

        idx += 1

    odd = 0
    even = 0

    for i in range(8):
        if (i + 1) % 2 == 0:
            even += decoded_result[i]
        else:
            odd += decoded_result[i]
    
    if (3 * odd + even) % 10 == 0:
        return sum(decoded_result)
    else:
        return 0

T = int(input())

for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    
    _code = ""
    for _ in range(N):
        row = input()
        if row != "0" * M:
            _code = row
    
    end_point = M - 1

    for i in range(end_point, -1, -1):
        if _code[i] == "1":
            end_point = i
            break
        
    temp = list(_code)
    code = temp[end_point - 55 : end_point + 1]

    print(f'#{test_case} {solution()}')