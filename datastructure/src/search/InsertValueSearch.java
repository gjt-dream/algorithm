package search;


public class InsertValueSearch {

    public int search(int arr[], int left, int right, int findVal){
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]){
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (midVal < findVal){
            return search(arr,mid + 1,right,findVal);
        }else if (midVal > findVal){
            return search(arr,left,mid - 1,findVal);
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,5,9,34,46,61,69,92,92};
        InsertValueSearch insertValueSearch = new InsertValueSearch();
        int searchVal = insertValueSearch.search(arr, 0, arr.length - 1, 61);
        System.out.println(searchVal);
    }
}
