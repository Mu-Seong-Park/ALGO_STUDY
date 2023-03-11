package BAEKJOON;

import java.io.*;
import java.util.ArrayList;

public class p11279 {
    //문제 아이디어는 똑같고 기능도 비슷한데,내 풀이에서는 index관련 처리하는 부분에 문제가 발생한듯함.
    static ArrayList<Integer> heap = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        heap.add(1000000);
        for(int testCase = 0 ; testCase < n ; testCase++) {
            int cal = Integer.parseInt(br.readLine());
            int answer = -1;
            if(cal == 0 ){
                answer = delete();
                bw.write(answer+"\n");
            }
            else {
                insert(cal);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static public void insert(int value) {
        heap.add(value);
        int index = heap.size() - 1;

        while(index > 1 && heap.get(index / 2) < heap.get(index)) {
            int temp = heap.get(index/2);
            heap.set(index / 2 , heap.get(index));
            heap.set(index, temp);
            index /= 2;
        }
    }

    public static int delete() {
        if(heap.size() - 1< 1) {
            return 0;
        }

        int head = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int index = 1;

        while((index * 2) < heap.size()) {
            int max = heap.get(index * 2);
            int maxIndex = index * 2;
            if(((maxIndex + 1) < heap.size()) && max < heap.get(index*2 + 1)) {
                max = heap.get(index * 2 + 1);
                maxIndex = index * 2 + 1;
            }

            if(heap.get(index) > max) {
                break;
            }

            int temp = heap.get(index);
            heap.set(index, heap.get(maxIndex));
            heap.set(maxIndex, temp);
            index = maxIndex;
        }

        return head;
    }
}

//package BAEKJOON;
//
//        import java.io.*;
//        import java.sql.SQLOutput;
//        import java.util.ArrayList;
//
//public class p11279 {
//    static ArrayList<Integer> heap = new ArrayList<>();
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int n = Integer.parseInt(br.readLine());
//
//        for(int testCase = 0 ; testCase < n ; testCase++) {
//            int cal = Integer.parseInt(br.readLine());
//            int answer = -1;
//            if(cal == 0 ){
//                answer = delete();
//                bw.write(answer+"\n");
//            }
//            else {
//                insert(cal);
//            }
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}
//    static void insert(int value) {
//        heap.add(value);
//        int newNodeIndex = heap.size() - 1;
//
//        while(newNodeIndex > 0 && heap.get(newNodeIndex) > heap.get(parentIndex(newNodeIndex))) {
//            int temp = heap.get(parentIndex(newNodeIndex));
//            heap.set(parentIndex(newNodeIndex), heap.get(newNodeIndex));
//            heap.set(newNodeIndex,temp);
//
//            newNodeIndex = parentIndex(newNodeIndex);
//        }
//    }
//
//    static int delete() {
//        if(heap.size() == 0) {
//            return 0;
//        }
//
//        int answer = heap.get(0);
//
//        //마지막 노드를 heap의 루트로 넣는다.(trickle node)
//        int lastIndex = heap.size() - 1;
//        int trickle = heap.get(lastIndex);
//        int trickleNode = 0;
//        heap.set(0,trickle);
//        heap.remove(lastIndex);
//
//        while(hasBiggerChild(trickleNode)) {
//            int largerChildIndex = calChildIndex(trickleNode);
//
//            int temp = heap.get(largerChildIndex);
//            heap.set(largerChildIndex,heap.get(trickleNode));
//            heap.set(trickleNode,temp);
//
//            trickleNode = largerChildIndex;
//        }
//
//
//        return answer;
//    }
//
//    static boolean hasBiggerChild(int index) {
//
//        if(heap.size() > leftChildIndex(index) || heap.size() > rightChildIndex(index)) {
//            if(heap.get(leftChildIndex(index)) > heap.get(index) && heap.size() > leftChildIndex(index)) {
//                return true;
//            }
//
//            if(heap.get(rightChildIndex(index)) > heap.get(index) && heap.size() > rightChildIndex(index)) {
//                return true;
//            }
//        }
//
//
//        return false;
//    }
//
//    static int calChildIndex(int index) {
//        if(heap.size() < rightChildIndex(index)) {
//            return leftChildIndex(index);
//        }
//
//        if(heap.size() > rightChildIndex(index) && heap.get(rightChildIndex(index)) > heap.get(leftChildIndex(index))) {
//            return rightChildIndex(index);
//        }
//        else {
//            return leftChildIndex(index);
//        }
//    }
//
//    static int leftChildIndex (int index) {
//        return (index * 2) + 1;
//    }
//
//    static int rightChildIndex (int index) {
//        return (index * 2) + 2;
//    }
//
//    static int parentIndex (int index) {
//        return (index - 1) / 2;
//    }
