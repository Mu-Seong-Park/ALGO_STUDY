package BAEKJOON;

import java.io.*;

public class p1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int[] a = new int[n];

        boolean[] check = new boolean[n];
        for(int i = 0 ; i < n ; i++) {
            a[i] = Integer.parseInt(nums[i]);
            check[i] = false;
        }
        int[] temp = new int[n];

        for(int i = 0 ; i < n ; i++) {
            int k = a[i];
            temp[i] = k;
        }

        QuickSort.sort(a);



        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(temp[i] == a[j] && check[j] == false) {
                    check[j] = true;
                    bw.write(j+" ");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }


}


/**퀵소트 구현
 *
 */
class QuickSort {

    public static void sort(int[] a) {
        mPivotSort(a,0,a.length-1);
    }

    /**pivot을 기준으로 파티션을 나누는 정렬 메소드.
     * @param a : 정렬할 배열
     * @param lo : 현재 파티션의 왼쪽 (로우)
     *@param hi : 현재 파티션의 오른쪽 (하이)
     */

    private static void mPivotSort(int[] a, int lo, int hi) {

        //lo가 hi와 크거나 같다면 정렬할 원소가 1개 이하이므로 종료(기저 조건)
        if( lo >= hi) {
            return;
        }

        int pivot = partition(a, lo, hi);

        //위에서부터, 왼쪽과 오른쪽으로 배열을 나누어서 재귀 진행.
        mPivotSort(a, lo , pivot);
        mPivotSort(a,pivot+1,hi);
    }


    /**pivot을 기준으로 파티션을 나누는 정렬 메소드.
     * * @param a 정렬할 배열
     * @param left 현재 배열의 가장 왼쪽
     * @param right 현재 배열의 가장 오른쪽
     * @return 최종적으로 위치한 피벗의 위치(hi)를 반환한다.
     */
    private static int partition(int[] a, int left, int right) {

        int lo = left - 1;
        int hi = right + 1;
        int pivot = a[(left + right)/2];

        while(true) {

            do{
                lo++;
            }
            while(a[lo] < pivot);

            do{
                hi--;
            }
            while(a[hi] > pivot && lo <= hi);


            if(lo >= hi) {
                return hi;
            }

            swap(a,lo,hi);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}