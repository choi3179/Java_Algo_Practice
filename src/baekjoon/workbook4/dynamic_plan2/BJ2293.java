package baekjoon.workbook4.dynamic_plan2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        int[] cases = new int[k+1];

        for(int i=0;i<n;i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        cases[0] = 1;   // 첫 경우를 만들 수 있는 경우 미리 저장
        for(int i=0;i<n;i++) {
            for(int j=1;j<=k;j++) {
                if(j >= coins[i])
                    cases[j] += cases[j-coins[i]];
            }
        }

        System.out.println(cases[k]);
    }
}
