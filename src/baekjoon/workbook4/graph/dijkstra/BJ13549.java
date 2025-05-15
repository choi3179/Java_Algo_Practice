package baekjoon.workbook4.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ13549 {

    static class Point {
        int n;
        int time;

        Point(int n, int time) {
            this.n = n;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        boolean[] visited = new boolean[100001];
        int min = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(N,0));

        visited[N] = true;

        while(!q.isEmpty()) {

            Point point = q.poll();
            visited[point.n] = true;
            if(point.n == K)
                min = Math.min(point.time, min);

            int move1 = point.n + 1;
            int move2 = point.n - 1;
            int sec = point.n * 2;

            if(move1 < 100001 && !visited[move1])
                q.add(new Point(move1, point.time+1));
            if(move2 >= 0 && !visited[move2])
                q.add(new Point(move2, point.time+1));
            if(sec < 100001 && !visited[sec])
                q.add(new Point(sec, point.time));
        }

        System.out.println(min);
    }
}
