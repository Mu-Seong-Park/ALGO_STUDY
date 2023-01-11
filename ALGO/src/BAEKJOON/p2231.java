package BAEKJOON;

import java.io.*;

public class p2231 {
    //풀이방법: 입력받은 n에서 자릿수의 개수만큼 9를 빼준다.
    //이 숫자보다 작을 수가 없기 때문에 위의 뺀 값에서부터 N까지 숫자를 계속 더해서 찾아나간다.
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 입력받은 자연수.

        int x = 0; // n의 생성자, 0이면 생성자가 없는 경우이고 생성자가 존재한다면 그 값을 저장.

        int digitNum = 0; // n이 몇자리 수인지 저장.

        for(int i = 7 ; i >= 0 ; i--) {
            //n의 자리수를 계산하는 과정. (n의 최댓값은 1,000,000)
            int temp = (int)(Math.pow(10,i));
            if(n / temp != 0) {
                digitNum = i + 1;
                break;
            }
        }


        for(int i = n - (digitNum * 9); i < n; i++) {
            int temp = 0; // 각 자리수를 더한 값을 저장하기 위한 변수.
            int currentNum = i; // 가능한 가장 작은 수부터 저장해서 현재 어떤 값인지 알기 위한 변수.
            while(currentNum != 0){
            //각 자리수를 더하는 과정.
                temp += currentNum % 10;
                currentNum /= 10;
                
            }


            if(temp + i == n) {
                //생성자를 찾은 경우.
                x = i;
                break;
            }
        }
        

        bw.write(x+"\n");


        bw.flush();
        bw.close();
        br.close();
    }
}
//틀린풀이 ******************************************************

//풀이방법: 입력받은 숫자의 자리수를 구하고, 자리수만큼 배열을 생성한다.
//가장 높은 자리수부터 차례대로 1을 대입하여 숫자를 구한다.
//일의 자리에서 9까지 계산한 뒤에 생성자가 없다면 십의 자리에 1을 더해서 2를 만들어 생성자를 찾는다.
//위의 과정을 모든 자리수에 적용하여 9로 모든 자리가 가득찰 때까지 반복한다.

//    int x = -1; // n의 생성자, 0이면 생성자가 없는 경우이고 생성자가 존재한다면 그 값을 저장.
//
//    int digitNum = 0; // n이 몇자리 수인지 저장.
//
//        for(int i = 7 ; i >= 0 ; i--)
//                {
//                //n의 자리수를 계산하는 과정. (n의 최댓값은 1,000,000)
//                int temp = (int)(Math.pow(10,i));
//                if(n / temp != 0)
//                {
//                digitNum = i + 1;
//                break;
//                }
//                }
//
//                int[] num = new int[digitNum];
//
//                for(int i = 0 ; i < digitNum ; i++)
//        {
//        //n의 생성자, x의 자리수를 모두 100....으로 초기화하는 과정.
//        if(i == digitNum-1)
//        {
//        num[digitNum-1] =1;
//        }
//        else
//        {
//        num[i] = 0;
//        }
//        }
//
//
//        if (n>=20){
//        while(x == -1) {
//        //999..99의 형태가 될때까지 반복.
//        int temp = 0;//임시로 x를 더하고 자리수를 더할 변수.
//        for(int i = 0 ; i < digitNum ; i++) {
//        // 각 자리수를 모두 더하고 x를 더해서 n이 되는지 판별.
//        temp += ((int)(Math.pow(10,i))) * num[i];
//        temp += num[i];
//        }
//
//        if(temp == n){
//        //n을 찾은경우
//        temp = 0;
//        for(int i = 0 ; i < digitNum ; i++) {
//        temp += ((int)(Math.pow(10,i))) * num[i];
//        }
//        x = temp;
//        }
//        else {
//        //n을 찾지 못한 경우, 자리수를 +1.
//        for(int i = 0 ; i < digitNum ; i++) {
//        if(num[i] != 9) {
//        //자리수가 9가 아닌 경우, 그 자리수에 1을 더하고 끝.
//        num[i]++;
//        break;
//        }
//        else {
//        //자리수가 9인 경우를 만났으니 그 자리수를 0으로 만들고, 다음 자리수가 1이 증가하도록 한다.
//        num[i] = 0;
//        }
//        }
//        if(num[digitNum-1] == 0) {
//        //자리수가 9인 경우 그 자리수를 0으로 만들었는데,
//        //제일 큰 자리수가 0이 되면 알맞은 값을 의미이므로 생성자가 없다고 판별.
//        x = 0;
//        }
//
//        }
//
//        }
//        }
//        else {
//        //1x의 형태나 한자리수의 경우를 따로 생각해주어야 함.
//        if(n % 2 == 0) {
//        //짝수의 경우 2로 나눈 값이 생성자
//        x = n / 2;
//        }
//        else {
//        if (digitNum == 1) {
//        //홀수의 경우, 한자리수는 0
//        x = 0;
//        }
//        else {
//        //2자리 이상은 있을 수 있음.
//        while(x == -1) {
//        //999..99의 형태가 될때까지 반복.
//        int temp = 0;//임시로 x를 더하고 자리수를 더할 변수.
//        for(int i = 0 ; i < digitNum ; i++) {
//        // 각 자리수를 모두 더하고 x를 더해서 n이 되는지 판별.
//        temp += ((int)(Math.pow(10,i))) * num[i];
//        temp += num[i];
//        }
//
//        if(temp == n){
//        //n을 찾은경우
//        temp = 0;
//        for(int i = 0 ; i < digitNum ; i++) {
//        temp += ((int)(Math.pow(10,i))) * num[i];
//        }
//        x = temp;
//        }
//        else {
//        //n을 찾지 못한 경우, 자리수를 +1.
//        for(int i = 0 ; i < digitNum ; i++) {
//        if(num[i] != 9) {
//        //자리수가 9가 아닌 경우, 그 자리수에 1을 더하고 끝.
//        num[i]++;
//        break;
//        }
//        else {
//        //자리수가 9인 경우를 만났으니 그 자리수를 0으로 만들고, 다음 자리수가 1이 증가하도록 한다.
//        num[i] = 0;
//        }
//        }
//        if(num[digitNum-1] == 0) {
//        //자리수가 9인 경우 그 자리수를 0으로 만들었는데,
//        //제일 큰 자리수가 0이 되면 알맞은 값을 의미이므로 생성자가 없다고 판별.
//        x = 0;
//        }
//
//        }
//
//        }
//        }
//        }
//        }