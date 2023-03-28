package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class p11725 {
    //문제풀이
    // 1. Node의 연결관계를 모두 저장한다.
    // 2. 문제에서 항상 1번 노드가 루트이므로 1번에서부터 자식 노드를 구해야한다.
    // 3. 여기서 BFS 사용해야하는 문제임을 알 수 있다.
    // 4. BFS로 루트에서부터 가까운 노드들을 탐색한다.
    // 5. 탐색 과정에서 자식 노드를 발견하면 현재 있는 노드가 그 자식 노드들의 부모이다.
    // 6. 물론 자식 노드의 연결관계에도 부모가 있으므로, visited 배열을 두어서 이미 방문 했으면
    // 부모 노드로 간주한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n+1];

        for(int i = 0 ; i < n - 1 ; i++) {
            String[] nums = br.readLine().split(" ");
            int pre = Integer.parseInt(nums[0]);
            int post = Integer.parseInt(nums[1]);

            if(nodes[pre] == null) {
                nodes[pre] = new Node(pre);
            }

            if(nodes[post] == null) {
                nodes[post] = new Node(post);
            }

            nodes[pre].add(nodes[post]);

        }

        boolean[] visited = new boolean[n + 1];
        visited[0] = true; // 안쓰는 index
        for(int i = 1 ; i < n + 1 ; i++) {
            visited[i] = false;
        }

        int[] parentNode = new int[n+1];
        parentNode[0] = -1;
        for(int i = 1 ; i < n + 1 ; i++) {
            parentNode[i] = 0;
        }


        Queue<Node> q = new LinkedList<>();
        q.offer(nodes[1]);

        while(!q.isEmpty()) {
            Node current = q.poll();

            if(!visited[current.name]) {
                int iter = current.adjacent.size();
                if(iter > 0) {
                    for(int i = 0 ; i < iter ; i++) {
                        q.offer(current.adjacent.get(i));
                        if(!visited[current.adjacent.get(i).name]) {
                            parentNode[current.adjacent.get(i).name] = current.name;
                        }
                    }
                }
            }
            visited[current.name] = true;
        }

        for(int i = 2 ; i < n + 1; i++) {
            bw.write(parentNode[i]+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class Node {
        int name;

        ArrayList<Node> adjacent;

        public Node(int name) {
            this.name = name;
            this.adjacent = new ArrayList<>();
        }

        public void add(Node child) {
            adjacent.add(child);
            child.adjacent.add(this);
        }


    }
}
