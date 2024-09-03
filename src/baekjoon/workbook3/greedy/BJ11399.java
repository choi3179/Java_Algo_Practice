package baekjoon.workbook3.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            array[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(array);

        int sum=0;
        int ans=0;
        for(int i=0;i<N;i++) {
            sum = sum + array[i];
            ans += sum;
        }

        System.out.println(ans);
    }
}
