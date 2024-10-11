package baekjoon.workbook3.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * F(n) = F(n-1) + F(n-2)
 *          | 1  1 |      | F(n-1) |        | 1 1 | ^n      | 1 |
 * F(n) =   |      |  *   |        |    =   |     |    *    |   |
 *          | 1  0 |      | F(n-2) |        | 1 0 |         | 1 |
 *
 */
public class BJ11444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int exp = Integer.parseInt(br.readLine());

        int[][] matrix = {{1,1},{1,0}};
    }

//    public static int[][] fibo(int exp) {
//
//    }
}
