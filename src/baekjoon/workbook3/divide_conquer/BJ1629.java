package baekjoon.workbook3.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 모듈러 성질
 * (A * B) % C = (A % C * B % C) % C
 */
public class BJ1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long a,b,c;
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(modular(a,b,c));
    }

    public static long modular(long a, long b, long c) {
        if(b==1) {
            return a % c;
        }

        Long half = modular(a, b/2, c);

        // 지수가 홀수일 경우
        // A^11 = A^5 * A^5 * A
        if(b % 2 == 1) {
            return (half * half % c) * a % c;
        }
        return (half * half % c);
    }
}
