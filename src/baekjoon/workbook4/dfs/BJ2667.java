package baekjoon.workbook4.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2667 {

    static int[][] apart;
    static boolean[][] visited;
    static int N;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> answer = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        apart = new int[N][N];
        visited = new boolean[N][N];


        for(int i=0;i<N;i++) {
            String[] st = br.readLine().split("");
            for(int j=0;j<N;j++)
                apart[i][j] = Integer.parseInt(st[j]);
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!visited[i][j] && apart[i][j] == 1) {
                    danzi(i,j);
                    answer.add(cnt);
                    cnt = 0;
                }
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for(int i=0;i<answer.size();i++)
            sb.append(answer.get(i)).append("\n");

        System.out.println(sb);
    }

    public static void danzi(int x, int y) {
        visited[x][y] = true;
        cnt++;
        if(x-1 >= 0 && !visited[x-1][y] && apart[x-1][y] == 1) {
            danzi(x-1,y);
        }
        if(y-1 >= 0 && !visited[x][y-1] && apart[x][y-1] == 1) {
            danzi(x,y-1);
        }
        if(x+1 < N && !visited[x+1][y] && apart[x+1][y] == 1) {
            danzi(x+1,y);
        }
        if(y+1 < N && !visited[x][y+1] && apart[x][y+1] == 1) {
            danzi(x,y+1);
        }
    }
}
