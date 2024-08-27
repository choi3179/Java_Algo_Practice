package baekjoon.workbook3.dynamic_plan_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1904 {

    static long[] memory = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        memory[0] = 0;
        memory[1] = 1;
        memory[2] = 1;
        memory[3] = 1;
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];

        for(int i=0;i<N;i++){
            P[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<N;i++){
            System.out.println(wave(P[i]));
        }

    }

    public static long wave(int num) {
        if(num == 1 || num == 2 || num == 3) return memory[num];

        if(memory[num] == 0) {
            memory[num] = wave(num-3) + wave(num-2);
        }
        return memory[num];
    }
}
