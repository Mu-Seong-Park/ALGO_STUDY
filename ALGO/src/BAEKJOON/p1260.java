package BAEKJOON;

import java.io.*;
import java.util.*;

public class p1260 {
    //문제풀이
    //1. 그래프 클래스를 정의한다.
    //vertex 클래스를 만들어서, 어느 정점과 이어져있는지, 어떤 수를 가지는지 저장
    //2. DFS 와 BFS를 구현한다.
    // DFS는 재귀, BFS는 큐를 사용하면 된다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]); // vertex 갯수
        int m = Integer.parseInt(nums[1]); // edge 갯수
        int startVertex = Integer.parseInt(nums[2]); // 시작하는 정점의 value

        Vertex[] vertices = new Vertex[n];
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++) {
            vertices[i] = new Vertex(i+1);
            visited[i] = false;
        }

        for(int i = 0 ; i < m ; i++) {
            String[] edge = br.readLine().split(" ");

            vertices[Integer.parseInt(edge[0]) - 1].addAdjacentVertex(vertices[Integer.parseInt(edge[1]) - 1]);
        }


        for(int i = 0 ; i < n ; i++) {
            Collections.sort(vertices[i].adjacentVertices, new Comparator<Vertex>() {
                @Override
                public int compare(Vertex o1, Vertex o2) {
                    return o1.value - o2.value;
                }
            });
        }

        dfs(vertices[startVertex - 1], visited);

        for(int i = 0 ; i < n ; i++) {
            visited[i] = false;
        }
        Queue<Vertex> queue = new LinkedList<>();


        bfs(vertices[startVertex-1], visited, queue);

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(Vertex vertex, boolean[] visited) {

        visited[vertex.value - 1] = true;
        System.out.print(vertex.value+" ");
        int iter = vertex.adjacentVertices.size();
        for(int i = 0 ; i < iter ; i++) {
            if(visited[vertex.adjacentVertices.get(i).value-1] == false) {
                dfs(vertex.adjacentVertices.get(i),visited);
            }
        }
    }

    static void bfs(Vertex vertex, boolean[] visited, Queue<Vertex> queue) {
        System.out.println();
        visited[vertex.value - 1] = true;

        queue.offer(vertex);
        do {
            Vertex currentVertex = queue.poll();
            System.out.print(currentVertex.value+" ");
            int iter = currentVertex.adjacentVertices.size();
            for(int i = 0 ; i < iter ; i++) {
                if(visited[currentVertex.adjacentVertices.get(i).value - 1] == false) {
                    visited[currentVertex.adjacentVertices.get(i).value - 1] = true;
                    queue.add(currentVertex.adjacentVertices.get(i));
                }
            }
        }while(queue.size() != 0);
    }
    static class Vertex {
        int value;
        ArrayList<Vertex> adjacentVertices;

        public Vertex(int value) {
            this.value = value;
            this.adjacentVertices = new ArrayList<>();
        }

        public void addAdjacentVertex(Vertex adjacent) {
            adjacentVertices.add(adjacent);
            adjacent.adjacentVertices.add(this);
        }
    }
}
