package BAEKJOON;

import java.io.*;
import java.util.*;
import java.math.*;

public class p1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int testCase = 0 ; testCase < 3 ; testCase++) {
            int iter = Integer.parseInt(br.readLine());
            BigInteger sum = new BigInteger("0");
            for(int i = 0 ; i < iter ; i++) {
                BigInteger temp = new BigInteger(br.readLine());
                sum = sum.add(temp);

            }
            BigInteger zero = new BigInteger("0");
            if(sum.compareTo(zero) > 0) {
                bw.write("+\n");
            } else if(sum.compareTo(zero) < 0) {
                bw.write("-\n");
            } else if(sum.compareTo(zero) == 0){
                bw.write("0\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
