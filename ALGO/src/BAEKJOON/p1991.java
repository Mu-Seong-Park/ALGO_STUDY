package BAEKJOON;

import java.io.*;

public class p1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        MyTreeNode head = new MyTreeNode("A",null,null);
        MyTree tree = new MyTree();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            String[] s = br.readLine().split(" ");
            char root = s[0].charAt(0);
            char left = s[1].charAt(0);
            char right = s[2].charAt(0);

        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class MyTree {
    MyTreeNode root;

    public MyTree() {
        this.root = null;
    }

    public void insert(MyTreeNode node, char root, char left, char right){

        if(node.getData().equals(root)) {
            if(left == '.') {

            }
        }

    }


    //전위 순회, 루트 -> 왼쪽 자식 -> 오른쪽 자식
    public void preOrder(MyTreeNode node) {

    }

    //중위 순회, 왼쪽 자식 -> 루트 -> 오른쪽 자식
    public void inOrder(MyTreeNode node) {

    }

    //후위 순회, 왼쪽 자식 -> 오른쪽 자식 -> 루트
    public void postOrder(MyTreeNode node) {

    }
}

class MyTreeNode {
    private Object data;
    private MyTreeNode left;
    private MyTreeNode right;

    public MyTreeNode(Object data, MyTreeNode left, MyTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Object getData() {
        return data;
    }

    public MyTreeNode getLeft() {
        return left;
    }

    public MyTreeNode getRight() {
        return right;
    }

    public void setLeft(MyTreeNode left) {
        this.left = left;
    }

    public void setRight(MyTreeNode right) {
        this.right = right;
    }
}
