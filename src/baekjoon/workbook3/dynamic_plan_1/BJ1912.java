package baekjoon.workbook3.dynamic_plan_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1912 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        max = array[0];
        dp[0] = array[0];

        for(int i=1;i<N;i++) {
            dp[i] = Math.max(array[i] + dp[i-1], array[i]);

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
