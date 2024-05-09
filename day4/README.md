## 2814. 최장 경로 구하기

단순한 DFS 또는 BFS 문제인줄 알았는데, 아니어서 애를 많이 먹었습니다...

반례:
![IMG_744417B6199C-1](https://github.com/passgiant/ssafy_study/assets/64718002/76cf7260-ae44-4462-b603-f3bb7bd960ad)

정답: 4
일반적인 DFS로 풀면? : 3 (1부터 체크한다고 치면, 1 -> 2 -> 6 이렇게 3)
일반적인 BFS로 풀면? : 6 (모든 노드를 다 방문하기 때문)

따라서 dfs 함수를 들어갈 때 `vis[node] = true`로 만들어 주고, 해당 경로로 깊이 우선 탐색을 마치고 빠져 나올때 `vis[node] = false`를 해주는 식으로 해결하였습니다.
빠져나올 때 `vis[node] = false`를 해주는 이유는, `1`에서 시작할 때는 `1 -> 2 -> 6`이렇게 길이가 3으로 끝나지만, 1, 2, 6을 다시 방문을 안한 것으로 처리해줌으로써
나중에 `3`번 노드에서 시작했을 때 `3 -> 1 -> 2 -> 6`으로 길이가 4인 경로를 탐색할 수 있도록 하기 위함입니다.


```java
    private static void dfs(int node, int dist) {
        ans = Math.max(ans, dist);
        vis[node] = true;
        
        List<Integer> nexts = adj.get(node);
        for(int next : nexts) {
            if(vis[next]) continue;
            dfs(next, dist+1);
        }
        
        vis[node] = false; // ⭐️ 이부분이 포인트
    }
```
