package baekjoon.workbook3.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1780 {

    static int[][] array;
    static int a;
    static int b;
    static int c;
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

        divide(0,0,N);

        StringBuilder sb = new StringBuilder();
        sb.append(a).append("\n").append(b).append("\n").append(c);
        System.out.println(sb);
    }

    public static void divide(int startX, int startY, int size) {

        int result = check(startX, startY, size);
        if(result == -1) {
            a++;
        } else if(result == 0) {
            b++;
        } else if(result == 1) {
            c++;
        } else{
            size = size / 3;

            divide(startX, startY, size);
            divide(startX + size, startY, size);
            divide(startX + size*2, startY, size);

            divide(startX, startY + size, size);
            divide(startX + size, startY + size, size);
            divide(startX + size*2, startY + size, size);

            divide(startX, startY + size*2, size);
            divide(startX + size, startY + size*2, size);
            divide(startX + size*2, startY + size*2, size);
        }


    }

    public static int check(int startX, int startY, int size) {

        for(int i=startY;i<startY+size;i++) {
            for(int j=startX;j<startX+size;j++) {
                if(array[startY][startX] != array[i][j])
                    return -999;
            }
        }

        return array[startY][startX];
    }
}
