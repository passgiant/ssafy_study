# 11315. 오목 판정

문제 링크:

https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXaSUPYqPYMDFASQ&categoryId=AXaSUPYqPYMDFASQ&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=2

문제는 N개의 줄의 각 줄에는 길이 N인 문자열이 주어졌을 때 돌이 가로, 세로, 대각선 중 하나의 방향으로 다섯개 이상 연속한 부분이 있는지 없는지 판정하는 것입니다.

각 문자는 ‘o’또는 ‘.’으로, ‘o’는 돌이 있는 칸을 의미하고, ‘.’는 돌이 없는 칸을 의미한다.

https://github.com/passgiant/ssafy_study/blob/dongwoo/Day7/Untitled%20(1).png

N을 6이라고 가정했을 때 그림과 같이 6*6형태로 되어있습니다.

N번 만큼 문자열을 입력받아 1차원 배열 arr에 저장한다

for문을 통해 완전탐색을 진행하는데 현재 좌표를 **si,sj**로 설정하고 가로, 세로, 대각선 에 연속된 돌을 찾기 위해 ((0, 1), (1, 0), (1, 1), (-1, 1)) 왼쪽 부터 가로, 세로, 왼쪽 하 대각선, 우측 상 대각선 으로 가는 위치 좌표를 더해 돌을 탐색합니다.

우측 좌측 하 대각선이랑 좌측 상 대각선은 우측 하 랑 우측 상 대각선을 이동하면서 탐색하는 것과 똑같이 때문에 4가지 위치 좌표만 튜플에 넣어 꺼내 탐색합니다.

 

https://github.com/passgiant/ssafy_study/blob/dongwoo/Day7/Untitled%20(2).png

예를 들어 이런 상황일 때, si, sj = 0,0 이고 방향 좌표인 di, dj가 열 방향인 (1,0) 이면 처음 방향 좌표인 행을 탐색했을 때 연속된 돌이 없었기 때문에 열 방향을 탐색합니다.

https://github.com/passgiant/ssafy_study/blob/dongwoo/Day7/Untitled%20(3).png

5번 연속된 돌을 찾아야 하기 때문에 for 루프를 5번 돌고, mul에 인덱스 값을 넣어 루프가 돌아갈 때마다 방향좌표에 인덱스 값을 곱해 현재 좌표를 기준으로 연속된 방향에 5번 돌이 있는지 체크 합니다. 

그렇게 같은 방향에 돌이 있고 범위내에 있으면 pass를 시켜 계속 탐색을 하게 하고 for문을 5번 돌았을 때 문제가 없으면(조건을 만족하기 때문에 5개의 연속 돌이 있는것이다.) ‘YES’를 반환하고

ni,nj가 범위내에 없거나 돌이 없으면 break를 통해 다음 방향으로 체크하겠금 합니다.

그렇게 모든 for문을 돌렸을 때 5개의 연속된 돌을 찾을 수 없으면 return ‘NO’를 반환해줍니다.
https://github.com/passgiant/ssafy_study/blob/dongwoo/Day7/Untitled.png

참고 사이트:

https://www.youtube.com/watch?v=e8ti5nWAqtc
