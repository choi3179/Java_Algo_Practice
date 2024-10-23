package baekjoon.workbook3.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 대표적인 LIS(Longest Increment Sequence) 문제
 * 수열의 길이가 굉장히 길 경우 -> "이분탐색(Binary-Search)"을 이용하여 풀이 가능
 */
public class BJ12015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        ArrayList<Integer> subArray = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());

        subArray.add(0,A[0]);

        for(int i=1;i<N;i++) {
            int val = A[i];

            if(val > subArray.get(subArray.size() - 1))
                subArray.add(val);
            else{   // 이분 탐색 진행
                int left = 0;
                int right = subArray.size()-1;
                int mid = 0;

                while(left < right) {
                    mid = (left + right) / 2;
                    if(subArray.get(mid) >= val)
                        right = mid;
                    else
                        left = mid + 1;
                }
                subArray.set(right, val);
            }
        }

        System.out.println(subArray.size());
    }
}
