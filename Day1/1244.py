def dfs(n):
    global answer
    if n==N: # 교환횟수(n)이 최대교환 횟수(N)이랑 같으면
        answer = max(answer, int("".join(map(str, lst))))
        return       
    for i in range(L-1):
        for j in range(i+1, L):
            lst[i], lst[j] = lst[j], lst[i]
 
            chk = int("".join(map(str, lst)))
            if (n, chk) not in v:
                dfs(n+1)
                v.append((n,chk))
 
            lst[j], lst[i] = lst[i], lst[j]
 
 
T = int(input())
 
for test_case in range(1, T + 1):
    st, t = map(str, input().split())
    N = int(t)
    lst, v = [], []
    L = len(st)
    answer = 0
    for i in st:
        lst.append(i)
    dfs(0)
    print(f'#{test_case} {answer}')