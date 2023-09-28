package lesson1;

import java.util.Arrays;

public class Array1DUtil {
    // Phương thức để hoán đổi giá trị tại hai vị trí trong mảng một chiều
    public void switchPositions(int[] array, int position1, int position2) throws Exception {
        if (position1 < 0 || position1 >= array.length || position2 < 0 || position2 >= array.length) {
            throw new Exception("Vị trí không hợp lệ. Vui lòng cung cấp vị trí hợp lệ.");
        }

        int temp = array[position1];
        array[position1] = array[position2];
        array[position2] = temp;
    }

    // Phương thức để xóa giá trị tại vị trí mục tiêu trong mảng một chiều
    public void delete(int[] array, int position) throws Exception {
        if (position < 0 || position >= array.length) {
            throw new Exception("Vị trí không hợp lệ. Vui lòng cung cấp vị trí hợp lệ.");
        }

        for (int i = position; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
            array[array.length - 1] = 0; // sửa phần tử cuối cùng thành 0
    }

    // Phương thức để chèn giá trị vào vị trí mục tiêu trong mảng một chiều
    public void insert(int[] array, int position, int value) throws Exception {
        if (position < 0 || position > array.length) {
            throw new Exception("Vị trí không hợp lệ. Vui lòng cung cấp vị trí hợp lệ.");
        }

        int[] newArray = new int[array.length + 1];
        for (int i = 0, j = 0; i < newArray.length; i++) {
            if (i == position) {
                newArray[i] = value;
            } else {
                newArray[i] = array[j++];
            }
        }
        System.arraycopy(newArray, 0, array, 0, array.length);
    }

    //  Phương thức để đảo ngược một mảng một chiều
    public void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    // Phương thức để tìm số lần một giá trị mục tiêu xuất hiện trong mảng một chiều
    public int duplicateTimes(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }
        return count;
    }



    public static void main(String[] args) throws Exception {
        Array1DUtil array1DUtil = new Array1DUtil();
        int[] arr = {-3,-2,-1,0,1,2,3};

        // Kiểm tra switchPositions
        System.out.println("---Kiểm tra switchPositions");
        System.out.println("Mảng ban đầu:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Sau khi switch:");
        array1DUtil.switchPositions(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        // Kiểm tra delete
        System.out.println("---Kiểm tra delete");
        System.out.println("Mảng ban đầu:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Sau khi delete vị trí 0:");
        array1DUtil.delete(arr, 0);
        System.out.println(Arrays.toString(arr));

        // Kiểm tra insert
        System.out.println("---Kiểm tra insert");
        System.out.println("Mảng ban đầu:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Sau khi insert vào vị trí 3 với value=2:");
        array1DUtil.insert(arr, 3, 2);
        System.out.println(Arrays.toString(arr));

        // Kiểm tra reverse
        System.out.println("---Kiểm tra reverse");
        System.out.println("Mảng ban đầu:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Sau khi reverse:");
        array1DUtil.reverse(arr);
        System.out.println(Arrays.toString(arr));

        // Kiểm tra duplicateTimes
        System.out.println("---Kiểm tra duplicateTimes");
        System.out.println("Mảng ban đầu:");
        System.out.println(Arrays.toString(arr));
        System.out.printf("Số lần %d xuất hiện: %d", 2, array1DUtil.duplicateTimes(arr, 2));

    }
}
