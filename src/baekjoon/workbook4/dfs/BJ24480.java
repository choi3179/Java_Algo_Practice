package baekjoon.workbook4.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ24480 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] result;
    static int seq = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        result = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<Integer>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++)
            graph[i].sort(Collections.reverseOrder());

        recursion(R);

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void recursion(int n) {
        visited[n] = true;
        result[n] = ++seq;
        for(int i=0;i<graph[n].size();i++) {
            if(!visited[graph[n].get(i)]) {
                recursion(graph[n].get(i));
            }
        }
        return;
    }
}
