package BAEKJOON;

import java.io.*;

public class p17218 {
    //풀이방법: s1,s2 두 문자열을 입력받는다.
    //완전탐색을 이용하되,
    //백트래킹을 이용해서 정답에 가까운 문자열만 탐색할 수 있도록 한다.

    static int[][] alphabetLength;
    static String s1;
    static String s2;
    static int[][] back = new int[41][41];
    static int[][] alpha = new int [41][41];
    static char[] str1 = new char[41];
    static char[] str2 = new char[41];
    static String answer = "";

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s1 = br.readLine();
        s2 = br.readLine();

        int m = s1.length();
        int n = s2.length();


        for (int i = 0; i < s1.length(); i++) {
            str1[i+1] = s1.charAt(i);
        }

        for (int i = 0; i < s2.length(); i++) {
            str2[i + 1] = s2.charAt(i);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1[j] == str2[i]) {
                    alpha[i][j] = alpha[i-1][j-1]+ 1;
                    back[i][j] = 3; //왼쪽위에
                }
                else {
                    alpha[i][j] = Math.max(alpha[i - 1][j], alpha[i][j - 1]);
                    int up = alpha[i - 1][j];
                    int left = alpha[i][j - 1];

                    if (up == left || left > up) back[i][j] = 1; //왼쪽
                    else if (up > left) back[i][j] = 2; //위쪽

                }
            }
        }
        backtracking(n, m);

        StringBuffer sb = new StringBuffer(answer);
        String reverse = sb.reverse().toString();
        bw.write(reverse+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void backtracking(int x, int y) {
        //백트래킹을 수행하는 함수.

        if (x <= 0 || y <= 0) return;

        if (back[x][y] == 1) backtracking(x, y - 1);
        else if (back[x][y] == 2) backtracking(x - 1, y);
        else if (back[x][y] == 3) {
            answer+=str2[x];
            backtracking(x - 1, y - 1);
        }

    }
}

//아래의 풀이는 틀렸다, 같은 문자라도 순서에 따라 만들어지는 문자열이 다르기 때문이다.
//s1의 첫번째 char부터 문자열을 쌓아가면서 비밀번호를 만들어 s2와 비교한다.
//위의 과정을 재귀로 구현하면서 최댓값을 계속 갱신한다.
//위의 과정에서 하나의 char로 시작했을 때, 가질 수 있는 문자열의 길이가 나올 것이다.
//이 부분을 저장하면 다음에 같은 문자가 나왔을 때, 계산이 필요한지 아닌지 알 수 있다.


////17218 비밀번호 만들기
//public class Main {
//
//    public static void main(String[] args)throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String A = br.readLine();
//        String B = br.readLine();
//        int Alen = A.length();
//        int Blen = B.length();
//        String[][] dp = new String [Alen][Blen];
//        for(int i = 0; i<Alen; i++){
//            for(int j = 0; j<Blen; j++)
//                dp[i][j] = "";
//        }
//        boolean f = false;
//        for(int i = 0; i<Alen; i++){
//            if(A.charAt(i) == B.charAt(0) || f) {
//                f = true;
//                dp[i][0] += B.charAt(0);
//            }
//        }
//        f = false;
//        for(int i = 0; i<Blen; i++){
//            if(B.charAt(i) == A.charAt(0) || f) {
//                f = true;
//                dp[0][i] += A.charAt(0);
//            }
//        }
//        for(int i = 1; i<Alen; i++) {
//            for(int j = 1; j<Blen; j++) {
//                if(A.charAt(i) == B.charAt(j))
//                    dp[i][j] = dp[i-1][j-1] + B.charAt(j);
//                else {
//                    if(dp[i-1][j].length() < dp[i][j-1].length())
//                        dp[i][j] = dp[i][j-1];
//                    else
//                        dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        System.out.println(dp[Alen-1][Blen-1]);
//    }
//}