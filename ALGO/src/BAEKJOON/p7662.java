package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class p7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < testCase ; t++) {
            int command = Integer.parseInt(br.readLine());

            for(int i = 0 ; i < command ; i++) {
                String[]  cmnd = br.readLine().split(" ");

                if(cmnd[0].equals("I")) {

                } else {

                }
            }


        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class DoubleEndedPriorityQueue {
        ArrayList<Node> heap;
        int firstNode;
        int lastNode;

        public DoubleEndedPriorityQueue() {
            heap = new ArrayList<>();
            this.firstNode = heap.size();
            this.lastNode = heap.size();
        }

        void offer
    }
    static class Node {
        private int value;
//        private ArrayList<Node> child;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}


//여러모로 엉성한 코드, 문제에 제시된 예시는 되나
//
//        1
//        9
//        I 36
//        I 37
//        I 38
//        D 1
//        D 1
//        I 39
//        I 40
//        D -1
//        D -1
//위와 같이 최소힙, 최대힙을 몰아서 뽑고 다시 숫자를 저장하고 뽑는 경우 꼬이는 상황이 발생한다.
//import java.util.Collections;
//import java.util.PriorityQueue;
//
//public class p7662 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int testCase = Integer.parseInt(br.readLine());
//
//        for(int t = 0 ; t < testCase ; t++) {
//            int command = Integer.parseInt(br.readLine());
//            PriorityQueue<Integer> small = new PriorityQueue<>();
//            PriorityQueue<Integer> big = new PriorityQueue<>(Collections.reverseOrder());
//
//
//            int enqueueCount = 0;
//            int smallDequeueCount = 0;
//            int bigDequeueCount = 0;
//            for(int i = 0 ; i < command ; i++) {
//                String[]  cmnd = br.readLine().split(" ");
//
//                if(cmnd[0].equals("I")) {
//                    enqueueCount++;
//                    small.offer(Integer.parseInt(cmnd[1]));
//                    big.offer(Integer.parseInt(cmnd[1]));
//                } else {
//                    if(!small.isEmpty() && !big.isEmpty()) {
//                        if(cmnd[1].equals("-1")) {
//                            small.poll();
//                            smallDequeueCount++;
//                        } else {
//                            big.poll();
//                            bigDequeueCount++;
//                        }
//                    } else {
//
//                    }
//                }
//            }
//
//            if((smallDequeueCount+bigDequeueCount) >= enqueueCount) {
//                bw.write("EMPTY\n");
//            } else {
//                bw.write(big.poll()+" "+small.poll()+"\n");
//            }
//        }
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//}
////