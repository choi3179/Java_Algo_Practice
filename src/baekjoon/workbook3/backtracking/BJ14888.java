package baekjoon.workbook3.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14888 {

    static int N;
    static int[] A;
    static int[] operation = new int[4];

    static long max = -1000000000;
    static long min = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(A[0], 0);

        System.out.println(max);
        System.out.println(min);

    }

    public static void backtracking(int result, int cnt) {
        if(cnt == N-1) {
            if(result > max) max = result;
            if(result < min) min = result;
            return;
        }

        for(int i=0;i<4;i++) {
            if(operation[i] > 0) {
                operation[i]--;

                switch(i) {
                    case 0:
                        backtracking(result + A[cnt+1], cnt+1);
                        break;
                    case 1:
                        backtracking(result - A[cnt+1], cnt+1);
                        break;
                    case 2:
                        backtracking(result * A[cnt+1], cnt+1);
                        break;
                    case 3:
                        backtracking(result / A[cnt+1], cnt+1);
                        break;
                }

                operation[i]++;
            }
        }
    }
}
