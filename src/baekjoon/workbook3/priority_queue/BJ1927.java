package baekjoon.workbook3.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int input = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if(minHeap.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(minHeap.poll()).append("\n");
            }
            else
                minHeap.add(input);
        }

        System.out.println(sb);
    }
}
