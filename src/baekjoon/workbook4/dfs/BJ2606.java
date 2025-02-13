package baekjoon.workbook4.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2606 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1;i<=N;i++)
            graph[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        recursion(1);
        System.out.println(result - 1);
    }

    static void recursion(int p) {
        visited[p] = true;
        result++;
        for(int i=0;i<graph[p].size();i++) {
            if(!visited[graph[p].get(i)]) {
                recursion(graph[p].get(i));
            }
        }
    }
}
