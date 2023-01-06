package BAEKJOON;

import java.io.*;
import java.util.ArrayList;

public class p1874 {
    //풀이방법 : stack을 arrayList를 이용해서 간단하게 구현한다.(push , pop , getSize 정도만)
    //sequence(수열)를 반복문을 통해 입력받고 stack에서 push pop하면서 비교해본다.

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        MYSTACK stack = new MYSTACK();
        int[] sequence = new int[n];
        StringBuilder sb = new StringBuilder(); // +,-를 저장할 stringbuilder

        for(int i = 0 ; i < n ; i++)
        {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        int index = 0; // 비교할 수열의 index.
        for(int i = 1 ; i <= n ; i++) // 숫자 push하면서 필요한 숫자를 pop하는 과정.
        {
            if(i == 1) // 첫번째 숫자는 무조건 넣어주기.(stack에 push해야 pop을 할 수 있기 때문.)
            {
                stack.push(i);
                sb.append("+");
                continue;
            }

            if(stack.peek() == sequence[index])
            {
                stack.pop();
                index++;
                sb.append("-");
                i--;
                continue;
            }
            stack.push(i);
            sb.append("+");

        }

        //push를 끝냈으니 이제 남은 숫자들을 pop하면서 수열과 다른 숫자가 있는지 검사하는 과정.
        n = stack.getSize(); // stack의 크기만큼 iteration을 하기 위한 변수
        for(int i = 0 ; i < n ; i++)
        {
            if(stack.peek() == sequence[index]) // 남은 숫자들이 수열과 맞다.
            {
                stack.pop();
                index++;
                sb.append("-");
            }
            else // 비교했는데 틀렸다 -> 만들 수 없음.
            {
                sb.setLength(0);// stringbuilder 초기화
                break;
            }
        }



        if(sb.length() == 0) // 만들 수 없는 경우는 그냥 NO를 출력.
        {
            bw.write("NO");
        }
        else // 만들 수 있는 경우
        {
            String answer = sb.toString();
            for(int i = 0 ; i < answer.length() ; i++)
            {
                bw.write(answer.charAt(i)+"\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
class MYSTACK{
    ArrayList<Integer> stack = new ArrayList<>();// stack을 구현할 ArrayList


    void push(int n) // ArrayList에 숫자 저장
    {
        stack.add(n);
    }

    int pop() // ArrayList에서 숫자 꺼내기
    {
       int result = stack.get(stack.size() - 1);
       stack.remove(stack.size() - 1);
       return result;
    }

    int getSize() // ArrayList 크기 반환
    {
        return stack.size();
    }

    int peek() // stack의 제일 위 숫자를 알려주는 함수, 크기가 0일때는 -1을 반환함.
    {
        if(stack.size() == 0)
            return -1;
        else
            return stack.get(stack.size() - 1);
    }

}
