package BAEKJOON;

import java.io.*;

public class p1991 {
    static MyTreeNode head = new MyTreeNode('A',null,null);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            String[] s = br.readLine().split(" ");
            char root = s[0].charAt(0);
            char left = s[1].charAt(0);
            char right = s[2].charAt(0);
            insert(head,root,left,right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void insert(MyTreeNode node, char root, char left, char right){

        if(node.getData().equals(root)) {

            node.setLeft((left == '.' ? null : new MyTreeNode(left,null,null)));
            node.setRight((right == '.' ? null : new MyTreeNode(right,null,null)));
        } else {
            if(node.getLeft() != null) {
                insert(node.getLeft(),root,left,right);
            }

            if(node.getRight() != null) {
                insert(node.getRight(),root,left,right);
            }
        }

    }


    //전위 순회, 루트 -> 왼쪽 자식 -> 오른쪽 자식
    public static void preOrder(MyTreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.getData());
        preOrder(node.getLeft());
        preOrder(node.getRight());

    }

    //중위 순회, 왼쪽 자식 -> 루트 -> 오른쪽 자식
    public static void inOrder(MyTreeNode node) {
        if(node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.print(node.getData()+"");
        inOrder(node.getRight());
    }

    //후위 순회, 왼쪽 자식 -> 오른쪽 자식 -> 루트
    public static void postOrder(MyTreeNode node) {
        if(node == null) {
            return;
        }

        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getData()+"");
    }

    static class MyTreeNode {
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

}


