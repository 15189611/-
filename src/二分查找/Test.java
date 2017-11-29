package 二分查找;

/**
 * Created by 666 on 2017/11/12.
 */
public class Test {
    public static void main(String[] args){
        int[] array = new int[]{3,10,20,30,40,50};
        System.out.print(findKeyToValue(2,array));
    }

    private static int findKeyToValue(int key ,int[] array){
        if(array.length <= 0){
            return -1;
        }

        if(key >= array.length -1 ){
            throw new IndexOutOfBoundsException("索引越界");
        }

        int start  = 0;
        int end  = array.length - 1;
        int mid = (start + end) / 2;

        while (start <= end){
            if(array[mid] == array[key]){
                return array[key];   //找到你要的数
            }

            if(key > mid){   //在右边
                start = mid + 1;
            }

            if(key < mid){                   //在左边
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }

        return  -1;
    }

}
