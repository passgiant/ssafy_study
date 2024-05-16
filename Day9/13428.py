import sys
sys.stdin = open("sample_input.txt", "r")

T = int(input())
def swap(i, j, string):
    # 받은 문자열을 리스트로 변환
    lst = list(string)
    # i, j 인덱스에 있는 값 체인지
    lst[i], lst[j] = lst[j], lst[i]
    # 위치 바꾼 리스트 값 다시 문자열로 반환
    num = ''.join(lst)
    return num

for tc in range(1, T + 1):
    # 숫자 입력
    N = input().rstrip()
    result_min = int(N)
    result_max = int(N)
    for i in range(len(N)-1):
        for j in range(1, len(N)):
            num = swap(i, j, N)
            if num[0] == '0':
                continue
            if int(num) > result_max:
                result_max = int(num)
            if int(num) < result_min:
                result_min = int(num)
    print(f"#{tc} {result_min} {result_max}")
