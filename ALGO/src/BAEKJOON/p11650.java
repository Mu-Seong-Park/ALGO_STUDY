package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p11650 {
    //좌표 x,y로 이루어진 ArrayList를 만들어서 collections의 timsort를 활용한다.

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<MYPOINT> point = new ArrayList<>();

        for(int i = 0; i < n ; i++) // ArrayList에 입력받은 좌표 값들을 저장.
        {
            StringTokenizer st =new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            MYPOINT myPoint = new MYPOINT(x,y);
            point.add(myPoint);
        }

        Collections.sort(point, new Comparator<MYPOINT>() {// 람다식을 통해서 오름차순으로 정렬하기.
            @Override
            public int compare(MYPOINT o1, MYPOINT o2) {
                if(o1.x > o2.x)
                {
                    return 1;
                }
                else if(o1.x == o2.x) // 둘의 x좌표가 같은 경우 y를 비죠.
                {
                   return o1.compareTo(o2);
                }
                else
                {
                    return -1;
                }

            }
        });

        for(int i =0 ; i < n ; i++)
        {
            bw.write(point.get(i).x+" "+point.get(i).y+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


}

class MYPOINT implements Comparable<MYPOINT>{
    // 나만의 좌표 설정.
    //compareTo를 사용하기 위해 Comparable 인터페이스를 구현.

    int x;
    int y;

    MYPOINT(int x, int y) // 생성자를 통해서 x,y를 입력받는다.
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(MYPOINT o) {
        return this.y - o.y;
    }
}