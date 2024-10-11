package baekjoon.workbook3.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);     // 이진 탐색은 정렬 우선

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            sb.append(search(A,Integer.parseInt(st.nextToken()))).append(" ");
        }

        System.out.println(sb);
    }

    public static int search(int[] A, int num) {

        int left = 0;
        int right = A.length-1;
        int mid = 0;

        while(left <= right) {
            mid = (left + right) / 2;
            if(num == A[mid])
                return 1;
            else if(num > A[mid])
                left = mid+1;
            else
                right = mid-1;
        }

        return 0;
    }
}
