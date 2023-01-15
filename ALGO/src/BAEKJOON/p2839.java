package BAEKJOON;

import java.io.*;

public class p2839 {
    //풀이방법: 3kg * x + 5kg * y = N kg 이라는 수식을 사용한다.
    //반복문을 사용하여 y를 0부터 1씩 증가시키고 이때에 x가 얼마인지를 확인한다.
    //결과값을 계속 최솟값으로 갱신해서 마지막 반복이 끝나면 그 값을 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int minResult = Integer.MAX_VALUE;
        int x = (n / 3) + 1;
        int y = (n / 5) + 1;

        for(int i = 0 ; i <= y ; i++) {
            //y의 값이 최솟값일때부터 최댓값까지
            for(int j = 0 ; j <= x ; j++) {
                //x의 값을 변화시키면서 만족하는 결과값을 찾는다.
                int temp = (i*5 + j*3);
                if(n == temp) {
                    if(minResult > i + j) {
                        minResult = i + j;
                    }
                    break;
                }
                else if(n < temp) {
                    // temp 값이 n보다 커진다면 고려할 필요가 없기에 break
                    break;
                }
            }
        }
        if(minResult == Integer.MAX_VALUE) {
            //조건에 부합하는 값을 찾지 못한 경우.
            minResult = -1;
        }

        bw.write(minResult+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
