package 排序算法;

import java.util.Arrays;

/**
 * Created by 666 on 2017/11/14.
 */
public class 选择排序 {
    /**
     * 简单选择排序
     基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
     然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     */
    public static void main(String[] args){
        int[] arr = new int[]{57,68,59,52};
        sort(arr);
    }

    private static void sort(int[] arr) {
        int position = 0;
        for (int i = 0; i < arr.length ; i++){
            int j = i + 1;
            position = i;
            int temp  = arr [i];
            for (;j < arr.length ;j++){
                if(arr[j] < temp){  //如果第2元数小于  第一个 就换位置
                    temp = arr[j];
                    position = j;
                }
            }
            arr[position] = arr[i];  //arr[3] = 57;
            arr[i] = temp;  //arr[0] = 52;
        }
        System.out.println(Arrays.toString(arr) + " bubbleSort");
    }

}
