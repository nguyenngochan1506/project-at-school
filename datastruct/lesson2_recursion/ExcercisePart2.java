package lesson2_recursion;

public class ExcercisePart2 {
    public static void main(String[] args) {
        int n = 997;
        System.out.println("n = "+n);
        //Test checkMod9Ver1 (không dùng đệ quy)
        System.out.println("Test checkMod9Ver1 (không dùng đệ quy)");
        System.out.println(kiemTraChiaHet3Va9Ver1(n));

        //Test checkMod9Ver2 ( dùng đệ quy)
        System.out.println("Test checkMod9Ver2 ( dùng đệ quy)");
        System.out.println(kiemTraChiaHet3Va9Ver2(n));

        //Test demChuSo()
        System.out.println("Test đếm chữ số: ");
        System.out.println(demChuSoLe(n));

        //Test daoNguocSoNguyenDuong()
        System.out.println("Tìm số đảo ngược: ");
        System.out.println(daoNguocSoNguyenDuong(n));

        //Test kiemTraSoNguyenTo()
        System.out.println("Kiểm tra số nguyên tố:");
        System.out.println(kiemTraSoNguyenTo(n,2));

        //Test algebraProblem()
        System.out.println("Kiểm tra: S(x,n) = x^2 + x^4 +.... + x^2n");
        System.out.println(algebraProblem(4, 5));
    }

    /**
     * //phuongw thức kiểm tra 1 số có chia hết cho 9
     *  //Ver đơn giản và không dùng đệ quy
     * @param n
     * @return
     */
    public static boolean kiemTraChiaHet3Va9Ver1(int n){
       return n%9==0;
    }

    /**
     * //phuongw thức kiểm tra 1 số có chia hết cho 9
     *     //ver dùng đệ quy
     * @param n
     * @return
     */
    public static boolean kiemTraChiaHet3Va9Ver2(int n){
        int sum = 0;
        //đều kiện dừng khi n chỉ conf 1 chữ số
        if(n<10){
            return n == 9;
        }else{
            //tính tổng các chữ số của n
            while (n>0){
                sum+=n%10;
                n/=10;
            }
        }
        return kiemTraChiaHet3Va9Ver2(sum);
    }

    //Bài 2: đếm chữ số lẻ của 1 số nguyên dương (n>0)

    /**
     * phương thức  đếm chữ số lẻ của 1 số nguyên dương (n>0)
     * @param n
     * @return số chữ số lẻ của n
     */
    public static int demChuSoLe(int n) {
        //điều kiện dừng khi n ==0
       if (n < 10) {
            return n%2!=0?1:0;
        }
        //lấy ra so cuoi cung hien tai va kiem tra co le khong
        return (n%2 != 0)
                ? (1+ demChuSoLe(n/10))
                : (0+ demChuSoLe(n/10));
    }

    //Bài 3:Hãy tìm chữ số đảo ngược của số nguyên dương

    /**
     * phương thức tìm chữ số đảo ngược của số nguyên dương
     * @param n
     * @return
     */
    public static String daoNguocSoNguyenDuong(int n){
        //điều kiện dừng khi n chỉ còn 1 chữ số
        if(n==0){
            return "";
        }
        //lấy ra số cuối của n
        return n%10+ daoNguocSoNguyenDuong(n/10);
    }
    //Bài 4: kiểm tra số nguyên tố

    /**
     * phương thức kiểm tra số nguyên tố
     * @param n số cần kiểm tra
     * @param i hãy để mặc đinh  = 2
     * @return true nếu là số nguyên tố
     */
    public static boolean kiemTraSoNguyenTo(int n, int i){
        if(n<=1){
            return false;
        }
        if(i==n){
            return true;
        }
        if(n%i==0){
            return false;
        }

        return kiemTraSoNguyenTo(n, ++i);

    }
    //Bài 5:Tính S(x,n) = x^2 + x^4 +.... + x^2n

    /**
     * phương thức tính : S(x,n) = x^2 + x^4 +.... + x^2n
     * @param x
     * @param n
     * @return result
     */
    public static double algebraProblem(int x, int n){
        if(n == 0){
            return 0;
        }
        return Math.pow(x, 2*n) + algebraProblem(x, n-1);
    }
}
