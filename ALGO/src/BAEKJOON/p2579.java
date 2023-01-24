package BAEKJOON;

import java.io.*;

public class p2579 {
    //풀이방법: 마지막 계단을 무조건 밟아야하므로 뒤에서부터 시작한다.

    static Integer[] stairs;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 계단의 갯수

        stairs = new Integer[n];
        scores = new int[n];
        for(int i = 0 ; i < n ; i++) {
            // 각 계단의 점수 저장
            stairs[i] = Integer.parseInt(br.readLine());
        }


        bw.flush();
        bw.close();
        br.close();
    }

    void 
}
