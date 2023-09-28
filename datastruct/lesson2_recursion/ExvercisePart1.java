package lesson2_recursion;

public class ExvercisePart1 {
    public static void main(String[] args) {
        //Test fibonacci method
        System.out.println("-Kiểm tra 10 số Fibonacci đầu tiên:");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("Số fibonacci thứ %d là: %d \n", i, fibonacci(i));
        }

        //Test Hanoi Tower Method
        int n = 3;
        System.out.printf("Kiểm tra phương thức hanoi tower với số đĩa là %d \n:", n);
        System.out.println(hanoiTower(n, 'A', 'B', 'C'));

        //Test uocChungLonNhat Method
        System.out.println("Kiểm tra phương thức ước chung lớn nhất: ");
        int a = 42;
        int b = 56;
        System.out.printf("UCLN(%d,%d) = %d \n\n", a, b, uocChungLonNhat(a, b));

        //Test sole problem
        System.out.println("Test sole problem");
        //Bài 1
        int num = 4;
        System.out.println("Bài 1: S(n)=1-2+3-4+...+ ((-1)^(n+1) ).n, n>0)");
        System.out.printf("S(%d) = %f \n", num, algebraProblem1(num));
        // Bài 2
        System.out.println("Bài 2: S(n)=1+1.2+1.2.3+...+1.2.3...n, n>0");
        System.out.printf("S(%d) = %f \n", num, algebraProblem2(num));

        //Bài 3
        System.out.println("Bài 3: S(n)=1^2 + 2^2 + ... n^2, n>0");
        System.out.printf("S(%d) = %f \n", num, algebraProblem3(num));


        //Bài 4
        System.out.println("Bài 4: S(n)=1+1/2+1/(2.4)+1/(2.4.6)+...+1/(2.4.6.2n), n>0");
        System.out.printf("S(%d) = %f \n", num, algebraProblem4(num));


    }

    /**
     * phương thức tìm số fibonacci thứ n
     *
     * @param n vị trí số fibonacci cần tìm
     * @return giá trị số fibonacci cần tìm
     */
    public static long fibonacci(int n) {
        if (n < 1) {
            throw new RuntimeException("Vui Long Nhap n >=1");
        } else if (n == 2 || n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * phương thức giải bài toán hanoiTower
     *
     * @param n     số đĩa cần giải
     * @param begin cột bắt đầu
     * @param mid   cột trung gian
     * @param end   cột đích cần chuyển tới
     * @return các bước đễ giải bài toán hanoiTower
     */
    public static String hanoiTower(int n, char begin, char mid, char end) {
        if (n < 1) {
            throw new RuntimeException("Vui long nhap so n>=1");
        } else if (n == 1) {
            return begin + " -> " + end + "\n";
        }
        return
                //chuyển n-1 cái đĩa sang cột trung gian
                hanoiTower(n - 1, begin, end, mid)
                        //chuyển cái đĩa còn lại sang cột đích
                        + hanoiTower(1, begin, mid, end)
                        //chuyển n-1 cái đĩa trước đó sang cột đích
                        + hanoiTower(n - 1, mid, begin, end);
    }

    /**
     * phương thức tìm ước chung lớn nhất của 2 số
     *
     * @param a số thứ nhất
     * @param b số thứ 2
     * @return ước chung lớn nhất của 2 số
     */
    public static int uocChungLonNhat(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new RuntimeException("Vui lòng nhập số a,b thuộc số nguyên khác 0!");
        }
        int r = a % b;
        if (r == 0) {
            return b;
        } else {
            return uocChungLonNhat(b, r);
        }
    }

    //4 bài ALGEBRA PROBLEM
    //bài 1: S(n)=1-2+3-4+...+ ((-1)^(n+1) ).n, n>0)
    public static double algebraProblem1(int n) {
        if (n == 0) {
            return 0;
        }
        return Math.pow(-1, n + 1) * n + algebraProblem1(n - 1);
    }

    //bài 2: S(n)=1+1.2+1.2.3+...+1.2.3...n, n>0
    public static double algebraProblem2(int n) {
        if (n == 0) {
            return 0;
        }
        return algebraProblem2Mini(n) + algebraProblem2(n - 1);
    }

    //phương thức này dùng để tính giai thừa bổ trợ cho bài 2
    public static double algebraProblem2Mini(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * algebraProblem2Mini(n - 1);
    }

    //bài 3: S(n)=1^2 + 2^2 + ... n^2, n>0)
    public static double algebraProblem3(int n) {
        if (n == 0) {
            return 0;
        }
        return Math.pow(n, 2) + algebraProblem3(n - 1);
    }

    //bài 4: S(n)=1+1/2+1/(2.4)+1/(2.4.6)+...+1/(2.4.6.2n), n>0
    public static double algebraProblem4(int n) {
        if (n == 0) {
            return 1;
        }
        return (double) (1 / algebraProblem4Mini(n)) + algebraProblem4(n - 1);
    }

    //bài 4 mini (dùng để tính tích các n chẵn)
    //vd S(n) = 2*4*6*...*2n;
    public static double algebraProblem4Mini(int n) {
        if (n == 0) {
            return 1;
        }
        return (2 * n) * algebraProblem4Mini(n - 1);
    }
}
