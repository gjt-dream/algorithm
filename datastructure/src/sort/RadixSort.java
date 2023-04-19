package sort;

import java.util.Arrays;

public class RadixSort {


    public void sort(int arr[]){

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //二维数组包含10一维数组
        //为防止放入数时，数溢出，则每个数组的大小没arr.length
        int [][] bucket = new int[10][arr.length];

        //为了记录每个桶中实际放了多少个数据，我们定义一个一维数组来记录每个桶中每次放入的数组个数
        int[] bucketElementCount = new int[10];


        for (int k = 0,n = 1; k < maxLength; k++,n *= 10) {
            for (int i = 0; i < arr.length; i++) {
                //取出每个元素的
                int digitOfElement = arr[i] / n % 10;
                //放入对应桶中
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
                bucketElementCount[digitOfElement]++;
            }
            //按照这个桶的顺序
            int index = 0;
            for (int i = 0; i < bucketElementCount.length; i++) {
                if (bucketElementCount[i] != 0){
                    for (int j = 0; j < bucketElementCount[i]; j++) {
                        arr[index++] = bucket[i][j];
                    }
                }
                bucketElementCount[i] = 0;
            }
//            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
//        int arr[] = {53,3,542,748,14,214};
        RadixSort radixSort = new RadixSort();
//        radixSort.sort(arr);

        int arr[] = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }
        int temp[] = new int[arr.length];
        long start = System.currentTimeMillis();
        radixSort.sort(arr);
        long end = System.currentTimeMillis();
        long time = end - start;//453
//        System.out.println(Arrays.toString(arr));
        System.out.println(time);
    }
}
