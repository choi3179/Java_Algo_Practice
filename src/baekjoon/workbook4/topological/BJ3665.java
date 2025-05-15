package baekjoon.workbook4.topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ3665 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0;i<C;i++) {
            int N = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] graph = new ArrayList[N+1];
            int[] inDegree = new int[N+1];

            for(int j=0;j<N+1;j++)
                graph[j] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            // 1. 순위 저장
            int[] rank = new int[N+1];
            for(int j=1;j<=N;j++) {
                int n = Integer.parseInt(st.nextToken());
                rank[j] = n;
            }

            // 2. 위상 그래프
            for(int j=1;j<=N;j++) {
                for(int k=1;k<j;k++) {
                    graph[rank[j]].add(rank[k]);
                }
                inDegree[rank[j]] = graph[rank[j]].size();
            }

            // 3. 위상 조정
            int m = Integer.parseInt(br.readLine());
            for(int j=0;j<m;j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 앞 숫자가 위상이 더 높을 경우
                if(graph[b].contains(a)) {
                    graph[a].add(b);
                    graph[b].remove(a);
                    inDegree[a]++;
                    inDegree[b]--;
                } else {
                    graph[b].add(a);
                    graph[a].remove(b);
                    inDegree[b]++;
                    inDegree[a]--;
                }
            }

            StringBuilder sb = new StringBuilder();
            // 4. 위상 정렬
            Queue<Integer> q = new LinkedList<>();
            q.add(rank[1]);
            int cnt = 0;
            while(!q.isEmpty()) {
                // 순위를 정할 수 없음
                if(q.size() > 1) {
                    sb.append("?");
                    break;
                }

                int x = q.poll();
                sb.append(x).append(" ");
                for(int j=1;j<=N;j++) {
                    inDegree[rank[j]]--;
                    if(inDegree[rank[j]] == 0)
                        q.add(rank[j]);
                }
            }

            if(cnt != N)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(sb);
        }



    }
}
