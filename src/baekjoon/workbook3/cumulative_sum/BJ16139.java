package baekjoon.workbook3.cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] alpha = new int[S.length()+1][26];  // 문자열의 알파벳 합 배열
        int idx = 0;    // 현재 문자 위치의 알파벳 인덱스

        StringTokenizer st;

        for(int i=1;i<=S.length();i++) {
            idx = S.charAt(i-1) - 'a';
            for(int j=0;j<26;j++) {
                if(idx == j)    alpha[i][j]++;
                alpha[i][j] = alpha[i-1][j] + alpha[i][j];
            }
        }

        //System.out.println(Arrays.toString(alpha[S.length()]));

        StringBuilder sb = new StringBuilder();
        int a,l,r;
        for(int i=0;i<q;i++) {
            st = new StringTokenizer(br.readLine());
            a = st.nextToken().charAt(0) - 'a';
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            sb.append(alpha[r+1][a] - alpha[l][a]).append("\n");
        }

        System.out.println(sb);
    }
}
