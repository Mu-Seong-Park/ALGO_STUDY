package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class p1753 {
    //문제풀이
    // 1. 방향 그래프이므로, 노드(정점)이 가지는 adjacent(인접) 속성에는 일방향으로만 저장되도록 설계한다.
    // 2. 가중치를 계산하여 최단 경로를 구하므로 데이크스트라를 사용한다.


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ve = br.readLine().split(" ");
        int v = Integer.parseInt(ve[0]);
        int e = Integer.parseInt(ve[1]);
        Vertex[] vertices = new Vertex[v];

        for(int i = 0 ; i < v ; i++) {
            vertices[i] = new Vertex(i);
        }

        int startVertexIndex = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < e ; i++) {
            String[] edgeInfo = br.readLine().split(" ");
            int startV = Integer.parseInt(edgeInfo[0]) - 1;
            int endV = Integer.parseInt(edgeInfo[1]) - 1;
            int weight = Integer.parseInt(edgeInfo[2]);

            vertices[startV].add(weight, vertices[endV]);
        }

        dijkstra(vertices[startVertexIndex - 1],v,vertices);


        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(Vertex startV, int v, Vertex[] vertices) {

        Vertex currentVertex = startV;

        int[] cheapestPath = new int[v+1];
        cheapestPath[0] = 0;
        for(int i = 1 ; i < v + 1 ;i++) {
            cheapestPath[i] = Integer.MAX_VALUE;
        }
        //방문 확인 배열 생성
        boolean[] visited = new boolean[v];

        visited[0] = true;
        for(int i = 1 ; i < v ; i++) {
            visited[i] = false;
        }

        for(int i = 0 ; i < v + 1 ; i++) {
            int nodeWeight = Integer.MAX_VALUE;
            int nodeIndex = 0;

            for(int j = 1 ; j < v ; j++) {
                if(!visited[j] && cheapestPath[j] < nodeWeight) {
                    nodeWeight = cheapestPath[j];
                    nodeIndex = j;
                }
            }
            visited[nodeIndex] = true;



            for(Vertex key : currentVertex.adjacent.keySet()) {

                Integer a = (int)currentVertex.adjacent.get(key).poll();
                if(a == null) {
                    continue;
                }
                if(cheapestPath[key.name] > cheapestPath[nodeIndex] + a){
                    cheapestPath[key.name] = cheapestPath[nodeIndex] + a;
                }
            }

        }

        for(int i = 0 ; i < v ; i++) {
            if(cheapestPath[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(cheapestPath[i]);
            }
        }

    }
    /**
     * adjacent 해시맵에 인접한 Vertex를 Key로, Intger 값의 가중치를 모아놓은 우선순위큐 를 Value로 저장한다.
     */
    static class Vertex {
        int name;
        HashMap<Vertex, PriorityQueue> adjacent;

        public Vertex(int name) {
            this.name = name;
            this.adjacent = new HashMap<>();
        }

        public Vertex getVertex() {
            return this;
        }

        /**
         * 가중치를 입력받아서 values 우선순위 큐에 저장하는 메소드
         * @param weight 입력받는 가중치
         */
        public void add(int weight, Vertex v) {
            PriorityQueue<Integer> values = adjacent.putIfAbsent(v, makeQueue());
            if(values == null) {
                values = adjacent.get(v);
                values.offer(weight);
            } else {
                values.offer(weight);
            }
        }

        public PriorityQueue makeQueue() {
            return new PriorityQueue<Integer>();
        }

        public PriorityQueue getQueue(Vertex v) {
            return adjacent.get(v);
        }


    }
}
