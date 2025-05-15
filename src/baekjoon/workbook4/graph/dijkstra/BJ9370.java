package baekjoon.workbook4.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ9370 {

    static class Point {
        int next;
        int distance;

        Point(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }
    }

    static ArrayList<Point>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());       // 교차로 개수
            int m = Integer.parseInt(st.nextToken());       // 도로 개수
            int t = Integer.parseInt(st.nextToken());       // 목적지 후보 개수

            graph = new ArrayList[n+1];
            for(int j=0;j<=n;j++)
                graph[j] = new ArrayList<Point>();

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());       // 시작점
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for(int j=0;j<m;j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[a].add(new Point(b,d));
                graph[b].add(new Point(a,d));
            }

            int[] destination = new int[t];
            Queue<Integer> answer = new LinkedList<>();
            for(int j=0;j<t;j++) {
                destination[j] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(destination);

            for(int j=0;j<destination.length;j++) {
                int e = destination[j];
                int case1 = dijkstra(s,g) + dijkstra(g,h) + dijkstra(h,e);      // s-g-h-e
                int case2 = dijkstra(s,h) + dijkstra(h,g) + dijkstra(g,e);      // s-h-g-e
                int case3 = dijkstra(s,e);                                      // 전체 최소 경로

                if(Math.min(case1,case2) == case3)
                    answer.add(e);
            }

            while(!answer.isEmpty()) {
                sb.append(answer.poll()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int dijkstra(int start, int end) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        boolean[] visited = new boolean[graph.length];

        PriorityQueue<Point> pq = new PriorityQueue<>((o1,o2) -> {
           return o1.distance - o2.distance;
        });
        pq.add(new Point(start,0));
        visited[start] = true;
        dist[start] = 0;

        while(!pq.isEmpty()) {

            for(int i=0;i<pq.size();i++) {
                Point p = pq.poll();

                for(int j=0;j<graph[p.next].size();j++) {

                    Point np = graph[p.next].get(j);

                    if(p.distance + np.distance < dist[np.next]) {
                        dist[np.next] = p.distance + np.distance;
                        pq.add(new Point(np.next, dist[np.next]));
                    }
                }
            }

        }

        return dist[end];
    }
}
