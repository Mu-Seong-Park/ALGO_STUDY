package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class MyQ {

    ArrayList<MyData> queue = new ArrayList<>();

    void push(MyData myData) { // queue에 데이터 저장.
        queue.add(myData);
    }

    MyData peek() { // 제일 위의 데이터를 확인.

        if(queue.isEmpty() == false)
        {
            MyData result = queue.get(0);
            return result;
        }
        else { // queue에 데이터가 없는데 찾으려는 경우 -1 -1 로 이루어진 데이터쌍을 반환한다.
            MyData myData = new MyData(-1, -1);
            return myData;
        }
    }

    MyData pop() {

        if(queue.isEmpty() == false)
        {
            MyData result = queue.get(0);
            queue.remove(0);
            return result;
        }
        else { // queue에 데이터가 없는데 찾으려는 경우 -1 -1 로 이루어진 데이터쌍을 반환한다.
            MyData myData = new MyData(-1, -1);
            return myData;
        }
    }

    int size(){
        // queue의 크기 반환

        return queue.size();
    }


}

class MyData {

    private int title; // 입력받는 순서
    private int priority; // 문서의 중요도

    MyData (int title, int priority) // 생성자를 통해서 문서의 제목과 중요도를 초기화.
    {
        this.title = title;
        this.priority = priority;
    }


    //MyData에 저장된 값을 확인하는 getter
    int getTitle() {
        return this.title;
    }

    int getPriority(){
        return this.priority;
    }

    void setPriority(int x){
        this.priority = x;
    }

    void setTitle(int x){
        this.title = x;
    }

}

public class p1966 {
    // 문제에서 주어진 대로 ArrayList 이용해서 큐(FIFO)를 구현한다.
    // Queue에 저장할 때 내가 지정한 새로운 데이터 타입으로 저장한다.
    // 이 데이터 타입은 문서의 중요도와 입력받는 순서, 2개의 데이터 쌍으로 이루어져 있다.
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // test case의 개수

        for(int i = 0 ; i < n ; i++) // test case만큼 반복.
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            MyQ myQueue = new MyQ(); // 큐 객체 생성.

            int dataCount = Integer.parseInt(st.nextToken()); // 입력받을 데이터 개수
            int targetData = Integer.parseInt(st.nextToken()); // 순서가 궁금한 데이터
            MyData biggestPriorityData = new MyData(-1,-1) ; // 가장 중요도가 큰 data를 저장할 변수

            StringTokenizer st2 = new StringTokenizer(br.readLine()); // 중요도를 입력받을 tokenizer
            for(int j = 0 ; j < dataCount ; j++)
            {
                MyData myData = new MyData(j,Integer.parseInt(st2.nextToken()));
                myQueue.push(myData);

                if(myData.getPriority() >= biggestPriorityData.getPriority())
                {
                    //가장 뒤에 있는 중요도가 높은 데이터를 변수에 저장.
                    biggestPriorityData.setPriority(myData.getPriority());
                    biggestPriorityData.setTitle(myData.getTitle());

                }

            }
            for(int j = 0 ; j < dataCount ; j++)
            {
                if(biggestPriorityData.getPriority() > myQueue.peek().getPriority()) {
                    // 현재 확인하는 데이터의 중요도가 더 낮은 경우 제일 뒤로 보내고 차례를 건너뛴다.

                    MyData temp = myQueue.pop();
                    myQueue.push(temp);
                    j--;
                }
                else if(biggestPriorityData.getPriority() == myQueue.peek().getPriority()){
                    // 가장 높은 데이터와 중요도가 같은 경우

                    MyData temp = myQueue.pop();

                    if(temp.getTitle() == targetData)
                    {
                        //원하는 데이터를 찾은 경우 출력하고 반복문을 종료한다.

                        bw.write((j+1)+"\n");
                        break;
                    }
                    else if(temp.getTitle() == biggestPriorityData.getTitle()) {
                        // 다음으로 중요도가 높고 뒤에 있는 데이터로 변경해준다.
                        int iter = myQueue.size();

                        MyData newBiggest = new MyData(-1,-1);
                        for(int l = 0 ; l < iter ; l++) {
                            // queue의 size만큼 검색해보면서 중요도를 확인한다.
                            // queue를 다 pop 하고 다시 push 해서 원래 상태로 만들어준다.


                            MyData temp2 = myQueue.pop();

                            if(temp2.getPriority() >= newBiggest.getPriority()) {
                                //가장 뒤에 있는 중요도가 높은 데이터를 변수에 저장.
                                newBiggest.setPriority(temp2.getPriority());
                                newBiggest.setTitle(temp2.getTitle());
                            }

                            myQueue.push(temp2);
                            if(l == iter - 1) {
                                // 가장 뒤에 있는 중요도가 높은 데이터를 실제 사용할 변수에 저장한다.
                                biggestPriorityData.setPriority(newBiggest.getPriority());
                                biggestPriorityData.setTitle(newBiggest.getTitle());
                            }
                        }

                    }
                }

            }




            bw.flush();

        }

        bw.flush();
        bw.close();
        br.close();
    }
}



