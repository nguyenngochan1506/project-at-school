package lesson2_recursion;

public class RecursiveExer {
    public static void main(String[] args) {
        //kiem tra fatorial
        System.out.println("CHECK FACTORIAL METHOD:");
        System.out.printf("factorial of %d is: %d\n", 5, factorial(5));
        System.out.printf("factorial of %d is: %d \n\n", 0, factorial(0));

        //kiem tra dectobi
        System.out.println("CHECK DECTOBI METHOD:");
        System.out.printf("binary of %d is: %d\n", 0, decToBi(0));
        System.out.printf("binary of %d is: %d\n\n", 634, decToBi(634));

        //kiem tra bitodec
        System.out.println("CHECK BITODEC METHOD:");
        System.out.printf("decimal of %d is: %d\n",0 , biToDec("0",0));
        System.out.printf("decimal of %d is: %d\n\n", 1001111010, biToDec("1001111010",0));

        //kiem tra bitodec ver 2
        System.out.println("CHECK BITODEC ver2 METHOD:");
        System.out.printf("decimal of %d is: %d\n",0 , biToDecVer2(0));
        System.out.printf("decimal of %d is: %d\n\n", 1001111010, biToDecVer2(1001111010));

    }

    /**
     * phuong thuc tra ve giai thua cua mot so
     * @param n: number
     * @return
     */
    public static int factorial(int n) {

         if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int decToBi(int n) {
        if (n < 2) {
            return n;
        } else {
            return n % 2 + 10 * decToBi(n / 2);
        }
    }

    public static int biToDec(String binary, int pow) {

       if(binary.length()<1){
           return 0;
       }else{
           char lastDigitChar = binary.charAt(binary.length()-1);//lấy ra kí tự cuối cùng trong chuỗi
           int lastDigitInt = Integer.parseInt(lastDigitChar+"");//chuyển kí tự đó thành số
           //vì ta tính từ trái qua nên cứ mỗi lần đệ quy sẽ loại bo phần từ đứng cuối
           return (int)(lastDigitInt*Math.pow(2, pow) + biToDec(binary.substring(0, binary.length()-1), pow+1));
       }
    }

    public static int biToDecVer2(int binary){
        if(binary==0)
            return 0;
        else
            return (binary% 10 + 2* biToDecVer2(binary / 10));
    }
}
