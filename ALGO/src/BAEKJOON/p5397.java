package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class p5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for(int t =  0 ; t < testCase ; t++) {

            String[] password = br.readLine().split("");
            Stack<String> left = new Stack<>();
            Stack<String> right = new Stack<>();

            for(String str : password) {
                switch (str) {
                    case "<":
                        if(!left.isEmpty()){
                            right.push(left.pop());
                        }
                        break;

                    case ">":
                        if (!right.isEmpty()) {
                            left.push(right.pop());
                        }
                        break;

                    case "-":
                        if (!left.isEmpty()) {
                            left.pop();
                        }
                        break;

                    default:
                        left.push(str);
                }
            }

            while(!left.isEmpty()) {
                right.push(left.pop());
            }
            while(!right.isEmpty()) {
                bw.write(right.pop()+"");
            }
            bw.write("\n");
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

    public void deleteNode() {
        Node1 preNode;
        Node1 tempNode;

        if(head == null) {
            return;
        }

        if(head.nextNode == null) {
            head = null;
        } else {
            preNode = head;
            tempNode = head.nextNode;

            while(tempNode.nextNode != null) {
                preNode = tempNode;
                tempNode = tempNode.nextNode;
            }

            preNode.nextNode = null;
        }
    }

    public void printList() {
        Node1 tempNode = this.head;    // tempNode에 head가 가리키는 첫번째 노드를 할당

        // tempNode가 null이 아닐 때까지 반복하여 출력
        while(tempNode != null) {
            System.out.print(tempNode.getData());
            tempNode = tempNode.nextNode;    // temp 노드에 다음 노드(tempNode.link) 할당.
        }
        System.out.println();
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
