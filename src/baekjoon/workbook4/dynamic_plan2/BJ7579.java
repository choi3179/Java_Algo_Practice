package baekjoon.workbook4.dynamic_plan2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ7579 {

    static int N;
    static int M;
    static int[] apps;
    static int[] costs;
    static int[][] dp;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        apps = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            apps[i] = Integer.parseInt(st.nextToken());

        costs = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            costs[i] = Integer.parseInt(st.nextToken());

        dp = new int[N][10001];     // 전체 costs의 경우의 수를 앱의 개수만큼 체크
                                    // i 번째의 앱까지에 대하여 비용 j로 확보 가능한 최대 메모리
                                    // dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-costs[i]] + apps[i]);

        for(int i=0;i<N;i++) {
            int cost = costs[i];
            int app = apps[i];

            for(int j=0;j<10001;j++) {
                if(i==0) {
                    if(j>=cost)
                        dp[i][j] = app;
                }
                else{
                    if(j < cost)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-costs[i]] + apps[i]);
                }
            }
        }

        for(int i=0;i<10001;i++) {
            if(dp[N-1][i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}
