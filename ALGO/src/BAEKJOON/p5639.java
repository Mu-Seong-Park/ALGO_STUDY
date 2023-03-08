package BAEKJOON;

import java.io.*;

public class p5639 {
    // 문제풀이 : 먼저 노드를 정의하고 바이너리 서치 트리 클래스를 구현한다.
    // 노드는 데이터를 가지고 있으며, left와 right라는 값을 통해서 자식 노드의 레퍼런스값을 가지고 있다.
    // left와 right는 null로 초기화하고, 트리 클래스 내부에서 구현할 insert 함수를 통해서 값을 전달받는다.
    // Tree 클래스에 필요한 변수로는 root node를 가진다.
    // Tree 클래스의 메소드는 insert와 postOrder를 구현한다.


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        MyNode root = null;
        int count = 0;
        MyBSTree tree = null;

        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")){
                break;
            }

            if(count == 0) {
                root = new MyNode(Integer.parseInt(input));
                tree = new MyBSTree(root);
            }
            else {
                int data = Integer.parseInt(input);

                tree.insert(data,root);
            }
            count++;
        }
        tree.postOrderSearch(root);
        bw.flush();
        bw.close();
        br.close();
    }
}

class MyBSTree {
    private MyNode root;

    public MyBSTree(MyNode root) {
        this.root = root;
    }

    /**
     * @param data 입력받는 데이터 int값
     * @param node 현재 위치한 node, 첫번째로 실행되는 경우 root
     */
    public void insert(int data, MyNode node) {

        //입력받는 data가 현재 위치한 값보다 작은 경우
        if(data < node.getData()) {
            //현재 노드의 left 자식이 없는 경우
            if(node.getLeft() == null) {
                MyNode newNode = new MyNode(data);
                node.setLeft(newNode);
            }
            //현재 노드의 left 자식이 있는 경우
            else {
                insert(data, node.getLeft());
            }

        }
        //data가 현재 위치한 값보다 큰 경우
        else if(data > node.getData()) {
            //현재 노드의 right 자식이 없는 경우
            if(node.getRight() == null) {
                MyNode newNode = new MyNode(data);
                node.setRight(newNode);
            }
            //현재 노드의 right 자식이 있는 경우
            else {
                insert(data, node.getRight());
            }
        }
        //같은 경우는 node가 겹치므로 종료한다.
        else {
            return;
        }
    }

    public void postOrderSearch(MyNode node) {
        if(node != null) {
            if(node.getLeft() != null) {
                postOrderSearch(node.getLeft());
            }

            if(node.getRight() != null) {
                postOrderSearch(node.getRight());
            }
            System.out.println(node.getData());
        }
    }
}

class MyNode {
    private int data;
    private MyNode left;
    private MyNode right;

    public MyNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }



    public void setLeft(MyNode left) {
        this.left = left;
    }

    public void setRight(MyNode right) {
        this.right = right;
    }

    public MyNode getLeft() {
        return left;
    }

    public MyNode getRight() {
        return right;
    }

    public int getData() {
        return data;
    }
}