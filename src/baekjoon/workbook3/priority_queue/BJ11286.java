package baekjoon.workbook3.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2))
                    return 1;
                else if(Math.abs(o1) == Math.abs(o2))
                    return o1-o2;
                else
                    return -1;
            }
        });

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
