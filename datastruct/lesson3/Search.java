package lesson3;

public class Search {
    public static void main(String[] args) {
        int[] arr = {4,2,65,23,5,564,2,3,5,7,2};

        System.out.println(binarySearch(arr, 2));
    }
    public static int  binarySearch(int[] arr, int target){
        int low = 0;
        int hight = arr.length -1;
        int mid = 0;

        while (low <= hight){
            mid = (low + hight)/2;
            if(target == arr[mid]){
                return mid;
            }else if(target < arr[mid]){
                hight = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
