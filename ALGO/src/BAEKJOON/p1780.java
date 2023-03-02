package BAEKJOON;

import java.io.*;
import java.nio.Buffer;

public class p1780 {
    //문제풀이 : 종이를 9개로 자른다는 것은 column과 row를 3으로 각각 나누어버린다는 것.
    //3으로 나누는 형태의 재귀를 사용하여 해결한다.
    //기저조건 : 종이 한 장에 숫자가 1개만 들어있는 경우, 즉 길이(숫자 하나의 길이를 1이라 할때)
    //1이 되는 경우.
    //함수의 입력으로 시작하는 i,j 좌표와 한 줄의 개수 n을 입력받는다.
    //n을 3으로 나누어 작은 종이 각각이 문제의 조건이 맞는지 확인한다.
    //조건이 성립되지 않는 경우 그 종이의 범위에서 다시 함수를 실행한다.
    //정답은 -1,0,1 3개의 개수를 구해야하므로 전역변수로 ans 배열을 만들어둔다.
    static int[][] board;
    static int[] ans = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //종이의 길이, n개의 정수를 저장하는 변수
        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for(int i = 0 ; i < n ; i++) {

            String[] nums = br.readLine().split(" ");
            for(int j = 0 ; j < n ; j++) {
                board[i][j] = Integer.parseInt(nums[j]);
            }

        }

        paperCut(0,0,n);

        for(int i = 0 ; i < 3 ; i++) {
            bw.write(ans[i]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void paperCut(int i, int j, int n) {

        if(n == 1) {
            if(board[i][j] == -1) {
                ans[0]++;

            }
            else if(board[i][j] == 0) {
                ans[1]++;
            }
            else {
                ans[2]++;
            }
            return;
        }
        int standard = board[i][j];
        boolean check = true;
        for(int row = i ; row < i + n ; row++) {

            for(int col = j ; col < j + n ; col++) {
                int temp = board[row][col];
                if (standard != temp) {
                    check = false;
                    break;
                }
            }
            if(check == false) {
                break;
            }
        }

        if(check == true) {
            if(board[i][j] == -1) {
                ans[0]++;
            }
            else if(board[i][j] == 0) {
                ans[1]++;
            }
            else {
                ans[2]++;
            }
            return;
        } else {
            for(int row = i ; row < i + n ; row = row + n / 3) {

                for(int col = j ; col < j + n ; col = col + n / 3) {
                    paperCut(row,col,n/3);
                }
            }
        }

    }
}
