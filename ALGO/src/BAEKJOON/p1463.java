package BAEKJOON;

import java.io.*;

public class p1463 {
    //풀이방법: 3으로 나누는 것이 1순위, 2로 나누는 것은 2순위 1을 빼는 것은 3순위이다.
    //x % 3 을 구하여, 1이 남는다면 -1 연산, 짝수라면 / 2 연산, 3의 배수라면 / 3 연산을 진행한다.
    //-> 위의 풀이는 틀렸음. 항상 3으로 나누는 것이 좋다고 보장할 수 없음.
    //따라서 연산을 진행할 때마다 매번 최적의 해인지 검사를 해야함. -> DP(다이나믹 프로그래밍)을 활용하자.
    //Top-Down 방식으로 풀어본다.
    //참고 자료: https://st-lab.tistory.com/133

    static Integer[] countMemo; // 연산횟수 저장 배열, null값으로 사용하기 위해 Intger 래퍼클래스로 선언.

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 만들어야할 정수.
        int count = 0; // 연산 횟수를 저장.

        //배열 생성.
        countMemo = new Integer[n+1];
        countMemo[0] = 0;
        countMemo[1] = 0;
        count = calculation(n);


        bw.write(count+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static int calculation(int x) {
        //x를 입력받아서 연산을 진행하는 함수.
        if(countMemo[x] == null) {
            // 6으로 나눠지는 경우
            if (x % 6 == 0) {
                countMemo[x] = Math.min(calculation(x - 1), Math.min(calculation(x / 3), calculation(x / 2))) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (x % 3 == 0) {
                countMemo[x] = Math.min(calculation(x / 3), calculation(x - 1)) + 1;
            }
            // 2로만 나눠지는 경우
            else if (x % 2 == 0) {
                countMemo[x] = Math.min(calculation(x / 2), calculation(x - 1)) + 1;
            }
            // 2와 3으로 나누어지지 않는 경우
            else {
                countMemo[x] = calculation(x - 1) + 1;
            }
        }

        return countMemo[x];
    }
}

//3으로 나누는 것이 항상 좋다고 보장할 수 없음.
//틀린 풀이방식************************************************************************
//public class p1463 {
//    //풀이방법: 3으로 나누는 것이 1순위, 2로 나누는 것은 2순위 1을 빼는 것은 3순위이다.
//    //x % 3 을 구하여, 1이 남는다면 -1 연산, 짝수라면 / 2 연산, 3의 배수라면 / 3 연산을 진행한다.
//    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int x = Integer.parseInt(br.readLine());
//        int count = 0; // 연산 횟수를 저장.
//        while(x != 1) {
//            //x가 1이 될 때까지 반복.
//            if(x % 3 == 1) {
//                x--;
//                count++;
//            }
//            else if( x % 3 == 0) {
//                x = x / 3;
//                count++;
//            }
//            else if(x % 2 == 0){
//                x = x / 2;
//                count++;
//            }
//            else {
//                x--;
//                count++;
//            }
//        }
//
//        bw.write(count+"\n");
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}