package lesson3;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {4,2,65,23,5,564,2,3,5,7,2};
        System.out.println(Arrays.toString(insertionSortRecursive(arr, 1)));
    }

    /**
     * phuong thuc sap xep chon dung vong lap
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr){
        for(int i = 0; i<arr.length; i++){
            int minIndex = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
               swap(arr, minIndex, i);
            }
        }
        return arr;
    }

    /**
     * phuong thuc xap sep chon dung de quy
     * @param arr
     * @param beginIndex
     * @return
     */
    public static int[] selectionSortRecursive(int[] arr, int beginIndex){
        if(beginIndex >= arr.length-1){
            return arr;
        }
        int minIndex = beginIndex;
        for(int i = minIndex; i<arr.length; i++){
            if (arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }
        swap(arr, minIndex, beginIndex);

        return selectionSortRecursive(arr, beginIndex +1);
    }

    public static int[] insertionSort(int[] arr){
        for(int i = 1; i<arr.length; i++){
           int current = arr[i];
           int j = i-1;
           while (j>=0 && arr[j] > current){
               arr[j+1] = arr[j];
               j--;
            }
            arr[j+1]  = current;
        }
        return arr;
    }
    public static int[] insertionSortRecursive(int[] arr, int beginIndex){
        if(beginIndex>= arr.length-1){
            return arr;
        }
        int current  = arr[beginIndex];
        int j = beginIndex -1;
        while(j>=0 && current > arr[j]){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = current;
        return insertionSortRecursive(arr, beginIndex +1);
    }


    public static void swap(int[] arr, int n, int i){
        int temp = arr[n];
        arr[n] = arr[i];
        arr[i] = temp;
    }
}
