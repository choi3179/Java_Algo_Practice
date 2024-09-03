package baekjoon.workbook3.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][2];

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        // 빨리 끝나는 순서대로 정렬
        Arrays.sort(array, (a,b) -> {
            if(a[1] == b[1])
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });

        int cnt = 0;
        int start = 0;
        int end = 0;
        for(int i=0;i<N;i++) {

            if(end <= array[i][0]) {
                cnt++;
                start = array[i][0];
                end = array[i][1];
            }
        }

        System.out.println(cnt);
    }
}
