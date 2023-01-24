package BAEKJOON;

import java.io.*;

public class p1074 {
    //풀이방법: 결국 2*2로 다 나누어서 생각하는 문제.
    //배열을 좌표의 사분면과 같이 4개로 나누어서 r,c가 어느 사분면에 속하는지 알아낸다.
    //재귀를 호출 할 때마다 어느 사분면을 방문하는건지 알아내기 위해서 count 변수에 저장한다.
    //예를 들어 제1사분면을 방문하면 count에 아무것도 더하지 않고, 제2사분면은 (size * size) / 4 를 더해준다.
    //제3사분면은 ((size * size) / 4) * 2 를 더해준다.
    //재귀를 호출하는 경우 제2사분면 이상으로는 row 와 column 값에 size / 2를 빼준다.
    //미리 count에 size~~~~값을 더해주었기 때문에 제1사분면에 있는 것처럼 형식을 맞춰주어야 하기 때문.
    //https://wiselog.tistory.com/133

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N,r,c를 입력받고 저장한다, r과 c는 0이상, 2^n미만의 숫자. 1번째 행과 열은 0으로 나타냄(배열 index처럼).
        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int r = Integer.parseInt(nums[1]);
        int c = Integer.parseInt(nums[2]);

        int size = (int)(Math.pow(2,N));
        count = 0;

        search(size,r,c);

        bw.write(count+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void search(int size, int r ,int c) {
        //size는 한 변에 몇 칸이 들어가는지.
        if(size == 1) {
            //2 * 2인 최소 단위에 방문한 경우
            return ;
        }

        if(r < size / 2 && c < size / 2) {
            //제1사분면
            search(size/2,r,c);
        }
        else if(r < size / 2 && c >= size / 2) {
            //제2사분면
            count += (size * size) / 4;
            search(size/2,r,c - (size / 2));
        }
        else if(r >= size / 2 && c < size / 2) {
            //제3사분면
            count += ((size * size) / 4 ) * 2;
            search(size/2,r - (size / 2),c);
        }
        else {
            //제4사분면
            count += ((size * size) / 4 ) * 3;
            search(size/2,r- (size / 2),c- (size / 2));
        }



    }


}
