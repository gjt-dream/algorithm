package sort;

import java.util.Arrays;

public class ShellSort {

    public void shellSortOfExchange(int arr[]){
        for (int gap = arr.length / 2;gap > 0;gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]){
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(arr));
    }

    public void shellSortOfMove(int arr[]){
        for (int gap = arr.length / 2;gap > 0;gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                //记录要插入的数
                int shellVal = arr[i];
                //记录要插入的位置
                int shellIndex = i;

                    while (shellIndex - gap >= 0 && shellVal < arr[shellIndex - gap]){
                        arr[shellIndex] = arr[shellIndex - gap];
                        shellIndex -= gap;
                    }
                    arr[shellIndex] = shellVal;

            }
        }
        //System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int arr[] = new int[8000000];
        for (int i = 0;i < 8000000;i++){
            arr[i] = (int)(Math.random() * 8000000);
        }

//        long start = System.currentTimeMillis();
//        shellSort.shellSortOfExchange(arr);//5778
//        long end = System.currentTimeMillis();
//        long time = end - start;
//        System.out.println(time);


        long start2 = System.currentTimeMillis();
        shellSort.shellSortOfMove(arr);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - start2;//2166
//        System.out.println(Arrays.toString(arr));
        System.out.println(time2);

    }
}
