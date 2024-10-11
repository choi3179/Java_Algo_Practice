package baekjoon.workbook3.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 최소 거리에 집중한다.
 * ==> 이분 탐색으로 최소 거리 탐색
 */
public class BJ2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] X = new int[N];
        for(int i=0;i<X.length;i++) {
            X[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(X);     // 좌표 정렬

        int left = 1;
        int right = X[N-1];
        int mid = 0;
        int cnt = 0;    // 공유기 개수 카운트
        int position = 0;   // 마지막 공유기 설치 위치 인덱스

        while(left <= right) {
            cnt = 1;
            mid = (left+right) / 2;
            position = 0;

            for(int i=1;i<N;i++) {
                if(X[i] - X[position] >= mid) {
                    cnt++;
                    position = i;
                }
            }

            if(cnt < C)
                right = mid-1;
            else{
                left = mid +1;
            }
        }

        System.out.println(left-1);
    }
}
