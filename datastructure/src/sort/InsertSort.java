package sort;

public class InsertSort {

    public void sort(int arr[]){
        for (int i = 1; i < arr.length -1; i++) {
            //记录要插入的数
            int insertVal = arr[i];
            //记录要插入的位置
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //加判断变慢了
            if (insertIndex + 1 == i){
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
    public void print(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int arr[] = new int[80000];
        for (int i = 0;i < 80000;i++){
            arr[i] = (int)(Math.random() * 8000000);
        }

        long start = System.currentTimeMillis();
        insertSort.sort(arr);
        long end = System.currentTimeMillis();
        long time = end - start;//554
        System.out.println(time);
        //insertSort.print(arr);
    }
}
