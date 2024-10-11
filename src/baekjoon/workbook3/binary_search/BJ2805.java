package baekjoon.workbook3.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2805 {

    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] trees = new long[N];
        long max = 0;
        for(int i=0;i<N;i++) {
            trees[i]  = Integer.parseInt(st.nextToken());
            if(trees[i] > max)
                max = trees[i];
        }

        System.out.println(binary(trees,max));
    }

    public static long binary(long[] trees,long max) {
        long left = 0;
        long right = max;
        long mid = 0;
        long n=0; // 들고갈 통나무 길이

        while(left < right) {
            n=0;
            mid = (left + right) / 2;
            for(int i=0;i<trees.length;i++) {
                if((trees[i] - mid) > 0)
                    n += (trees[i] - mid);
            }

            if(n >= M) {
                left = mid+1;
            }
            else
                right = mid;
        }

        return left-1;
    }
}
