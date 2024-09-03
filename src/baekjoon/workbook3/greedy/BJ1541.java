package baekjoon.workbook3.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1541 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] greedy = input.split("-");

        StringTokenizer st;
        String[] temp;
        int min = 0;
        for(int i=0;i<greedy.length;i++) {
            temp = greedy[i].split("\\+");
            int sum = 0;
            for(int j=0;j<temp.length;j++) {
                sum += Integer.parseInt(temp[j]);
            }
            if(i==0)
                min += sum;
            else
                min -= sum;
        }
        System.out.println(min);
    }
}
