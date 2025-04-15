package baekjoon.workbook4.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16928 {

    public static int[] dice = {1,2,3,4,5,6};

    public static int[] board = new int[101];

    public static int[] visited = new int[101];

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        for(int j=0;j<M;j++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board[u] = v;
        }

        bfs();
        System.out.println(visited[100]);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()) {
            for(int j=0;j<q.size();j++) {
                int p = q.poll();
                for(int i=0;i<6;i++) {
                    int np = p + dice[i];

                    if(np <= 100) {
                        if(board[np] != 0) {
                            np = board[np];
                        }
                        if(visited[np] != 0)    continue;

                        visited[np] = visited[p] + 1;

                        if(np == 100) return;

                        q.add(np);
                    }
                }
            }
        }
    }
}
