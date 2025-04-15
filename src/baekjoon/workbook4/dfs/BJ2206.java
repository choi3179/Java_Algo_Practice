package baekjoon.workbook4.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Loc {
    int x;
    int y;
    int cnt;
    boolean broke;

    Loc(int x, int y, int cnt, boolean broke) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.broke = broke;
    }

}

public class BJ2206 {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static int N;
    static int M;

    static int[][] miro;
    static boolean[][] visited;
    static boolean[][] visited_wall;    // 벽을 부수고 이동한 경우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N][M];
        visited = new boolean[N][M];
        visited_wall = new boolean[N][M];

        for(int i=0;i<N;i++) {
            String[] s = br.readLine().split("");
            for(int j=0;j<M;j++) {
                miro[i][j] = s[j].charAt(0) - '0';
            }
        }

        int ans = bfs(0,0);
        System.out.println(ans);
    }

    public static int bfs(int x, int y) {
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(x,y,1,false));      // 처음에는 벽을 깬 적이 없음.

        while(!q.isEmpty()) {
            Loc l = q.poll();

            if(l.x == N-1 && l.y == M-1) return l.cnt;

            for(int j=0;j<4;j++){
                int nx = l.x + dx[j];
                int ny = l.y + dy[j];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(miro[nx][ny] == 1 && !l.broke && !visited_wall[nx][ny]) {         // 벽이면서 이 경로까지 벽을 부순적이 없을 경우 -> 벽을 부수고 이동
                        visited_wall[nx][ny] = true;
                        Loc nl = new Loc(nx,ny,l.cnt+1, true);
                        q.add(nl);
                    } else if(miro[nx][ny] == 0 && !l.broke && !visited[nx][ny]) {      // 길이면서 벽을 깨고 온 적이 없는 경우 -> 그대로 이동
                        visited[nx][ny] = true;
                        Loc nl = new Loc(nx,ny,l.cnt+1, false);
                        q.add(nl);
                    } else if(miro[nx][ny] == 0 && l.broke && !visited_wall[nx][ny]) {  // 길이면서 벽을 깨고 온 적이 있는 경우 -> 그대로 이동
                        visited_wall[nx][ny] = true;
                        Loc nl = new Loc(nx,ny, l.cnt+1, true);
                        q.add(nl);
                    }
                }
            }

        }
        return -1;
    }

}
