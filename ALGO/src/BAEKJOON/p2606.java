package BAEKJOON;

import java.io.*;
import java.util.*;

public class p2606 {
    // 문제풀이
    //1. 정점 클래스(Vertex)를 정의하여 vertex 간의 연결 관계를 저장한다.
    //2. 이 문제는 시작 vertex와 연결된 모든 정점을 찾아야하므로, DFS나 BFS 둘 중 어느 것을
    // 사용해도 상관이 없다.
    //3. visited 배열에서 true로 값이 바뀐 갯수를 구하면 감염된 컴퓨터 수를 알 수 있다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 갯수
        int m = Integer.parseInt(br.readLine()); // 컴퓨터 그래프의 엣지 갯수
        Vertex[] vertices = new Vertex[n]; // 정점을 저장할 배열 선언
        boolean[] visited = new boolean[n]; // 방문 여부 확인
        for(int i = 0 ; i < n ; i++) {
            vertices[i] = new Vertex(i+1);
            visited[i] = false;
        }

        for(int i = 0 ; i < m ; i++) {
            String[] edge = br.readLine().split(" "); // 엣지를 저장.
            vertices[Integer.parseInt(edge[0]) - 1].addAdjacentVertex(vertices[Integer.parseInt(edge[1]) - 1]);
        }

        //연결관계를 정렬한다.
        for(int i = 0 ; i < n ; i++) {
            Collections.sort(vertices[i].adjacentVertices, new Comparator<Vertex>() {
                @Override
                public int compare(Vertex o1, Vertex o2) {
                    return o1.value - o2.value;
                }
            });
        }
        //BFS
        Queue<Vertex> queue = new LinkedList<>();
        bfs(vertices[0], visited, queue);

        //DFS
        //dfs(vertices[0], visited);

        int count = 0;
        //1번 컴퓨터는 count에서 제외한다.(문제조건)
        for(int i = 1 ; i < n ; i++) {
           if(visited[i]) {
               count++;
           }
        }

        bw.write(count+"\n");

        br.close();
        bw.flush();
        bw.close();
    }

    //dfs
    static void dfs(Vertex vertex, boolean[] visited) {
        visited[vertex.value - 1] = true;
        int iter = vertex.adjacentVertices.size();
        for(int i = 0 ; i < iter ; i++) {
            if(visited[vertex.adjacentVertices.get(i).value - 1] == false) {
                dfs(vertex.adjacentVertices.get(i),visited);
            }
        }
    }

    //bfs
    static void bfs(Vertex vertex, boolean[] visited, Queue<Vertex> queue) {
        visited[vertex.value - 1] = true;
        queue.offer(vertex);

        do {
            Vertex currentVertex = queue.poll();
            int iter = currentVertex.adjacentVertices.size();

            for(int i = 0; i < iter ; i++) {
                if(visited[currentVertex.adjacentVertices.get(i).value - 1] == false) {
                    visited[currentVertex.adjacentVertices.get(i).value - 1] = true;
                    queue.add(currentVertex.adjacentVertices.get(i));
                }
            }

        } while(queue.size() != 0);
    }

    static class Vertex {
        int value;
        ArrayList<Vertex> adjacentVertices;

        public Vertex(int value) {
            this.value = value;
            this.adjacentVertices = new ArrayList<>();
        }

        public void addAdjacentVertex(Vertex vertex) {
            adjacentVertices.add(vertex);
            vertex.adjacentVertices.add(this);

        }
    }
}
