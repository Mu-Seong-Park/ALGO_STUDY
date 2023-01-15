package BAEKJOON;

import java.io.*;

public class p2609 {
    //풀이방법: 두 개의 자연수를 n,m에 각각 저장한다.
    //유클리드 호제법을 사용하여 최대공약수를 구한다.
    //유클리드 호제법이란? n>=m일 때 최대공약수를 (n,m)이라 하면 (n,m) = (m,r)이 성립한다. (여기서 r은 n을 m으로 나눈 나머지)
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");

        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        int r = n % m; // 나머지를 저장.
        int gcd = 0; // 최대공약수
        int lcm = 0; // 최소공배수
        int x = m;
        int temp = 0;
        if(r != 0){
            while(true){
                temp = r;
                r = x % r;
                x = temp;
                if(r == 0){
                    //최대공약수를 찾은 경우.
                    gcd = x;
                    break;
                }
            }
            lcm = (n / gcd) * (m / gcd) * gcd;
        }
        else if (n == m){
            //n과 m이 같은 경우 r은 0이 나오기 때문에 에러발생 -> 예외처리
            gcd = n;
            lcm = n;

        }
        else {
            //n이 m의 배수인 경우.
            gcd = m;
            lcm = n;
        }

        bw.write(gcd+"\n"+lcm);


        bw.flush();
        bw.close();
        br.close();
    }
}
