package baekjoon.workbook4.dynamic_plan2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1520 {

    static int[] dx = {-1,1,0,0};   // x축 이동
    static int[] dy = {0,0,-1,1};   // y축 이동

    static int N;
    static int M;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];     // 방문 여부 + 해당 좌표 위치에서 마지막까지 갈 수 있는 방법 횟수 저장

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;      // 아직 방문하지 않았음을 나타내기 위해 -1로 초기화
            }
        }

        dfs(0,0);
        System.out.println(dp[0][0]);
    }

    public static int dfs(int x, int y) {

        // 최종 위치에 정상적으로 도착했다면 횟수 추가
        if(x == N-1 && y == M-1)
            return 1;

        dp[x][y] = 0;   // 현재 위치는 방문했음 체크

        for(int i=0;i<4;i++){
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            // 내리막길인지 체크
            if(tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < M && map[x][y] > map[tmpX][tmpY]) {
                if(dp[tmpX][tmpY] == -1) {   // 다음 위치에 방문한 적이 없다면
                    dp[x][y] += dfs(tmpX,tmpY);     // 다음 위치에서 마지막까지 가는 방법 수 더함
                }
                else {  // 다음 위치에 방문한 적이 있다면
                     dp[x][y] += dp[tmpX][tmpY];
                }
            }
        }

        // 모든 방향 체크 완료 후 횟수 반환
        return dp[x][y];
    }
}
