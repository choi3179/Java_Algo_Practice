package baekjoon.workbook4.dynamic_plan2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][2];
        int[][] dp = new int[N+1][N+1];

        StringTokenizer st;
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        /**
         * range : 곱하는 행렬 범위(크기)
         * i : 시작점
         * j : 끝점
         * k : 중간점
         */
        for(int range=1;range<N;range++) {
            for(int i=1;i+range<=N;i++) {
                int j = i + range;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k=i;k<j;k++)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + (arr[i][0] * arr[k][1] * arr[j][1]));
            }
        }

        System.out.println(dp[1][N]);
    }
}
