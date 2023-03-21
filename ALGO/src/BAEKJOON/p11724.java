package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class p11724 {
    //문제풀이
    //1. Vertex 클래스를 만들어서 그래프를 표현한다.
    //2. DFS, BFS 어떤 방법이든 상관 없음.(모든 간선(edge)을 검색해야 하기 때문이다.)
    //3. 정점의 개수만큼 반복문이 수행되도록 한다.
    //4. visited 배열의 값이 true인 경우 continue를 통해서 connected component의 개수를
    // 셀 수 있다.

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");

        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        Vertex[] vertices = new Vertex[n];
        boolean[] visited = new boolean[n];

        for(int i = 0 ; i < n ; i++) {
            vertices[i] = new Vertex(i+1);
            visited[i] = false;
        }

        for(int i = 0 ; i < m ; i++) {
            String[] edge = br.readLine().split(" ");
            vertices[Integer.parseInt(edge[0]) - 1].add(vertices[Integer.parseInt(edge[1]) - 1]);
        }

        //인접 vertex를 value 크기 순으로 정렬
        for(int i = 0 ; i < n ; i++) {
            Collections.sort(vertices[i].adjacentVertices, new Comparator<Vertex>() {
                @Override
                public int compare(Vertex o1, Vertex o2) {
                    return o1.value - o2.value;
                }
            });
        }

        int connectedComponent = 0;
        for(int i = 0 ; i < n ; i++) {
            if(visited[i] == false) {
                dfs(vertices[i],visited);
                connectedComponent++;
            }
        }

        bw.write(connectedComponent+"\n");



        bw.flush();
        bw.close();
        br.close();
    }


    static void dfs(Vertex vertex, boolean[] visited) {
        visited[vertex.value - 1] = true;
        int iter = vertex.adjacentVertices.size();

        for(int i = 0 ; i < iter ; i++) {
            if(!visited[vertex.adjacentVertices.get(i).value - 1]) {
                dfs(vertex.adjacentVertices.get(i),visited);
            }
        }

    }

    static class Vertex {
        int value;
        ArrayList<Vertex> adjacentVertices;

        public Vertex(int value) {
            this.value = value;
            adjacentVertices = new ArrayList<>();
        }

        //방향이 없는 그래프이므로, vertex를 추가하면 상대의 vertex에도 current를 추가해야함.
        public void add(Vertex vertex) {
            adjacentVertices.add(vertex);
            vertex.adjacentVertices.add(this);
        }
    }

}
