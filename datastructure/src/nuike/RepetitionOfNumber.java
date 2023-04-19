package nuike;

import java.util.Arrays;

public class RepetitionOfNumber {

    //方法一
    public int ROF(int arr[]) throws Exception {
        int temp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            if (temp[i1] >= 1){
                return i1;
            }else {
                temp[i1]++;
            }
        }
        throw new Exception("没有重复数字！");
    }

    //方法二
    public void swap(int arr[],int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public int ROFTow(int arr[]) throws Exception {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                continue;
            } else {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                } else {
                    swap(arr,i,arr[i]);
                    i--;
                }
            }
        }
        throw new Exception("没有重复数字！");
    }

    public static void main(String[] args) {
        RepetitionOfNumber repetition = new RepetitionOfNumber();
        int arr[] = new int[]{2,3,1,0,2,5,3};
        int rof = 0;
        long start1 = System.currentTimeMillis();
        try {
            rof = repetition.ROF(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long time1 = System.currentTimeMillis() - start1;
        System.out.println(rof);
        System.out.println(time1);

        int rofTow =0;
        long start2 = System.currentTimeMillis();
        try {
            rofTow = repetition.ROFTow(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long time2 = System.currentTimeMillis() - start2;
        System.out.println(rofTow);
        System.out.println(time2);
    }
}
