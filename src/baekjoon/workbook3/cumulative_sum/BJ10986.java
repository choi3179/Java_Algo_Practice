package baekjoon.workbook3.cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N+1];   // 누적 합 배열
        int[] div = new int[M];     // 나머지 체크
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i=0;i<N;i++){
            sum = (sum + Integer.parseInt(st.nextToken())) % M;
            div[sum]++;
        }

        // S[i] % M == S[j] % M
        long cnt = 0;
        for(int i=0;i<M;i++) {
            cnt += (long) div[i] * (div[i]-1) / 2;
        }

        System.out.println(cnt + div[0]);
    }
}

