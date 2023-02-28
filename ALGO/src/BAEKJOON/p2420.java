package BAEKJOON;
import java.io.*;
import java.math.*;

public class p2420 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");
        BigInteger n = new BigInteger(nums[0]);
        BigInteger m = new BigInteger(nums[1]);


        int result = n.subtract(m).intValue();

        result = Math.abs(result);

        bw.write(result+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
