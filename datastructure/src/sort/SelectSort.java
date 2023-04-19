package sort;

public class SelectSort {

    public void sort(int arr[]){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]){
                    min = arr[i];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] array = new int[80000];
        for (int i = 0;i < 80000;i++){
            array[i] = (int)(Math.random() * 8000000);
        }

        long start = System.currentTimeMillis();
        selectSort.sort(array);
        long end = System.currentTimeMillis();
        long time = end - start;//8212
        System.out.println(time);
        //bubbleSort.print(arr);
    }
}
