package 排序算法;

import java.util.Arrays;

/**
 * Created by 666 on 2017/11/14.
 */
public class 冒泡排序 {
    public static void main(String[] args){
        int[] arr = new int[]{3,14,290,23,29,1,20,50,31};

        sort(arr);
    }

    private static void sort(int[] arr) {
        int temp = 0;
        for (int i = 0 ; i <arr.length - 1; i++){
            for (int j = 0; j < arr.length - 1 -i ; j ++){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr) + " bubbleSort");
    }
}
