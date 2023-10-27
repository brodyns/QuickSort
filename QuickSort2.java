import java.util.Arrays;

public class QuickSort2 {

    // 定义交换函数
    public static void swap(Integer arr[], int i, int j){
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    public static Integer[] arr = {10, 5, 30, 15, 6};

    // 定义一个空数组，用来与原数组进行比较，当该数组与原数组相等时结束。
    private static Integer[] flag = new Integer[arr.length];

    // 定义扫描次数
    private static Integer number = 1;

    public static void Quick_Sort(Integer[] arr, int low, int high){
        Integer i,j,temp;
        i = low;
        j = high;
        // temp就是基准位
        temp = arr[low];

        while(i < j){
            // 先看右边，依次往左递减
            while(temp <= arr[j] && i<j){
                j--;
            }
            // 再看左边，依次往右递增
            while(temp >= arr[i] && i<j){
                i++;
            }
            // 如果满足条件则交换
            if(i<j){
                swap(arr, i, j);
            }
        }

        // 最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;

        // 判断是否排好序，若排好序则退出排序，也就是递归结束条件
        if(Arrays.equals(arr,flag)){
            return;
        }
        System.out.println("第"+number+"次扫描结果:");
        for (int k = 0;k < arr.length; k++){
            // 将原数组存储在flag数组中
            flag[k] = arr[k];
            System.out.println(arr[k] + "\t");
        }
        System.out.println();
        number++;
        // 递归调用左半数组
        Quick_Sort(arr, low, j-1);
        // 递归调用右半数组
        Quick_Sort(arr, j+1, high);
    }

    public static void main(String[] args) {
        System.out.println("---快速排序---");
        Quick_Sort(arr, 0, arr.length-1);
    }

}
