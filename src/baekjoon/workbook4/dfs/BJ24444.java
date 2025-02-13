package baekjoon.workbook4.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ24444 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] result;
    static int seq=0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        result = new int[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=1;i<=M;i++) {
            st= new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i=1;i<=N;i++)
            Collections.sort(graph[i]);

        sb = new StringBuilder();
        recursion(R);

        for(int i=1;i<=N;i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void recursion(int p) {
       Queue<Integer> q = new LinkedList<Integer>();
       visited[p] = true;
       q.add(p);
       result[p] = ++seq;
       while(!q.isEmpty()) {
            int u = q.poll();
            for(int i=0; i<graph[u].size();i++) {
                if(!visited[graph[u].get(i)]) {
                    visited[graph[u].get(i)] = true;
                    q.add(graph[u].get(i));
                    result[graph[u].get(i)] = ++seq;
                }
            }
       }
    }
}
