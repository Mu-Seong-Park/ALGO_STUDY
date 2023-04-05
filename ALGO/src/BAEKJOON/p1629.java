package BAEKJOON;

import java.io.*;
import java.math.BigInteger;

public class p1629 {
    //문제풀이 https://st-lab.tistory.com/237(참고)
    //'지수 법칙'과 '모듈러 성질'
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");

        long a = Long.parseLong(nums[0]);
        long b = Long.parseLong(nums[1]);
        long c = Long.parseLong(nums[2]);

        bw.write(pow(a,b,c)+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
    static long pow(long a, long exp, long c) {
        if(exp == 1) {
            return a % c;
        }

        long temp = pow(a,exp/2, c);

        if(exp % 2 == 1) {
            return (temp * temp % c) * a % c;
        }

        return temp * temp % c;
    }
}

// 메모리 초과 발생.
//    //문제풀이
//    // biginteger를 사용한다.
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String[] nums = br.readLine().split(" ");
//
//        BigInteger a = new BigInteger(nums[0]);
//        int b = Integer.parseInt(nums[1]);
//        BigInteger c = new BigInteger(nums[2]);
//
//        for(int i = 0 ; i < b ; i++) {
//            a = a.multiply(a);
//        }
//        bw.write(a.mod(c)+"\n");
//        bw.flush();
//        bw.close();
//        br.close();
//    }