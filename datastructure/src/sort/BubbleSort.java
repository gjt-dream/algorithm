package sort;

public class BubbleSort {

    public void sort(int array[]){
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序的边界
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < sortBorder; j++) {
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag =false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (flag){
                break;
            }
        }
    }

    public void print(int array[]){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ",array[i]);
        }
    }
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int arr[] = new int[80000];
        for (int i = 0;i < 80000;i++){
            arr[i] = (int)(Math.random() * 8000000);
        }

        long start = System.currentTimeMillis();
        bubbleSort.sort(arr);
        long end = System.currentTimeMillis();
        long time = end - start;//11313
        System.out.println(time);
        //bubbleSort.print(arr);
    }
}
