package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class p7662 {
    // 블로그를 검색해보니 TreeMap이라는 자료구조를 사용한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int command = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> queue = new TreeMap<>();
            for (int i = 0; i < command; i++) {
                String[] cmnd = br.readLine().split(" ");
                int n = Integer.parseInt(cmnd[1]);
                if (cmnd[0].equals("I")) {
                    queue.put(n, queue.getOrDefault(n, 0) + 1);
                } else {
                    if (!queue.isEmpty()) {
                        //n이 1인 경우, num에 lastKey를 저장해서 최댓값 삭제, 1이 아닌 경우
                        //firstKey를 저장해서 최솟값 삭제.
                        int num = n == 1 ? queue.lastKey() : queue.firstKey();
                        if (queue.put(num, queue.get(num) - 1) == 1) {
                            queue.remove(num);
                        }
                    }
                }
            }
            //treemap이 비었으면 empty 출력, 아니라면 최댓값 최솟값을 출력.
            bw.write(queue.isEmpty() ? "EMPTY\n" : queue.lastKey() + " " + queue.firstKey() + "\n");


        }

        br.close();
        bw.flush();
        bw.close();
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