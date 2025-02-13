package baekjoon.workbook4.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1260 {

    static boolean[] DFS_visited;
    static boolean[] BFS_visited;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        DFS_visited = new boolean[N+1];
        BFS_visited = new boolean[N+1];
        graph = new ArrayList[N+1];
        sb = new StringBuilder();
        for(int i=1;i<=N;i++)
            graph[i] = new ArrayList<>();

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=1;i<graph.length;i++)
            Collections.sort(graph[i]);

        dfs(V);
        sb.append("\n");
        bfs(V);

        System.out.println(sb);

    }

    public static void dfs(int n) {
        DFS_visited[n] = true;
        sb.append(n).append(" ");
        for(int i=0;i<graph[n].size();i++) {
            int p = graph[n].get(i);
            if(!DFS_visited[p]) {
                dfs(p);
            }
        }
    }

    public static void bfs(int n) {
        BFS_visited[n] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        sb.append(n).append(" ");
        while(!q.isEmpty()) {
            int p = q.poll();
            for(int i=0;i<graph[p].size();i++) {
                int t = graph[p].get(i);
                if(!BFS_visited[t]) {
                    BFS_visited[t] = true;
                    q.add(t);
                    sb.append(t).append(" ");
                }
            }
        }
    }
}
