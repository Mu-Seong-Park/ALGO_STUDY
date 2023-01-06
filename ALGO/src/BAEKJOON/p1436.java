package BAEKJOON;

import java.io.*;

public class p1436 {
    // 아이디어 : 모든 수를 오름차순으로 정리하여 666을 포함하는 수는 True를, 아니면 False를 저장하는 boolean 타입의
    //배열을 만든다.
    // -> 모든 수를 저장하려니 메모리 초과 에러가 발생
    // 해결 방법 : 순차적으로 666이 들어가는 수를 발견하면 그 때 배열에 넣는다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[10000]; //1만번째 666수까지 저장
        String temp = "";
        int index = 0; // num의 index로 사용할 변수.
        for(int i = 0 ; i < Integer.MAX_VALUE ; i++)
        {
            if(index == 10000) // 1만번째를 넘어서면 break
            {
                break;
            }
            temp = Integer.toString(i);
            if(temp.indexOf("666") == -1)//666을 가지고 있는지 판별.
            {
                continue;
            }
            else
            {
                num[index] = i;
                index++;
            }

        }



        bw.write(num[n - 1]+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
