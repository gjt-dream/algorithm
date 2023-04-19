package sort;

import java.util.Arrays;

public class MergerSort {

    public void sort(int arr[],int left,int right,int temp[]){
        if (left < right){
            //中间索引
            int mid = (left + right) / 2;
            //向左递归分解
            sort(arr,left,mid,temp);
            //向右递归分解
            sort(arr,mid + 1,right,temp);
            //合并
            merger(arr,left,mid,right,temp);
        }

    }

    private void merger(int[] arr, int left, int mid, int right, int[] temp) {
        //左边序列的初始索引
        int i = left;
        //左边序列的初始索引
        int j = mid + 1;
        //temp当期的初始索引
        int t = 0;
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //把剩余的数放到temp中
        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }
        //将temp拷贝到arr中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

    public static void main(String[] args) {
//        MergerSort mergerSort = new MergerSort();
//        int array[] = new int[]{4,7,5,2,9,3,8,6,1};
//        int temp[] = new int[array.length];
//        mergerSort.sort(array,0,array.length - 1,temp);
//        System.out.println(Arrays.toString(array));
        MergerSort mergerSort = new MergerSort();
        int arr[] = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }
        int temp[] = new int[arr.length];
        long start = System.currentTimeMillis();
        mergerSort.sort(arr, 0, arr.length - 1,temp);
        long end = System.currentTimeMillis();
        long time = end - start;//1157
//        System.out.println(Arrays.toString(arr));
        System.out.println(time);

    }
}
