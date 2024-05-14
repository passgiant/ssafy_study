## 1213. [S/W 문제해결 기본] 3일차 - String
문제 링크:

https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV14P0c6AAUCFAYi&categoryId=AV14P0c6AAUCFAYi&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=3

처음에 문제를 보고 D3에 쉬운 문제가 있을 수 없다고 생각하여 고민을 해봤다. 하지만 풀어보니 그냥 쉬운 문제였다…

문제는 주어진 문자열에서 특정한 문자열의 수를 반환하는 프로그램을 작성하는 것이다.

보자마자 .count() 내장함수를 생각났고. 변수에 문자열을 받은 후 특정한 문자열을 count()내장 함수 매개변수에 넣어 그 결과값을 ans에 받는다.
![Untitled (4)](https://github.com/passgiant/ssafy_study/assets/107997462/b32555ca-ed72-4e86-9834-74ef8e51b10a)
너무 쉽기도 했고, 몬가 내장함수를 사용하면 안될 것 같아서 다른 코드를 작성해 보았습니다.
![Untitled (5)](https://github.com/passgiant/ssafy_study/assets/107997462/929e8ee7-3374-4a1b-8067-a0d226f1be6f)
for문을 통해 입력받은 st문자열 인덱스 0부터 길이 만큼 돌면서 찾을려는 값에 첫번째 값과 같다면,
인덱스 슬라이싱을 통해 i부터 i + targer에 길이 만큼 슬라이싱 한 값이 target과 같을 때 ans에 카운팅 합니다.
ㄴ이렇게 하는 이유는 문자열에서 target 첫번째 값과 같았을 때 target에 길이 만큼 그 뒤에 값 까지 같은지 확인하기 위함이다.
