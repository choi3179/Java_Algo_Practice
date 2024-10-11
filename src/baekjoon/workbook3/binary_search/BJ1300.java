package baekjoon.workbook3.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N x N 배열을 구구단이라고 생각해보자!
 * 각 행이 '단'(i)을 의미하고 특정 값(num) 미만의 개수를 구하려면 'num/i' + 1단일 경우를 고려해 주여아함
 *  행의 원소의 개수가 N(열 개수)를 초과하지 않은 선에서 합해주어야 함 ==> LowerBound
 */
public class BJ1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int left = 1;
        int right = K;      // 어차피 K번째를 찾는거니까 K를 max로 이진탐색해도 되지 않을까?
        int mid = 0;

        int cnt=0; // mid가 몇번째 수인지??
        while(left < right) {
            mid = (left + right) / 2;
            cnt = 0;

            for(int i=1;i<=N;i++) {
                cnt += Math.min(mid/i, N);  // mid의 값이 열 개수보다 많은 경우 추가 덧셈이 생길 수 있으므로
            }

            if(cnt < K)
                left = mid + 1;
            else
                right = mid;
        }
        System.out.println(left);
    }
}
