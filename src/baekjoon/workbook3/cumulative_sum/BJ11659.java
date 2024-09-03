package baekjoon.workbook3.sumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 0;
        int M = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 누적 합 배열
        int[] sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            sum[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + sum[i];
        }

        int cum = 0;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cum = sum[b] - sum[a-1];

            sb.append(cum).append("\n");
        }

        System.out.println(sb);
    }
}
