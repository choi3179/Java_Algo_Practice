package baekjoon.workbook4.dfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

class Dimension {
    int x;
    int y;
    int z;

    public Dimension(int x, int y, int z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }
}

public class BJ7569 {

    static Queue<Dimension> q = new LinkedList<>();
    static int[][][] box;
    static int[][][] visited;     // 방문여부 & 도달시간

    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};

    static int M;
    static int N;
    static int H;

    static int cnt = 0;     // 안 익은 토마토가 있는 칸
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        visited = new int[H][N][M];


        for(int i=0;i<H;i++) {
            for(int j=0;j<N;j++) {
                Arrays.fill(visited[i][j], -1);    // 방문여부에 시간 정보도 담기 위해 -1로 모두 초기화
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1) {
                        q.add(new Dimension(i,j,k));
                        visited[i][j][k] = 0;
                    }
                    if(box[i][j][k] == 0) cnt++;
                }
            }
        }

        bfs();

        if(cnt != 0)    time = -1;
        System.out.println(time);
    }

    public static void bfs() {

        while(!q.isEmpty()) {
            for(int i=0;i<q.size();i++) {
                Dimension d = q.poll();

                for(int n=0;n<6;n++) {
                    int nx = d.x + dx[n];
                    int ny = d.y + dy[n];
                    int nz = d.z + dz[n];

                    if(nx >= 0 && ny >=0 && nz >= 0 && nx < H && ny < N && nz < M && visited[nx][ny][nz] == -1 && box[nx][ny][nz] == 0) {
                        Dimension dd = new Dimension(nx,ny,nz);
                        q.add(dd);
                        visited[nx][ny][nz] = visited[d.x][d.y][d.z] + 1;
                        cnt--;
                        if(time < visited[nx][ny][nz])  time = visited[nx][ny][nz];
                    }
                }
            }
        }
    }
}
