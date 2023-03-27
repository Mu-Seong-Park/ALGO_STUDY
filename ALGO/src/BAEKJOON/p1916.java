package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class p1916 {
    //문제풀이
    //1. 전형적인 다익스트라문제
    //2. 참고 : https://steady-coding.tistory.com/84
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());


        ArrayList<ArrayList<Node>> a = new ArrayList<>();


        for(int i = 0 ; i <= n ; i++) {
            a.add(new ArrayList<>());
        }

        for(int i = 0 ; i < m ; i++) {
            String[] nums = br.readLine().split(" ");

            int start = Integer.parseInt(nums[0]);
            int end = Integer.parseInt(nums[1]);
            int weight = Integer.parseInt(nums[2]);

            a.get(start).add(new Node(end,weight));
        }

        String[] nums = br.readLine().split(" ");

        int start = Integer.parseInt(nums[0]);
        int end = Integer.parseInt(nums[1]);

        bw.write(dijkstra(a,start,end,n)+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(ArrayList<ArrayList<Node>> a, int start, int end, int n) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node node : a.get(cur)) {
                    if (!visited[node.end] && distance[node.end] > distance[cur] + node.weight) {
                        distance[node.end] = distance[cur] + node.weight;
                        pq.add(new Node(node.end, distance[node.end]));
                    }
                }
            }
        }
        return distance[end];
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
