package baekjoon.workbook4.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1504 {

    static int V,E;
    static ArrayList<Node>[] graph;

    static class Node{
        int next;
        int distance;

        Node(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];

        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int answer1 = 0;
        int answer2 = 0;

        answer1 = sum(dijkstra(1, v1), dijkstra(v1,v2), dijkstra(v2,V));
        answer2 = sum(dijkstra(1, v2), dijkstra(v2,v1), dijkstra(v1,V));

        int answer = answer1 == Integer.MAX_VALUE && answer2 == Integer.MAX_VALUE ? -1 : Math.min(answer1,answer2);

        System.out.println(answer);
    }

    static int dijkstra(int start, int end) {

        if(start == end)
            return 0;

        boolean[] visited = new boolean[V+1];
        int[] result = new int[V+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
           return o1.distance - o2.distance;
        });

        result[start] = 0;
        pq.add(new Node(start,0));
        visited[start] = true;

        Arrays.fill(result, Integer.MAX_VALUE);

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.next] = true;

            for(int i=0;i<graph[node.next].size();i++) {
                Node dest = graph[node.next].get(i);
                if(!visited[dest.next] && node.distance + dest.distance < result[dest.next]) {
                    result[dest.next] = node.distance + dest.distance;
                    pq.add(new Node(dest.next, result[dest.next]));
                }
            }
        }


        return result[end] == Integer.MAX_VALUE ? -1 : result[end];
    }

    static int sum(int a, int b, int c) {
        if(a < 0 || b < 0 || c < 0)
            return Integer.MAX_VALUE;
        else
            return a+b+c;
    }
}
