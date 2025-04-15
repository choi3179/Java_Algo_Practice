package baekjoon.workbook4.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1707 {

    static int V,E;

    static ArrayList<ArrayList<Integer>> graph;
    static int[] color;
    static String answer = "YES";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            graph = new ArrayList<>();

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            color = new int[V+1];
            answer = "YES";

            for(int j=0;j<=V;j++)
                graph.add(new ArrayList<>());   // 간선 정보 초기화

            for(int k=0;k<E;k++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            for(int n=1;n<=V;n++) {
                if(color[n] == 0) {   // 아직 체크하지 않은 정점일 경우
                    bfs(n);
                }
            }
            System.out.println(answer);
        }
    }

    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        color[n] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i=0;i<graph.get(cur).size();i++) {
                int next = graph.get(cur).get(i);

                if(color[cur] == color[next]) {   // 연결된 두 정점이 이미 색이 같을 경우
                    answer = "NO";
                    return;
                }

                if(color[next] == 0) {
                    q.add(next);
                    color[next] = color[cur] * -1;
                }
            }
        }
    }
}
