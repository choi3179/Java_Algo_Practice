package baekjoon.workbook4.dynamic_plan2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2629 {

    static int n;           // 추의 개수
    static int[] choo;      // 각 추의 무개
    static boolean[][] dp;     // 추의 조합으로 확인할 수 있는  구슬 무게 가능 여부

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        choo = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            choo[i] = Integer.parseInt(st.nextToken());

        dp = new boolean[n+1][40001];        // 문제에서 구슬의 무게는 40000 이하로 선언.

        dfs(0,0);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            if(dp[n][Integer.parseInt(st.nextToken())])
                sb.append("Y ");
            else
                sb.append("N ");
        }

        System.out.println(sb);
    }

    public static void dfs(int idx, int weight) {
        if(weight < 0 || weight > 40000)
            return;
        if(dp[idx][weight])     // 이미 체크한 경우의 수라면 무시 -> 시간 초과 발생
            return;
        dp[idx][weight] = true;
        if(idx == n)
            return;


        dfs(idx+1, weight + choo[idx]);
        dfs(idx+1, weight);
        dfs(idx+1, Math.abs(weight - choo[idx]));

    }
}
