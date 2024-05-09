def dfs(now_v, cnt):
    global max_cnt
    global far_v

    if visited[now_v]:
        return
    
    # 방문 표시
    visited[now_v] = True
    # 경로 상의 노드 개수 1 추가
    cnt += 1
    # 최대 경로 거리보다 길다면
    if max_cnt < cnt:
        # 가장 먼 정점을 갱신
        far_v = now_v
        # 최대 경로 거리 또한 갱신
        max_cnt = cnt

    # 방문한 노드와 이어진 방문 가능한 노드를 다음 방문 노드로 채택 및 dfs 이어가기
    for next_v in graph[now_v]:
        if not visited[next_v]:
            dfs(next_v, cnt)
            # 사이클이 존재할 수 있는 그래프임
            # 방문했던 노드를 다른 경로로 재방문 가능하도록 방문기록을 False로 돌려줌
            visited[next_v] = False
        

T = int(input())

for test_case in range(1, T + 1):
    N, M = map(int, input().split())

    visited = [False] * (N + 1)

    # 0번째 인덱스는 더미 인덱스
    graph = [[] for _ in range(N + 1)]
    for _ in range(M):
        v1, v2 = map(int, input().split())
        graph[v1].append(v2)
        graph[v2].append(v1)

    # 1번 정점에서 가장 먼 정점 확인
    max_cnt = 0
    far_v = -1
    dfs(1, 0)   

    # far_v를 루트노드로 하여 dfs를 재수행
    # far_v를 기준으로 가장 먼 정점이 경로상 가장 먼 경로이다.
    max_cnt = 0
    visited = [False] * (N + 1)
    dfs(far_v, 0)
    
    print(f'#{test_case} {max_cnt}')
