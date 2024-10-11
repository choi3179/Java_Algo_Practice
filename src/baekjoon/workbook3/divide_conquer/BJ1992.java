package baekjoon.workbook3.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1992 {

    static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        array = new int[N][N];

        String[] split;
        for(int i=0;i<N;i++) {
            split = br.readLine().split("");
            for(int j=0;j<split.length;j++) {
                array[i][j] = Integer.parseInt(split[j]);
            }
        }

        divide(0,0,N,N);
    }

    public static void divide(int startX, int startY, int endX, int endY) {

        int result = check(startX, startY, endX, endY);
        if(result != -1) {
            System.out.print(result);
        } else{
            int midX = (startX + endX) / 2;
            int midY = (startY + endY) / 2;
            System.out.print("(");
            divide(startX, startY, midX, midY);     // 2사분면
            divide(midX, startY, endX, midY);       // 1사분면
            divide(startX, midY, midX, endY);     // 3사분면
            divide(midX, midY, endX, endY);     // 4사분면
            System.out.print(")");
        }


    }

    public static int check(int startX, int startY, int endX, int endY) {

        for(int i=startY;i<endY;i++) {
            for(int j=startX;j<endX;j++) {
                if(array[startY][startX] != array[i][j]){
                    return -1;
                }
            }
        }

        //System.out.println("(" + startX + " , " + startY + ")  ~  (" + endX + " , " + endY + ") >> " + array[startX][startY]);
        return array[startY][startX];
    }
}
