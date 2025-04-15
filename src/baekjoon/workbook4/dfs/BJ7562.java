package baekjoon.workbook4.dfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7562 {

    static int[] dx = {-2,-2,-1,-1,1,1,2,2};
    static int[] dy = {-1,1,-2,2,-2,2,-1,1};

    static boolean[][] visited;
    static int[][] board;

    static Point start;
    static Point dest;

    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++) {
            L = Integer.parseInt(br.readLine());
            board = new int[L][L];
            visited = new boolean[L][L];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            dest = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            System.out.println(bfs());
        }
    }

    public static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;

        while(!q.isEmpty()) {

            for(int i=0;i<q.size();i++) {
                Point p = q.poll();
                for(int j=0;j<8;j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if(nx >= 0 && ny >= 0 && nx < L && ny < L && !visited[nx][ny]) {
                        q.add(new Point(nx,ny));
                        visited[nx][ny] = true;
                        board[nx][ny] = board[p.x][p.y] + 1;
                        if(nx == dest.x && ny == dest.y) {
                            return board[nx][ny];
                        }
                    }
                }
            }
        }
        return 0;
    }
}

