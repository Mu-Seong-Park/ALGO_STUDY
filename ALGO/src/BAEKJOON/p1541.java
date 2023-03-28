package BAEKJOON;

import java.io.*;
import java.util.ArrayList;

public class p1541 {
    public static void main(String[] args) throws IOException {
        //문제풀이
        // 1. String을 StringBuilder나 String 등으로 한글자씩 잘라서 붙이다가 +,-를 발견하면 숫자배열에 저장.
        // 2. 위 과정을 진행하면서, +나 -또한 부호 배열에 저장.
        // 3. 부호 배열을 탐색하면서 -를 만나면 다음 -가 나올 때까지 더해준 뒤에 그 값을 첫번째 숫자에서 빼준다.



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String expression = br.readLine(); // 수식 저장
        ArrayList<String> sign = new ArrayList<>(); //부호 저장
        ArrayList<Integer> nums = new ArrayList<>(); //숫자 저장

        String temp = ""; //숫자를 만들어서 저장할 임시 변수.
        for(int i = 0 ; i < expression.length() ; i++) {

            //문자가 +,- 가 아닌 경우 숫자를 저장하기 위해 temp에 한자리씩 저장한다.
            if(expression.charAt(i) != '+' && expression.charAt(i) != '-') {
                temp = temp+expression.charAt(i);
            }

            //+나 -를 만나는 경우, 이때까지 이어왔던 temp를 저장하고 temp를 초기화 한다.
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign.add(Character.toString(expression.charAt(i)));
                nums.add(Integer.parseInt(temp));
                temp = "";
            }

            // 마지막 숫자는 +,-를 만날 수 없으므로 수동 저장.
            if(i == expression.length() - 1) {
                nums.add(Integer.parseInt(temp));
            }
        }

        //수식의 시작은 무조건 숫자이므로, 처음 숫자를 결과값에 미리 더해서 초기화시켜준다.
        int result = nums.get(0);

        //minus를 만나는지 아닌지를 확인하기 위함.
        boolean minusCheck = false;
        int index = 1;
        int minusTemp = 0;
        for(int i = 0 ; i < sign.size() ; i++) {

            //다음 마이너스를 만난 경우, 괄호를 닫기 위해서 result에 얻은 값을 빼고, minusTemp를 0으로 초기화하고 다음 뺄 숫자를 minusTemp에 더한다.
            if(sign.get(i).equals("-") && minusCheck == true) {
                minusCheck = true;
                result -= minusTemp;
                minusTemp = 0;
                minusTemp += nums.get(index);
                index++;
            }

            //처음 마이너스를 만난 경우, 마이너스값을 크게 하기 위해 값을 temp에 더해준다.
            if(sign.get(i).equals("-") && !minusCheck) {
                minusCheck = true;
                minusTemp += nums.get(index);
                index++;
            }

            //-를 만난 적이 없다면 더해준다.
            if(minusCheck == false) {
                result += nums.get(index);
                index++;

            }

            if(minusCheck && sign.get(i).equals("+")) {

                minusTemp += nums.get(index);
                index++;
            }
        }

        result -= minusTemp;

        bw.write(result+"\n");


        bw.flush();
        br.close();
        bw.close();
    }
}
