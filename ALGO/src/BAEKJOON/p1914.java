package BAEKJOON;

import java.io.*;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class p1914 {
    static Queue<String> myQueue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        myQueue = new LinkedList<>();

        if(n > 20) {
            BigInteger result = hanoi(n);
            bw.write(result+"\n");
        } else {
            BigInteger result = hanoi(n);
            smallHanoi(n,1,2,3);
            bw.write(result+"\n");
            int iter = myQueue.size();
            for(int i = 0 ; i < iter ; i++) {
                bw.write(myQueue.poll());
            }
        }



        bw.flush();
        bw.close();
        br.close();
    }

    static BigInteger hanoi(int n) {
        if(n == 1) {
            return new BigInteger("1");
        }
        return (hanoi(n - 1).multiply(new BigInteger("2"))).add(new BigInteger("1"));
    }
    static void smallHanoi(int n, int from, int temp, int to) {
        if(n == 0) {
            return;
        }
        smallHanoi(n - 1, from, to, temp);
        myQueue.add(from+" "+ to + "\n");
        smallHanoi(n - 1,temp,from,to);
    }
}
