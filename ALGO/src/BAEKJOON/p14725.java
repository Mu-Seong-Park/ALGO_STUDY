package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;

public class p14725 {
    //문제풀이
    // 1. Node를 정의한다.
    // Node는 자신의 이름 변수 name과 자식들의 이름이 Key이고 그 주소가 Value인 HashTable을 가진다.
    // 출력할 시에는 Key를 Collections.sort를 이용하여 정렬한 뒤에 그 순서대로 출력하면 된다.
    // 2. 이 문제는 좌측에서부터 세로로 깊게 파고드는 문제이기 때문에 DFS(재귀)를 사용한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Node root = new Node("root");
        for(int i = 0 ; i < n ; i++) {
            String[] info = br.readLine().split(" ");
            int k = Integer.parseInt(info[0]);
            Node[] nodes = new Node[k + 1];
            nodes[0] = root;
            for(int j = 1 ; j <= k ; j++) {
                if(nodes[j - 1].adjacent.containsKey(info[j])) {
                    nodes[j] = nodes[j - 1].adjacent.get(info[j]);
                    bw.write(info[j]+"가 있습니다. 주소는: "+nodes[j]+"\n");
                    continue;
                } else {
                    nodes[j - 1].add(info[j]);
                    nodes[j] = nodes[j - 1].adjacent.get(info[j]);
                    bw.write(info[j]+"가 없어서 추가했습니다. 주소는: "+nodes[j]+"\n");

                }
            }
        }

        DFS(root,0);
        br.close();
        bw.flush();
        bw.close();
    }

    /**
     * @param currentNode 현재 노드를 입력한다.
     * @param n           현재가 몇 층인지 알기 위해서 입력하는 숫자
     *                    n을 통해서 "-"를 몇 번(n*2) 출력할지 정한다.
     */
    static void DFS(Node currentNode,int n) {

        //DFS 기저조건 : 자식이 없는 노드의 경우 null을 리턴할 것이므로, null인 경우 메소드 종료
        if(currentNode == null) {
            return;
        }
        
        ArrayList<String> currentKeys = new ArrayList<>(currentNode.adjacent.keySet());
        Collections.sort(currentKeys);

        for(String key : currentKeys) {
            if(currentNode.name == "root") {
                DFS(currentNode.adjacent.get(key), n);
            } else {
                for(int i = 0 ; i < n * 2 ; i++) {
                    System.out.print("-");
                }
                System.out.println(currentNode.name+" 주소:"+currentNode);
                DFS(currentNode.adjacent.get(key), ++n);
            }
        }
    }



    static class Node {
        String name;
        Hashtable<String,Node> adjacent;

        public Node(String name) {
            this.name = name;
            adjacent = new Hashtable<>();
        }

        public void add(String name) {
            adjacent.put(name,new Node(name));
        }

    }
}
