package baekjoon.workbook3.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BJ14889 {

    static int N;
    static int[][] startLink;
    static boolean[] visited;
    static int min = 101;

    public static void main(String[] args) throws IOException {

        //System.setIn(new FileInputStream("src/baekjoon/workbook3/backtracking/input14889.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        startLink = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                startLink[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0,0);
        System.out.println(min);

    }

    public static void backtracking(int idx, int cnt) {

         if(cnt == N/2) {
             check();
             return;
         }

        for(int i=idx;i<N;i++) {
            // 방문하지 않은 곳을 체크
            if(!visited[i]) {
                visited[i] = true;
                backtracking(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }

    // 스타트팀, 링크팀 차이 계산, 0일 경우 종료
    static void check() {

        int startTeam = 0;
        int linkTeam = 0;

        for(int i=0;i<N-1;i++) {
            for(int j=i+1;j<N;j++) {
                if(visited[i] && visited[j]) {
                    startTeam += startLink[i][j];
                    startTeam += startLink[j][i];
                }
                else if(!visited[i] && !visited[j]) {
                    linkTeam += startLink[i][j];
                    linkTeam += startLink[j][i];
                }
            }
        }

        min = Math.abs(startTeam - linkTeam);
        if(min == 0) {
            System.out.println(min);
            System.exit(0);
        }
    }
}
