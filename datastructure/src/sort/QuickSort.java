package sort;

import java.util.Arrays;

public class QuickSort {

    public void sort(int arr[],int startIndex,int endIndex){
        //结束条件
        if (startIndex >= endIndex){
            return;
        }
        int pivotIndex = partition(arr, startIndex, endIndex);
        sort(arr,startIndex,pivotIndex - 1);
        sort(arr,pivotIndex + 1,endIndex);
    }


    public int partition(int arr[],int startIndex,int endIndex){
        int ran = (int)(Math.random() * (endIndex - startIndex) + startIndex);

        int a = arr[ran];
        arr[ran] = arr[startIndex];
        arr[startIndex] = a;
        int pivot = arr[startIndex];

        int left = startIndex;
        int right = endIndex;
        while (left != right){
            //向左移动
            while (left < right && arr[right] > pivot){
                right--;
            }
            //向右移动
            while (left < right && arr[left] <= pivot){
                left++;
            }
            if (left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }
    public static void main(String[] args) {
//        QuickSort quickSort = new QuickSort();
//        int array[] = new int[]{4,7,5,2,9,3,8,6,1};
//        quickSort.sort(array,0,array.length - 1);
//        System.out.println(Arrays.toString(array));
        QuickSort quickSort = new QuickSort();
        int arr[] = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }

        long start = System.currentTimeMillis();
        quickSort.sort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        long time = end - start;//1049
//        System.out.println(Arrays.toString(arr));
        System.out.println(time);
    }
}
