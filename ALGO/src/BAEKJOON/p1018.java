package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p1018 {
    //풀이방법: 정답인 체스판을 배열로 만들어둔다.
    //체스판을 한칸씩 옆으로 옮겨가면서 전체 범위로 이동하면서 정답과 비교한다.
    //각각의 비교한 값을 배열로 저장해서 가장 값이 작은 것을 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" "); // N과 M을 입력받음.

        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        char[][] board = new char[n][m]; // M * N의 보드를 저장할 이차원 배열.

        //board 변수에 값 저장.
        for(int i = 0 ; i < n ; i++){
            board[i] = br.readLine().toCharArray();
        }

        char[][] answerBW = new char[8][8]; // BW... 형태의 정답을 저장할 배열.
        char[][] answerWB = new char[8][8]; // WB... 형태의 정답을 저장할 배열.

        for(int i = 0 ; i < 8 ; i++){
            //홀수줄과 짝수줄에 번갈아가며 WB, BW 등을 저장.
            if(i % 2 == 0) {
                answerBW[i] = "BWBWBWBW".toCharArray();
                answerWB[i] = "WBWBWBWB".toCharArray();
            }
            else {
                answerBW[i] = "WBWBWBWB".toCharArray();
                answerWB[i] = "BWBWBWBW".toCharArray();
            }
        }

        ArrayList<Integer> result = new ArrayList<>((n - 8)*(m - 8)); // 비교한 결과, 몇 칸의 색깔을 바꾸어야 하는지를 저장할 ArrayList.


        for(int i = 0 ; i <= n - 8 ; i++){
            // M * N 모양의 보드에서 정답지 8개짜리 보드판과 가로로 비교를 반복.
            int answerTempBW = 0; // BW형태와 몇 개가 다른지 +1을 반복하여 result에 저장할 값을 가지는 변수.
            int answerTempWB = 0; // WB형태와 몇 개가 다른지 +1을 반복하여 result에 저장할 값을 가지는 변수.

            for(int j = 0 ; j <= m - 8 ; j++){
                // M * N 모양의 보드에서 정답지 8개짜리 보드판과 세로로 비교를 반복.
                for(int k = 0 ; k < 8 ; k++){
                    for(int l = 0 ; l < 8 ; l++){
                        //정답 배열과 비교를 반복한다.
                        if(board[l+i][k+j] != answerBW[l][k]) {
                            answerTempBW++;
                        }
                        if(board[l+i][k+j] != answerWB[l][k]){
                            answerTempWB++;
                        }
                    }
                }
                if(answerTempBW > answerTempWB) {
                    //WB의 형태에서 바꾸어야할 칸이 적은 경우 그것을 저장.
                    result.add(answerTempWB);
                    answerTempBW = 0;
                    answerTempWB = 0;
                }
                else {
                    //BW의 형태가 더 적거나 같다면 BW를 저장.
                    result.add(answerTempBW);
                    answerTempBW = 0;
                    answerTempWB = 0;
                }
            }

        }

        Collections.sort(result);

        bw.write(result.get(0)+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
