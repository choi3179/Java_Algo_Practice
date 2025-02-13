package baekjoon.workbook4.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1697 {


    static int MAX = 100001;

    static int N;
    static int K;
    static int[] road = new int[MAX];

    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N != K)
            bfs(N);

        System.out.println(road[K]);
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);

        while(road[K] == 0 && !queue.isEmpty()) {
            cnt+=1;

            int size = queue.size();
            for(int i=0;i<size;i++) {
                int tmp = queue.poll();
                if(tmp+1 < MAX && road[tmp+1] == 0) {
                    road[tmp+1] = cnt;
                    queue.add(tmp+1);
                }
                if( tmp-1 >= 0 && road[tmp-1] == 0) {
                    road[tmp-1] = cnt;
                    queue.add(tmp-1);
                }
                if(tmp*2 < MAX && road[tmp*2] == 0) {
                    road[tmp*2] = cnt;
                    queue.add(tmp*2);
                }
            }
        }
    }
}
