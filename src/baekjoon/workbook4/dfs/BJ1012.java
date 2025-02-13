package baekjoon.workbook4.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1012 {

    static int M;
    static int N;
    static int K;
    static int[][] bat;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for(int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            bat = new int[M][N];
            visited = new boolean[M][N];

            for(int i=0;i<K;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                bat[a][b] = 1;
            }

            for(int i=0;i<M;i++) {
                for(int j=0;j<N;j++) {
                    if(bat[i][j] == 1 && !visited[i][j]) {
                        dfs(i,j);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
            answer = 0;
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        if(bat[x][y] == 1) {
            visited[x][y] = true;
        }

        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < M && ny >=0 && ny < N && bat[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx,ny);
            }
        }
    }
}
