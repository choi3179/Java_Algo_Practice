package baekjoon.workbook4.graph.bellman_ford;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11657 {

    static int N;
    static int M;

    static class City {
        int from;
        int to;
        int weight;

        City(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] time = new int[N+1];
        Arrays.fill(time,Integer.MAX_VALUE);

        City[] cities = new City[M];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            cities[i] = new City(a,b,c);
        }

        time[1] = 0;
        boolean isCycle = false;    // 음수 사이클 존재 확인
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                City city = cities[j];
                if (time[city.from] != Integer.MAX_VALUE && time[city.to] > time[city.from] + city.weight) {
                    time[city.to] = time[city.from] + city.weight;
                    if(i==N-1) {
                        isCycle = true;     // 마지막 벨만-포드 사이클에서 값이 변할경우 음수 사이클 존재
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        if(isCycle) {
            sb.append(-1);
        } else {
          for(int i=1;i<=N;i++) {
              if(i != 1) {
                  if(time[i] == Integer.MAX_VALUE)
                      sb.append(-1).append("\n");
                  else
                      sb.append(time[i]).append("\n");
              }
          }
        }
        System.out.println(sb);
    }
}
