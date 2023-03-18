package BAEKJOON;

import java.io.*;
import java.util.ArrayList;

public class p1766 {
    //문제 조건 : 문제의 수 n은 32000 이하 값.
    //먼저 푸는 것이 좋은 (우선 순위가 높은) 문제 정보 개수 m은 10만 이하의 자연수.
    //m개의 줄에서 주어지는 정보는 순서쌍이 A B 일 때, A문제가 B문제보다 먼저 풀어야 한다는 의미.
    //n개의 문제는 숫자가 작을수록 풀기 쉬운 문제이고 위의 정보 순서쌍이 주어지지 않은 문제라면
    //작은 숫자부터 해결해야 한다.

    static ArrayList<Integer> quizbook;
    static int[] quiz;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        quiz = new int[n];
        quizbook = new ArrayList<>(m);
        for(int testCase = 0 ; testCase < m ; testCase++) {
            String[] nums = br.readLine().split(" ");
            quiz[Integer.parseInt(nums[1])]++;
        }

        for(int i = 0 ; i < n ; i++) {

        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void insert(int quiz) {

    }

    static int delete() {

        return 1;
    }
}

//
//    /**
//     * insert는 최소 힙을 구현하는 방식으로 설정한다.
//     * insert를 통헤서 먼저 풀어야할 문제 쌍 중에, 가장 낮은 숫자부터 level이 낮도록 저장한다.
//     * @param newNode 새로 입력받은 먼저 풀어야할 문제를 나타내는 데이터.
//     */
//    static void insert(myNode newNode) {
//
//        //힙의 마지막 노드에 데이터를 저장한다.
//        quizbook.add(newNode);
//
//        //heap에 저장된 데이터가 없는 경우, 메서드를 종료한다.
//        if(quizbook.size() == 0) {
//            return;
//        }
//
//        //quizbook 힙의 사이즈(저장된 데이터의 갯수) - 1이 마지막 node의 index가 된다.
//        int lastNodeindex = quizbook.size() - 1;
//
//        //pre와 post는 newNode에 저장된 preQuiz와 postQuiz를 나타낸다.
//        int pre = newNode.getPreQuiz();
//        int post = newNode.getPostQuiz();
//
//        //newNode가 루트 자리에 도달할 동안 반복한다.
//        while(lastNodeindex > 0) {
//            //parentPre는 부모노드가 가진 pre값, parentPost 는 부모노드가 가진 post값
//            myNode parent = quizbook.get((lastNodeindex - 1) / 2);
//            int parentPre = parent.getPreQuiz();
//            int parentPost = parent.getPostQuiz();
//
//            //새로운 노드가 부모노드보다 작은 값을 가지는지 판별.
//            if(pre < parentPre) {
//                myNode temp = parent;
//                quizbook.set(lastNodeindex,parent);
//                quizbook.set(((lastNodeindex - 1) / 2),newNode);
//            }
//            //두 노드의 pre값이 같은 경우, post 값으로 판별.
//            else if (pre == parentPre) {
//                if(post < parentPost) {
//                    myNode temp = parent;
//                    quizbook.set(lastNodeindex,parent);
//                    quizbook.set(((lastNodeindex - 1) / 2),newNode);
//                }
//            }
//
//            //newNode의 index를 갱신한다.
//            lastNodeindex = (lastNodeindex - 1) / 2;
//
//        }
//    }
//
//    static myNode delete() {
//        myNode root = quizbook.get(0);
//
//        //트리클 노드의 index, 마지막 노드를 루트로 옮긴 것을 트리클 노드라 한다.
//        int trickleIndex = 0;
//        myNode trickle = quizbook.get(quizbook.size() - 1);
//        quizbook.set(0,trickle);
//
//        while(smallerChildExist(trickleIndex)) {
//            int smallerChildIndex = calIndex(trickleIndex);
//
//            myNode temp = quizbook.get(smallerChildIndex);
//
//            quizbook.set(trickleIndex, temp);
//            quizbook.set(smallerChildIndex, trickle);
//
//            trickleIndex = smallerChildIndex;
//        }
//        quizbook.remove(quizbook.size()-1);
//        return root;
//    }
//
//    /**
//     * @param index 현재 quizbook 힙에서 가리키는 index
//     * @return 현재 index에서 가리키는 자식 중에 더 작은 값이 존재한다면, true를 반환한다.
//     */
//    static boolean smallerChildExist (int index) {
//        boolean result = false;
//        int leftIndex = index * 2 + 1;
//        int rightIndex = index * 2 + 2;
//
//        //오른쪽 자식 노드가 있는 경우
//        if(quizbook.size() - 1 >= rightIndex) {
//            myNode trickle = quizbook.get(index);
//            int pre = trickle.getPreQuiz();
//            int post = trickle.getPostQuiz();
//
//            myNode leftChild = quizbook.get(leftIndex);
//            int leftPre = leftChild.getPreQuiz();
//            int leftPost = leftChild.getPostQuiz();
//            if(pre > leftPre) {
//                result = true;
//                return result;
//            } else if (pre == leftPre) {
//                if(post > leftPost) {
//                    result = true;
//                    return result;
//                }
//            }
//
//            myNode rightChild = quizbook.get(rightIndex);
//            int rightPre = rightChild.getPreQuiz();
//            int rightPost = rightChild.getPostQuiz();
//            if(pre > rightPre) {
//                result = true;
//                return result;
//            } else if (pre == rightPre) {
//                if(post > rightPost) {
//                    result = true;
//                    return result;
//                }
//            }
//        }
//        //오른쪽 자식이 없고 왼쪽 자식만 있는 경우.
//        if(quizbook.size() - 1 > leftIndex) {
//            myNode trickle = quizbook.get(index);
//            int pre = trickle.getPreQuiz();
//            int post = trickle.getPostQuiz();
//
//            myNode leftChild = quizbook.get(leftIndex);
//            int leftPre = leftChild.getPreQuiz();
//            int leftPost = leftChild.getPostQuiz();
//            if(pre > leftPre) {
//                result = true;
//                return result;
//            } else if (pre == leftPre) {
//                if(post > leftPost) {
//                    result = true;
//                    return result;
//                }
//            }
//        }
//        return result;
//    }
//
//    /**
//     *
//     * @param index 현재 위치한 노드의 index
//     * @return 자식 노드에 더 작은 문제 번호가 있다면, 그 노드의 index를 반환한다.
//     */
//    static int calIndex(int index) {
//        int leftIndex = index * 2 + 1;
//        int rightIndex = index * 2 + 2;
//
//        //오른쪽 자식 노드가 존재하는 경우.
//        if(quizbook.size() - 1 >= rightIndex) {
//            myNode leftChild = quizbook.get(leftIndex);
//            int leftPre = leftChild.getPreQuiz();
//            int leftPost = leftChild.getPostQuiz();
//
//            myNode rightChild = quizbook.get(rightIndex);
//            int rightPre = rightChild.getPreQuiz();
//            int rightPost = rightChild.getPostQuiz();
//
//            if(rightPre < leftPre) {
//                return rightIndex;
//            } else if (rightPre == leftPre) {
//                if(rightPost < leftPost) {
//                    return rightIndex;
//                }
//            }
//
//        }
//
//        //오른쪽 자식 노드가 없는경우
//        return leftIndex;
//    }
//
///**
// * preQuiz 변수는 먼저 풀어야할 문제를 나타낸다.
// * postQuiz 변수는 나중에 풀어야할 문제 번호를 나타넨다.
// */
//static class myNode {
//    private int preQuiz;
//    private int postQuiz;
//
//    public myNode(int preQuiz, int postQuiz) {
//        this.preQuiz = preQuiz;
//        this.postQuiz = postQuiz;
//    }
//
//    public int getPreQuiz() {
//        return preQuiz;
//    }
//
//
//    public void setPreQuiz(int preQuiz) {
//        this.preQuiz = preQuiz;
//    }
//
//    public void setPostQuiz(int postQuiz) {
//        this.postQuiz = postQuiz;
//    }
//
//    public int getPostQuiz() {
//        return postQuiz;
//    }
//
//}