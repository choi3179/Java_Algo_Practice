package baekjoon.workbook4.dynamic_plan2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int prg = 0;prg<T;prg++) {
            int K = Integer.parseInt(br.readLine());
            int[] files = new int[K+1];
            int[] sum = new int[K+1];   // file크기의 합 저장 배열 -> 1~i 까지의 합
            int[][] dp = new int[K+1][K+1];     // dp[i][j] ==> i~j까지 합의 최솟값을 저장

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=K;i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1] + files[i];
            }

            // 루프를 돌면서 dp[i][j]의 최솟값을 dp[i][j]에 저장
            // 점화식 : dp[i][j] = Math.min(dp[i][j], dp[i][x]+dp[x+1][j]+sum[j]-sum[i-1]
            for(int i=1;i<=K;i++) {

                for(int j=1;i+j<=K;j++) {
                    int k = j+i;
                    dp[j][k] = Integer.MAX_VALUE;
                    for(int x=j;x<k;x++) {
                        dp[j][k] = Math.min(dp[j][k], dp[j][x] + dp[x+1][k] + sum[k] - sum[j-1]);
                    }
                }
            }

            System.out.println(dp[1][K]);
        }
    }
}
