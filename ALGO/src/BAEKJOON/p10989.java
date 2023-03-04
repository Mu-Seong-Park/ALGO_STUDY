package BAEKJOON;

import java.io.*;

public class p10989 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for(int i = 0 ; i < n ; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        MyQuickSort.sort(array);

        for(int i = 0 ; i < n ; i++) {
            bw.write(array[i]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

/** 직접 구현한 QuickSort.
 * Pivot을 중간에 위치한 값으로 정한다.
 */
class MyQuickSort {


    /** 외부에서 정렬을 위해 호출할 함수
     * @param a 정렬할 배열
     */
    static public void sort(int[] a) {
        middlePivotSort(a, 0, a.length - 1);
    }

    /**
     * @param a 정렬할 배열
     * @param low 배열의 가장 좌측을 가리키는 값
     * @param high 배열의 가장 우측을 가리키는 값
     */
    static private void middlePivotSort(int[] a, int low, int high) {
        if(low >= high) {
            return;
        }

        int pivot = partition(a, low, high);

        //위에서부터, 왼쪽과 오른쪽으로 배열을 나누어서 재귀 진행.
        middlePivotSort(a, low , pivot);
        middlePivotSort(a,pivot+1,high);
    }

    /**
     * @param a
     * @param right
     * @param left
     * @return
     */
    static private int partition(int[] a, int left, int right) {

        //do.while문을 통과하면서 ++, -- 연산을 진행하기 때문에 left - 1 , right + 1을 해주어야 한다.
        int lo = left - 1;
        int hi = right + 1;
        int pivot = a[(left + right)/2];

        while(true) {

            //피벗으로 정한 중간의 값보다 작은 경우 좌측 포인터,lo를 오른쪽으로 계속 이동시킨다.
            do {
                lo++;
            }while(a[lo] < pivot);

            //피벗으로 정한 중간의 값보다 작은 경우 우측 포인터, hi를 왼쪽 계속 이동시킨다.
            //hi가 가리키는 값이 피벗보다 작아지는 경우가 발생할 수 있어서 피벗까지 포함해서 나누어야 한다.
            do{
                hi--;
            }
            while(a[hi] > pivot && lo <= hi);

            //만약 hi가 lo보다 크지 않다면(엇갈린다면) swap하지 않고 hi를 리턴한다.
            if(lo >= hi) {
                return hi;
            }

            swap(a,lo,hi);
        }
    }

    /** a[i]와 a[j]값의 위치를 바꾸어주는 메소드.
     * @param a
     * @param i
     * @param j
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
