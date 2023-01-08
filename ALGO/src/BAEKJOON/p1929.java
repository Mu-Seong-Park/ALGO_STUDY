package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1929 {
    //풀이방법: 모든 수의 배수들을 모두 지우면서 마지막에 남는 수를 확인한다.
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Boolean> num = new ArrayList<>(n+1);

        if(n >= 2)
        {
            num.add(false); // 0은 n과 m의 범주에 속하지 않으니 false로 처리한다.
            num.add(false); // 1은 소수도 합성수도 아니다.
            num.add(true); // 2는 유일한 짝수인 소수이기에 따로 저장한다.
            for(int i = 0 ; i < n+1 ; i++) {
                //모든 수를 모은 배열, num을 초기화
                if(i >= 3) {
                    if (i % 2 == 0) {
                        //짝수는 2를 제외하고 무조건 2의 배수.
                        num.add(i,false);
                    } else {
                        //홀수는 일단 true로 초기화 한다.
                        num.add(i,true);
                    }
                }
            }



            for(int i = 2 ; (i * i) <= n ; i++)
            {
                if(num.get(i) == true)
                {
                    for(int j = i * i ; j <= n ; j += i)
                    {
                        num.set(j,false);
                    }
                }
            }
        }
        else
        {
            num.add(false); // 0은 n과 m의 범주에 속하지 않으니 false로 처리한다.
            num.add(false); // 1은 소수도 합성수도 아니다.
        }





        for(int i = m ; i <= n ; i++) {
            if(num.get(i))
            {
                bw.write(i+"\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
