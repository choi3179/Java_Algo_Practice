package baekjoon.workbook3.dynamic_plan_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * LIS 알고리즘
 * 가장 긴 증가하는 부분 수열
 */
public class BJ11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;
        for(int i=1;i<N;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(array[j] < array[i]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }

        int max = 0;
        for(int i=0;i<N;i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
