public class QuickSort {
    public static void quickSort(int[] array, int low, int high){
        if(low < high){
            int pivotIndex = partition(array, low, high); // 获取基准元素的索引
            quickSort(array, low, pivotIndex - 1); // 对基准元素左边的子数组进行快速排序
            quickSort(array, pivotIndex + 1, high); // 对基准元素右边的子数组进行快速排序
        }
    }

    private static int partition(int[] array, int low, int high){
        int pivot = array[high]; // 选择最后一个元素作为基准元素
        int i = low - 1;

        for(int j = low; j < high; j++){
            if(array[j] < pivot){
                i++;
                swap(array, i, j); // 将小于基准元素的元素交换到左侧
            }
        }

        swap(array, i + 1, high); // 将基准元素放到合适的位置
        return i + 1; // 返回基准元素的索引
    }

    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 7, 6, 3};
        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted array: ");
        for(int num : array){
            System.out.print(num + " ");
        }
    }
}
