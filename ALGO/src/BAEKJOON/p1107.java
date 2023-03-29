package BAEKJOON;

import java.util.*;
public class p1107 {
    //참고 : https://moonsbeen.tistory.com/64
    //내가 너무 어렵게 생각했음...
    //근사값을 안 만들어도, 모든 값에 대해 움직인 값을 저장하고 비교하면 되는 것이었음.

    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);

        int target = scan.nextInt();
        int m = scan.nextInt();

        boolean[] broken = new boolean[10];
        for(int i = 0; i < m; i++) {
            int n = scan.nextInt();
            broken[n] = true;
        }

        int result = Math.abs(target - 100); //초기값 설정
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for(int j = 0; j < len; j++) {
                if(broken[str.charAt(j) - '0']) { //고장난 버튼을 눌러야 하면
                    isBreak = true;
                    break; //더 이상 탐색하지 않고 빠져나온다.
                }
            }
            if(!isBreak) { //i를 누를때 고장난 버튼을 누르지 않는다면
                int min = Math.abs(target - i) + len; //i를 누른 후(len) target까지 이동하는 횟수(target - i)
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}


//package BAEKJOON;
//
//import java.io.*;
//
//public class p1107 {
//    //문제풀이
//    //1. 현재 채널인 100번에서 +,-로 움직여 목표 채널로 이동하는 방법
//    //2. 목표 채널보다 작은 수 중에서 가장 가까운 수에서 이동하는 방법
//    //3. 목표 채널보다 큰 수 중에서 가장 가까운 수에서 이동하는 방법
//    //4. 위의 4가지를 비교해서 움직임이 가장 작은 방법을 채택한다.
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String targetCH = br.readLine(); // String 형태의 목표채널 번호
//        int n = Integer.parseInt(targetCH);// 목표 채널 번호
//        int m = Integer.parseInt(br.readLine());// 고장난 리모컨 버튼의 개수
//
//        int[] breakDown = new int[m];// 고장난 번호를 저장할 배열
//        String[] nums = br.readLine().split(" ");
//
//        for(int i = 0 ; i < m ; i++) {
//            breakDown[i] = Integer.parseInt(nums[i]);
//        }
//
//        boolean[] check = new boolean[targetCH.length()]; //목표 채널 자릿수에 고장난 숫자가 있는지 확인
//        for(int i = 0 ; i < targetCH.length() ; i++) {
//            for(int j = 0 ; j < m ; j++) {
//                if(Character.toString(targetCH.charAt(i)).equals(nums[j])) {
//                    check[i] = true;
//                    break;
//                }
//            }
//        }
//
//        //100번에서 움직이는 방법.
//        int curerntCH = 100;
//
//        int moveCH = -1;
//        if(n >= curerntCH) {
//            moveCH = n - curerntCH;
//        } else {
//            moveCH = curerntCH - n;
//        }
//
//        //목표보다 작은 채널중에 가장 큰 채널을 구하는 과정.
//        String smaller = "";
//        for(int i = 0 ; i < targetCH.length() ; i++) {
//            if(!check[i]) {
//                //목표 채널의 숫자가 고장나지 않은 경우
//                smaller= smaller+targetCH.charAt(i);
//            } else {
//                //목표채널의 숫자가 고장났으면, 그 숫자보다 1작은 숫자에서 시작하여 0까지 고장나지 않은 숫자를 찾는다.
//                int temp = Character.getNumericValue(targetCH.charAt(i)) - 1;
//                for(int k = 0 ; k < Character.getNumericValue(targetCH.charAt(i)) ; k++) {
//                    for(int j = 0 ;j < m ; j++) {
//                        if(k == breakDown[j]) {
//                            temp--;
//                        }
//                    }
//                }
//                if(temp < 0 && i == targetCH.length() - 1) {
//                    //temp가 0보다 작으면, 목표채널보다 작은 크기의 숫자를 만드는 것이 불가능하므로 퇴장.
//                    smaller = "-1";
//                    break;
//                }
//            }
//        }
//        int smallerMove = 0;
//
//        if(!smaller.equals("-1")) {
//            //만들 수 있는 숫자면, 각 숫자 자릿수를 누르는 횟수 + 채널 변경을 위한 횟수를 더한다.
//            smallerMove = n - Integer.parseInt(smaller);
//            smallerMove += smaller.length();
//        } else {
//            //만들 수 없다면 Integer에서 가장 큰 숫자를 넣어버려서, moveCH가 선택되거나 BiggerMove가 선택될 수 있도록 한다.
//            smallerMove = Integer.MAX_VALUE;
//        }
//
//        //목표보다 큰 채널중에 가장 작은 채널을 구하는 과정.
//        String bigger = "";
//        for(int i = 0 ; i < targetCH.length() ; i++) {
//            if(!check[i]) {
//                //목표 채널의 숫자가 고장나지 않은 경우
//                bigger= bigger+targetCH.charAt(i);
//            } else {
//                //목표채널의 숫자가 고장났으면, 그 숫자보다 1 큰 숫자에서 시작하여 9까지 고장나지 않은 숫자를 찾는다.
//                int temp = Character.getNumericValue(targetCH.charAt(i)) + 1;
//                for(int k = 9 ; k >= Character.getNumericValue(targetCH.charAt(i)) ; k--) {
//                    for(int j = 0 ;j < m ; j++) {
//                        if(k == breakDown[j]) {
//                            temp++;
//                        }
//                    }
//                }
//                if(temp > 9 && i == targetCH.length() - 1) {
//                    //temp가 9보다 크면, 목표채널보다 큰 크기의 숫자를 만드는 것이 불가능하므로 퇴장.
//                    bigger = "-1";
//                    break;
//                }
//            }
//        }
//
//        int biggerMove = 0;
//
//        if(!bigger.equals("-1")) {
//            biggerMove = Integer.parseInt(bigger) - n;
//            biggerMove += bigger.length();
//        } else {
//            biggerMove = Integer.MAX_VALUE;
//        }
//
//        int result = Math.min(biggerMove,Math.min(smallerMove,moveCH));
//
//        bw.write(result+"\n");
//
//
//
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//}
