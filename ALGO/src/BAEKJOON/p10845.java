package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p10845 {
    //문제에서 주어진 대로 queue를 구현한다.
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MYQUEUE myqueue = new MYQUEUE();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++)
        {
            String input = br.readLine(); // 명령을 입력 받는다.
            StringTokenizer st = new StringTokenizer(input," "); // 입력받은 명령을 공백을 기준으로 자른다.

            String command = "";
            int result = -5;
            command = st.nextToken(); // 명령을 저장하고 아래의 조건문에서 어떤 명령인지 판별한다.

            if(command.equals("push")) // string을 비교할 때는 equals를 활용, ==관계연산자 사용 X
            {
                myqueue.push(Integer.parseInt(st.nextToken()));
            }
            else if (command.equals("pop")) {
                result = myqueue.pop();
                bw.write(result+"\n");
            }
            else if (command.equals("size")) {
                result = myqueue.size();
                bw.write(result+"\n");
            }
            else if (command.equals("empty")) {
                result = myqueue.isEmpty();
                bw.write(result+"\n");
            }
            else if (command.equals("front")) {
                result = myqueue.front();
                bw.write(result+"\n");
            }
            else if (command.equals("back")) {
                result = myqueue.back();
                bw.write(result+"\n");
            }

            bw.flush();
        }

        bw.close();
        br.close();
    }
}

class MYQUEUE {
    //ArrayList를 사용해서 큐를 구현
    ArrayList<Integer> queue = new ArrayList<>();

    void push(int x){ // 숫자 삽입
        queue.add(x);
    }

    int pop(){ // 숫자를 pop, 선입선출.
        if(queue.isEmpty() == true)
        {
            return -1;
        }
        else
        {
            int result = queue.get(0);
            queue.remove(0);
            return result;
        }

    }

    int size(){ // queue의 크기 반환
        return queue.size();
    }

    int isEmpty(){// 큐가 비었는지 검사
        if(queue.isEmpty() == true)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    int front(){ // 큐의 가장 앞 숫자를 반환

        if(queue.isEmpty() == true)
        {
            return -1;
        }
        else
        {
            return queue.get(0);
        }
    }

    int back(){ // 큐의 마지막 숫자 반환

        if(queue.isEmpty() == true)
        {
            return -1;
        }
        else
        {
            return queue.get(queue.size()-1);
        }
    }
}
