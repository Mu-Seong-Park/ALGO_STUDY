package BAEKJOON;

import java.awt.*;
import java.io.*;
import java.util.function.IntBinaryOperator;

public class p15650 {
    //문제풀이
    // 1.조합(combination)을 이용하여 만들 수 있는 수열의 갯수를 구한다,
    // 2. 1부터 n까지 반복문을 수행하면서,
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nums = br.readLine().split(" ");

        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        int combi = factorial()


        br.close();
        bw.flush();
        bw.close();
    }

    public static int factorial(int num) {
        if(num == 1) {
            return 1;
        }

        return num * factorial(num - 1);
    }
}
