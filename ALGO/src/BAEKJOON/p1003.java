package BAEKJOON;

import java.io.*;

public class p1003 {
    //풀이방법: 전역변수 2개를 만들어 1과 0이 호출될 때마다 +1 연산을 반복한다.
    //재귀로 문제를 풀려고 하니까 시간초과 발생 -> DP를 이용해서 문제해결
    //메모이제이션을 사용하기 위해서 전역변수로 결과값을 저장하는 배열을 선언한다.

    static int[] countOneArray;
    static int[] countZeroArray;

    static int countOne;
    static int countZero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < testCase; test_case++) {

            //피보나치 함수에 사용할 n을 저장한다.
            int n = Integer.parseInt(br.readLine());
            //0과 1이 얼마나 호출되는지 저장할 전역변수를 초기화
            countOneArray = new int[n+1];
            countZeroArray = new int[n+1];
            countOne = 0;
            countZero = 0;
            //피보나치 함수 호출
            fibonacci(n);
            bw.write(countZeroArray[n]+" "+countOneArray[n]+"\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }

    static int fibonacci(int n) {
        if (n == 0) {
            countZero++;
            return 0;
        } else if (n == 1) {
            countOne++;
            return 1;
        } else {
            int answer = -1;
            if(countOneArray[n] == 0 && countZeroArray[n] == 0) {
                //호출되는 횟수가 저장되어 있지 않은 경우
                System.out.println(n+": 현재 n");
                answer = fibonacci(n - 1) + fibonacci(n - 2);
                countOneArray[n] = countOne;
                countZeroArray[n] = countZero;
                System.out.println(countOne+": 현재 1을 센 횟수");
                System.out.println(countZero+": 현재 0을 센 횟수");
            }
            else {
                //저장되어 있는 경우.
                for(int i = 0 ; i < n ; i++) {
                    countOneArray[n] += countOneArray[i];
                    countZeroArray[n] += countZeroArray[i];
                }
                countZeroArray[n] = countZeroArray[n] - 1;
            }
            return answer;
        }
    }
}
