package 排序算法;

import java.util.Arrays;

/**
 * Created by 666 on 2017/11/14.
 */
public class 快速排序 {
    public static void main(String[] args){
        int[] arr = new int[]{3,290,29,41,24,62,67,23,423};

        quickSort(arr,0,arr.length -1);
        System.out.println(Arrays.toString(arr) + " bubbleSort");
    }

    private static void quickSort(int[] arr,int low ,int high) {
        if(low < high){
            int middle = getMiddle(arr, low, high);
            quickSort(arr,low,middle - 1);
            quickSort(arr ,middle + 1,high);
        }

    }

    private static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }


            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }


            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                  //返回中轴的位置
    }

}
