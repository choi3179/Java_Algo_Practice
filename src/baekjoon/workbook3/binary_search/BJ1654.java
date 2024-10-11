package baekjoon.workbook3.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1654 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max = 0;    // 가지고 있는 랜선 최대길이
        int[] LAN = new int[N];
        for(int i=0;i<N;i++) {
            LAN[i] = Integer.parseInt(br.readLine());
            if(LAN[i] > max)
                max = LAN[i];
        }

        long left = 0;
        long right = max;
        long mid = 0;
        long n = 0;  // 랜선 갯수

        right++;
        while(left < right) {
            n=0;
            mid = (left+right) / 2;

            for(int i=0;i<N;i++) {
                n += (LAN[i] / mid);
            }

            if(n < K)
                right = mid;
            else
                left = mid+1;
        }

        System.out.println(left-1);
    }
}
