package search;


public class BinarySearchNoRecursion {
    public static void main(String[] args) {
        int arr[] = {1,5,9,34,46,61,69,92,92};
        int findVal = new BinarySearchNoRecursion().find(arr, 9);
        System.out.println(findVal);
    }
    public int find(int array[],int target){
        int left = 0;
        int right = array.length;
        int mid = (left + right) / 2;
        while (left <= right){

            if (array[mid] == target){
                return mid;
            }else if (array[mid] > target){
                right = mid -1;
                mid = (left + right) / 2;
            }else{
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }
        return -1;
    }
}
