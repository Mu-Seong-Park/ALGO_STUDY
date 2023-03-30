package BAEKJOON;

import java.io.*;
import java.util.PriorityQueue;

public class p1927 {
    //문제풀이 : 최소 힙을 우선순위 큐로 구현한다.
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int iter = 0 ; iter < n ; iter++) {
            int x = Integer.parseInt(br.readLine());

            if(x != 0) {
                queue.add(x);
            } else {
                if(queue.isEmpty()) {
                    bw.write(0+"\n");
                } else {
                    bw.write(queue.poll()+"\n");
                }
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
