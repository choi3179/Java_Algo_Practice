package baekjoon.workbook3.dynamic_plan_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];

        for(int i=0;i<N;i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽에서 시작하는 연속 수열 체크
        int[] dpL = new int[N];
        dpL[0] = 1;
        for(int i=1;i<N;i++) {
            dpL[i] = 1;
            for(int j=0;j<i;j++) {
                if(array[i] > array[j]) {
                    dpL[i] = Math.max(dpL[j]+1, dpL[i]);
                }
            }
        }

        // 오른쪽에서 시작하는 연속 수열 체크
        int[] dpR = new int[N];
        dpR[N-1] = 1;
        for(int i=N-2;i>0;i--) {
            dpR[i] = 1;
            for(int j=N-1;j>i;j--) {
                if(array[i] > array[j]) {
                    dpR[i] = Math.max(dpR[j]+1, dpR[i]);
                }
            }
        }

        int max = 0;
        for(int i=0;i<N;i++) {
            max = Math.max(max, dpL[i] + dpR[i]);
        }
        System.out.println(max);
    }
}
