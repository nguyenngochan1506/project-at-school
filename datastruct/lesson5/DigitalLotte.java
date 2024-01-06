package lesson5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DigitalLotte {
    public static void main(String[] args) {
        List<Integer> daySoDoan = new ArrayList<>();
        List<Integer> daySoTrungThuong = new ArrayList<>();
        long giaiThuongDacBiet = 100_000_000L; //cho mặt định là 1 trăm chẹo

        Scanner sc = new Scanner(System.in);

        //bước 1 nhập số đoán
        for (int i = 0; i <6; i++) {
            System.out.println("Sổ số VietLot!");
            while (true){
                try {
                    System.out.println("//////////////////");
                    System.out.printf("Số bạn đã chọn: %s \n", daySoDoan);
                    System.out.println("Mời bạn nhập các số 1-99:");
                    int soDoan = sc.nextInt();
                    if(soDoan>=0 && soDoan<=99){
                        daySoDoan.add(soDoan);
                        break;
                    }else {
                        System.out.println("Vui lòng nhập số từ 1-99");
                    }
                }catch (Exception e){
                    System.out.println("Vui lòng nhập đúng định dạng!");
                    sc.next();
                }
            }
        }

        //bước2: tạo 6 số trúng thưởng ngẫu nhiên
        taoSoTrungThuong(daySoTrungThuong);
        System.out.println("Dãy số trúng thưởng: "+daySoTrungThuong);
        System.out.println("Dãy số bạn đã đoán: "+daySoDoan);

        //bước 3: xử lý khi người dùng đoán
        daySoDoan.retainAll(daySoTrungThuong);  //chỉ giữ lại phần tu giống nhau của cả 2 list
        System.out.println("Bạn đã đoán trúng các số : "+daySoDoan);
        int soLuongDoanTrung = daySoDoan.size();
        switch (soLuongDoanTrung){
            case 6:
                System.out.println("Chúc mừng bạn đã trúng giải Đặc Biệt!");
                System.out.printf("Bạn sẽ nhận được số tiền %,d ", giaiThuongDacBiet);
                break;
            case 5:
                System.out.println("Chúc mừng bạn đã trúng giải Nhất!");
                System.out.println("Bạn sẽ nhận được 10tr");
                break;
            case 4:
                System.out.println("Chúc mừng bạn đã trúng giải Nhì!");
                System.out.println("Bạn sẽ nhận được 300k");
                break;
            case 3:
                System.out.println("Chúc mừng bạn đã trúng giải Ba!");
                System.out.println("Bạn sẽ nhận được 30k");
                break;
            default:
                System.out.println("Rất tiết bạn trật mất tiu rầu!");
        }

        //tránh rò rỉ bộ nhớ
        sc.close();

    }

    private static void taoSoTrungThuong(List<Integer> daySoTrungThuong) {
        //tạo 6 số ngẫu nhiên
        while (daySoTrungThuong.size() < 6){
            daySoTrungThuong.add(new Random().nextInt(99)+1);
        }
    }
}
