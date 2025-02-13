package baekjoon.workbook4.dfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class BJ7576 {

    static Queue<Point> q = new LinkedList<>();
    static int[][] box;
    static int[][] visited;     // 방문여부 & 도달시간

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static int M;
    static int N;

    static int cnt = 0;     // 안 익은 토마토가 있는 칸
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        visited = new int[N][M];

        for(int i=0;i<N;i++) {
            Arrays.fill(visited[i], -1);    // 방문여부에 시간 정보도 담기 위해 -1로 모두 초기화
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) {
                    q.add(new Point(i,j));
                    visited[i][j] = 0;
                }
                if(box[i][j] == 0) cnt++;
            }
        }

        bfs();

        if(cnt != 0)    time = -1;
        System.out.println(time);
    }

    public static void bfs() {

        while(!q.isEmpty()) {
            for(int i=0;i<q.size();i++) {
                Point p = q.poll();

                for(int n=0;n<4;n++) {
                    int nx = p.x + dx[n];
                    int ny = p.y + dy[n];

                    if(nx >= 0 && ny >=0 && nx < N && ny < M && visited[nx][ny] == -1 && box[nx][ny] == 0) {
                        Point pt = new Point(nx,ny);
                        q.add(pt);
                        visited[nx][ny] = visited[p.x][p.y] + 1;
                        cnt--;
                        if(time < visited[nx][ny])  time = visited[nx][ny];
                    }
                }
            }
        }
    }
}
