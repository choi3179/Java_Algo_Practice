package baekjoon.workbook3.dynamic_plan_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][3];
        int[][] cost = new int[N][3];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreElements()) {
                board[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        cost[0][0] = board[0][0];
        cost[0][1] = board[0][1];
        cost[0][2] = board[0][2];
        for(int i=1;i<N;i++) {
            cost[i][0] = Math.min(cost[i-1][1] + board[i][0], cost[i-1][2] + board[i][0]);
            cost[i][1] = Math.min(cost[i-1][0] + board[i][1], cost[i-1][2] + board[i][1]);
            cost[i][2] = Math.min(cost[i-1][0] + board[i][2], cost[i-1][1] + board[i][2]);
        }

        System.out.println(Math.min(cost[N-1][0], Math.min(cost[N-1][1], cost[N-1][2])));

    }
}
