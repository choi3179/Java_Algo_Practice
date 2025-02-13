/**
 * 최단거리 찾기(ex.미로)는 bfs를 사용하는게 더 효율적임.
 */
package baekjoon.workbook4.dfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2178 {

    static int[][] miro;
    static boolean[][] visited;
    static int N;
    static int M;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            String[] spl = br.readLine().split("");
            for(int j=0;j<M;j++)
                miro[i][j] = Integer.parseInt(spl[j]);
        }

        bfs(0,0);
        System.out.println(miro[N-1][M-1]);
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Point(x,y));

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for(int i=0;i<4;i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && miro[nx][ny] > 0) {
                    queue.add(new Point(nx,ny));
                    visited[nx][ny] = true;
                    miro[nx][ny] = miro[p.x][p.y] + 1;
                }
            }
        }

    }
}
