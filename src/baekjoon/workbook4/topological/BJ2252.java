package baekjoon.workbook4.topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 위상정렬 문제
 * 줄 세우기 -> 선후 관계가 있는 그래프 정렬
 */
public class BJ2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inDegree = new int[N+1];    // 진입차수 배열
        ArrayList<Integer>[] graph = new ArrayList[N+1];

        for(int i=0;i<N+1;i++)
            graph[i] = new ArrayList<>();

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            inDegree[B]++;      // 진입차수 증가
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++) {
            if(inDegree[i] == 0)
                q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for(int i=0;i<graph[cur].size();i++) {
                int next = graph[cur].get(i);
                inDegree[next]--;
                if(inDegree[next] == 0)
                    q.add(next);
            }
        }
        System.out.println(sb);
    }
}

