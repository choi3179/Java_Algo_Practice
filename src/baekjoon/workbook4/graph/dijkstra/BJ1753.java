package baekjoon.workbook4.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753 {
    static int V,E,K;

    static class Node {
        int next;
        int weight;

        Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[V+1];
        int[] result = new int[V+1];        // 1번 정점에서 각 점까지의 최소 가중치 저장
        boolean[] visited = new boolean[V+1];

        for(int i=0;i< visited.length;i++) {
            graph[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Node node = new Node(v,w);
            graph[u].add(node);
        }

        // 가중치가 더 적은 노드에 대해 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
           return (o1.weight - o2.weight);
        });
        result[K] = 0;
        pq.add(new Node(K,0));

        while(!pq.isEmpty()) {
            for(int i=0;i<pq.size();i++) {
                Node node = pq.poll();
                if(!visited[node.next])
                    visited[node.next] = true;

                for(int j=0;j<graph[node.next].size();j++) {
                    Node dest = graph[node.next].get(j);

                    if(!visited[dest.next] && node.weight + dest.weight < result[dest.next]) {
                        result[dest.next] = node.weight + dest.weight;
                        pq.add(new Node(dest.next, result[dest.next]));
                    }
                }
            }
        }

        for(int i=1;i<result.length;i++) {
            if(result[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(result[i]);
        }
    }
}
