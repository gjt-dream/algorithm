package search;

import java.util.ArrayList;

//数组必须有序
public class BinarySearch {

    /**
     * 二分查找
     * @param arr 要查找的数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 要查找的值
     * @return
     */
    public ArrayList<Integer> search(int arr[],int left,int right,int findVal){
        if (left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (midVal < findVal){
            return search(arr,mid + 1,right,findVal);
        }else if (midVal > findVal){
            return search(arr,left,mid - 1,findVal);
        }else {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            int temp = mid - 1;
            while (true){
                if (temp < 0 || arr[temp] != findVal){
                    break;
                }
                arrayList.add(temp);
                temp--;
            }
            arrayList.add(mid);

            temp = mid + 1;
            while (true){
                if (temp > arr.length -1  || arr[temp] != findVal){
                    break;
                }
                arrayList.add(temp);
                temp++;
            }
            return arrayList;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,5,9,34,46,61,69,92,92};
        ArrayList<Integer> resArrayList = new BinarySearch().search(arr, 0, arr.length, 92);
        System.out.println(resArrayList);
    }
}
