package BAEKJOON;

import java.io.*;

public class p5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for(int t =  0 ; t < testCase ; t++) {

            StringBuilder sb = new StringBuilder();
            String password = br.readLine();

        }

        br.close();
        bw.flush();
        bw.close();
    }
}

class MyLinkedList1 {

    //Node1타입의 노드 중 가장 앞에 위치한 노드
    private Node1 head;

    public MyLinkedList1() {
        this.head = null;
    }

    public void insertNode(Node1 preNode, String data) {
        Node1 newNode = new Node1(data);

        newNode.nextNode = preNode.nextNode;


        preNode.nextNode = newNode;
    }

    public void insertNode(String data) {
        Node1 newNode = new Node1(data);

        if(head == null) {
            this.head = newNode;
        } else {
            Node1 temp = head;

            while(temp.nextNode != null) {
                temp = temp.nextNode;
            }

            temp.nextNode = newNode;
        }
    }
}

class Node1 {
    private String data;
    public Node1 nextNode;

    public Node1(String data) {
        this.data = data;
        this.nextNode = null;
    }

    public Node1() {
        this.data = null;
        this.nextNode = null;
    }

    public Node1(String data, Node1 nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public String getData() {
        return this.data;
    }
}
