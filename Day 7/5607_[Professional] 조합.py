'''
분할 정복 기법

X**10 = X**5 * X**5
X**5 = X**1 * X**2 * X**2 ...
지수가 짝수 : 지수를 2로 나눈 몫을 각각 지수로 하는 두 거듭제곱을 곱함
지수가 홀수 : 지수를 2로 나눈 몫을 각각 지수로 하는 두 거듭제곱을 곱하고 밑의 1제곱 수를 다시 곱함
'''
def div_pow(n1, n2):
    if n2 == 0:
        return 1
    ans = div_pow(n1, n2 // 2)
    if n2 % 2 == 0:
        return (ans * ans) % C
    else:
        return ((ans * ans) * n1) % C 


def solution():
    N, R = map(int, input().split())

    '''
    (n! (mod C)) * ((r! * (n - r)!)^(C - 2)) (mod C))
    = (n! (mod C)) * ((r! (mod C)) * ((n - r)!) (mod C))^(C - 2)
    
    a = n! (mod C)

    b = (r! (mod C) * (n - r)! (mod C) )^(C - 2)
    '''

    a = fibo[N]
    
    # (n1 mod m * n2 mod m) mod m = (n1 * n2) mod m
    b = div_pow((fibo[R] * fibo[N - R]) % C, C - 2)


    return (a * b) % C


T = int(input())

C = 1234567891

fibo = {}
fibo[0] = 1 % C

for i in range(1, 1000001):
    fibo[i] = (fibo[i - 1] * i) % C

for test_case in range(1, T + 1):

    print(f'#{test_case} {solution()}')