package baekjoon.workbook3.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10830 {

    static int[][] matrix;
    static int A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long B;

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        matrix = new int[A][A];

        for(int i=0;i<A;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<A;j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] result = multi(matrix,B);

        for(int i=0;i<A;i++) {
            for(int j=0;j<A;j++) {
                System.out.print((result[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multi(int[][] matrix, long exp) {
        if(exp == 1L)
            return matrix;

        // 지수 분할 - 정복
        int[][] tmp = multi(matrix, exp/2);

        int[][] result = calc(tmp,tmp);

        if(exp % 2 == 1L)
            result = calc(result, matrix);

        return result;

    }

    public static int[][] calc(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[A][A];

        for(int i=0;i<A;i++) {
            for(int j=0;j<A;j++) {
                int tmp = 0;
                for(int k=0;k<A;k++) {
                    tmp += (matrix1[i][k] * matrix2[k][j]);
                }
                result[i][j] = tmp % 1000;
            }
        }
        return result;
    }
}
