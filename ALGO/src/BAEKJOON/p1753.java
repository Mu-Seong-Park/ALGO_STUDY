package BAEKJOON;

import java.io.*;
import java.util.*;

//https://dragon-h.tistory.com/20 블로그참조

class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class p1753 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 100_000_000;
    static int v,e,k;
    static List<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        dist = new int[v + 1];

        Arrays.fill(dist, INF);

        for(int i = 1; i <= v; i++){
            list[i] = new ArrayList<>();
        }
        // 리스트에 그래프 정보를 초기화
        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // start에서 end로 가는 weight 가중치
            list[start].add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();
        // 다익스트라 알고리즘
        dijkstra(k);
        // 출력 부분
        for(int i = 1; i <= v; i++){
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[v + 1];
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end;

            if(check[cur] == true) continue;
            check[cur] = true;

            for(Node node : list[cur]){
                if(dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}







//import java.io.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.PriorityQueue;
//
//public class p1753 {
//    //문제풀이
//    // 1. 방향 그래프이므로, 노드(정점)이 가지는 adjacent(인접) 속성에는 일방향으로만 저장되도록 설계한다.
//    // 2. 가중치를 계산하여 최단 경로를 구하므로 데이크스트라를 사용한다.
//    private static final int INF = 100_000_000;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String[] ve = br.readLine().split(" ");
//        int v = Integer.parseInt(ve[0]);
//        int e = Integer.parseInt(ve[1]);
//        Vertex[] vertices = new Vertex[v];
//
//        for(int i = 0 ; i < v ; i++) {
//            vertices[i] = new Vertex(i);
//        }
//
//        int startVertexIndex = Integer.parseInt(br.readLine());
//
//        for(int i = 0 ; i < e ; i++) {
//            String[] edgeInfo = br.readLine().split(" ");
//            int startV = Integer.parseInt(edgeInfo[0]) - 1;
//            int endV = Integer.parseInt(edgeInfo[1]) - 1;
//            int weight = Integer.parseInt(edgeInfo[2]);
//
//            vertices[startV].add(weight, vertices[endV]);
//        }
//
//        dijkstra(vertices[startVertexIndex - 1],v,vertices);
//
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    static void dijkstra(Vertex startV, int v, Vertex[] vertices) {
//
//        Vertex currentVertex = startV;
//
//        int[] cheapestPath = new int[v];
//        //방문 확인 배열 생성
//        boolean[] visited = new boolean[v];
//        for(int i = 0 ; i < v ;i++) {
//            cheapestPath[i] = INF;
//        }
//
//        for(int i = 0 ; i < v ; i++) {
//            visited[i] = false;
//        }
//
//        //시작하는 노드의 비용은 0, 방문여부는 true
//        cheapestPath[currentVertex.name] = 0;
//        visited[currentVertex.name] = true;
//
//        for(int i = 0 ; i < v ; i++) {
//
//            int nodeWeight = INF;
//            int nodeIndex = 0;
//
//            for(int j = 0 ; j < v ; j++) {
//                if(!visited[j] && cheapestPath[j] < nodeWeight) {
//                    nodeWeight = cheapestPath[j];
//                    nodeIndex = j;
//                }
//            }
//            visited[nodeIndex] = true;
//            if(nodeIndex == 0 && visited[nodeIndex] == true && i != 0) {
//                break;
//            }
//            currentVertex = vertices[nodeIndex];
//
//            if(!currentVertex.adjacent.isEmpty()) {
//                for(Vertex key : currentVertex.adjacent.keySet()) {
//
//                    Integer a = (int)currentVertex.adjacent.get(key).poll();
//
//                    if(cheapestPath[key.name] > cheapestPath[nodeIndex] + a){
//                        cheapestPath[key.name] = cheapestPath[nodeIndex] + a;
//                    }
//                }
//            }
//        }
//
//        for(int i = 0 ; i < v ; i++) {
//            if(cheapestPath[i] == INF) {
//                System.out.println("INF");
//            }
//            else {
//                System.out.println(cheapestPath[i]);
//            }
//        }
//
//    }
//    /**
//     * adjacent 해시맵에 인접한 Vertex를 Key로, Intger 값의 가중치를 모아놓은 우선순위큐 를 Value로 저장한다.
//     */
//    static class Vertex {
//        int name;
//        HashMap<Vertex, PriorityQueue> adjacent;
//
//        public Vertex(int name) {
//            this.name = name;
//            this.adjacent = new HashMap<>();
//        }
//
//        public Vertex getVertex() {
//            return this;
//        }
//
//        /**
//         * 가중치를 입력받아서 values 우선순위 큐에 저장하는 메소드
//         * @param weight 입력받는 가중치
//         */
//        public void add(int weight, Vertex v) {
//            PriorityQueue<Integer> values = adjacent.putIfAbsent(v, makeQueue());
//            if(values == null) {
//                values = adjacent.get(v);
//                values.offer(weight);
//            } else {
//                values.offer(weight);
//            }
//        }
//
//        public PriorityQueue makeQueue() {
//            return new PriorityQueue<Integer>();
//        }
//
//        public PriorityQueue getQueue(Vertex v) {
//            return adjacent.get(v);
//        }
//
//
//    }
//}
