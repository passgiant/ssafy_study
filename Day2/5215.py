import sys
sys.stdin = open("sample_input.txt", "r")

def dfs(idx, score, calorie):
    print(f"현재 인덱스: {idx}, 현재까지의 맛 점수: {score}, 현재까지의 칼로리: {calorie}")
    global max_score
    if calorie > L:  # 제한 칼로리를 초과하면 종료
        return
    if idx == N:  # 모든 재료를 다 고려했을 때
        max_score = max(max_score, score)  # 최대 맛 점수 업데이트
        return
    # 해당 재료를 선택하는 경우
    dfs(idx + 1, score + lst[idx][0], calorie + lst[idx][1])
    print(f"선택한 재료: {lst[idx]}, 맛 점수 증가량: {lst[idx][0]}, 칼로리 증가량: {lst[idx] [1]}")
    # 해당 재료를 선택하지 않는 경우
    dfs(idx + 1, score, calorie)

T = int(input())  # 테스트 케이스의 수
for tc in range(1, T + 1):
    N, L = map(int, input().split())  # 재료의 수, 제한 칼로리
    lst = [list(map(int, input().split())) for _ in range(N)]  # 재료에 대한 맛 점수와 칼로리
    max_score = 0  # 최대 맛 점수 초기화
    dfs(0, 0, 0)  # DFS 탐색 시작
    print(f"#{tc} {max_score}")  # 결과 출력