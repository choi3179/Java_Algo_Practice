package baekjoon.workbook3.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630 {

    static int[][] array;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        array = new int[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,N,N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int startX, int startY, int endX, int endY) {
        int result = check(startX, startY, endX, endY);
        if(result == 1)
            blue++;
        else if(result == 0)
            white++;
        else {
            int midX = (startX + endX) / 2;
            int midY = (startY + endY) / 2 ;
            divide(startX, startY, midX, midY);     // 2사분면
            divide(midX, startY, endX, midY);       // 1사분면
            divide(startX, midY, midX, endY);     // 3사분면
            divide(midX, midY, endX, endY);     // 4사분면
        }
    }

    public static int check(int startX, int startY, int endX, int endY) {

        for(int i=startX;i<endX;i++) {
            for(int j=startY;j<endY;j++) {
                if(array[startX][startY] != array[i][j]){
                    return -1;
                }
            }
        }

        return array[startX][startY];
    }
}


