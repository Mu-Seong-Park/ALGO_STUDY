package BAEKJOON;

import java.io.*;

public class p2705 {
    //재귀를 사용한다.
    //기저조건 : n == 1,2,3이 되는 경우 무조건 2.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCase ; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(pelPar(n)+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static int pelPar(int n) {

        if(n <= 3 && n >= 1 ) {
            return 2;
        }


    }
}
