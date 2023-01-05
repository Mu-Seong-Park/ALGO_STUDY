package BAEKJOON;

import java.io.*;

public class p1259 //펠린드롬인 수 찾기
    //조건제어 : string으로 입력을 받은 뒤에 0이 나올때까지 while문을 실행한다.
    //아이디어 : string의 길이를 측정한 뒤에 짝수와 홀수의 길이일 때 나누어서 대칭점의 수를 char형으로 뽑아내어 비교한다.
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true)
        {
            String s = br.readLine();

            if(s.charAt(0) == '0') //0일때 break
            {
                break;
            }

            boolean answer = true; // 펠린드롬인지 아닌지 판별하는 변수
            if(s.length() % 2 == 0)//길이가 짝수의 경우
            {
                if(s.length() == 1) // 한자리수는 break 예외처리.
                {
                    break;
                }
                for(int i = 0 ; i < s.length() / 2 ; i++)
                {
                    if(s.charAt(i) != s.charAt((s.length() - 1) - i))
                    {
                        answer = false;
                        break;
                    }
                }
            }
            else//길이가 홀수의 경우
            {

                for(int i = 0 ; i < (s.length() - 1) / 2 ; i++)
                {
                    if(s.charAt(i) != s.charAt((s.length() - 1) - i))
                    {
                        answer = false;
                        break;
                    }
                }
            }

            if(answer == false)
            {
                bw.write("no\n");
            }
            else
            {
                bw.write("yes\n");
            }
            bw.flush();
        }



        bw.close();
        br.close();

    }
}
