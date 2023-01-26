package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class p10814 {
    //풀이방법: compare 함수를 이용한다.
    //members라는 ArrayList를 만들어서 회원의 정보를 Person 클래스로 저장한다.
    //Person클래스는 나이, 이름, 가입순서를 가진다.
    //compare 함수를 사용해서 앞서 사용한 Person 클래스에서 나이와 가입순서를 비교하여 정렬한다.
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Person> members = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            //Person 객체를 하나 만들어서 ArrayList에 저장한다.
            String[] split = br.readLine().split(" ");
            members.add(new Person(Integer.parseInt(split[0]),split[1],i));
        }

        Collections.sort(members, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                //나이순으로 정렬을 하고, 나이가 같다면 가입 순번으로 정렬.

                
                if (o1.getAge() > o2.getAge()) {
                    //나이를 get함수로 불러와서 비교한다.
                    return 1;
                } else if (o1.getAge() == o2.getAge()) {
                    //나이가 같은경우
                    if (o1.getMemberNum() > o2.getMemberNum()) {
                        //멤버 순서가 빠를수록 먼저 정렬한다.
                        return 1;
                    } else if (o1.getMemberNum() < o2.getMemberNum()) {
                        return -1;
                    } else {
                        return 0;
                    }
                } else {
                    return -1;
                }
            }
        });

        for(int i = 0 ; i < members.size() ; i++) {
            bw.write(members.get(i).getAge()+" "+members.get(i).getName()+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Person {
    private int age;
    private String name;
    private int memberNum;

    public Person(int age, String name, int memberNum) {
        this.age = age;
        this.name = name;
        this.memberNum = memberNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }
}