import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        /**
         * Test Xe
         */
        Xe xe1 = new Xe("86-B3-7749", "Wave Aphal", true, true, 2000);
        Xe xe2 = new Xe("87-B4-2344", "SH mode", true, true, 2022);
        Xe xe3 = new Xe("88-B5-1111", "honda", true, true, 2012);
        Xe xe4 = new Xe("89-B6-5432", "yamaha", true, true, 2022);
        Xe xe5 = new Xe("90-B7-2347", "suzuki", true, true, 2011);

        /**
         * Test CongDan
         * câu b: Làm như thế nào để dsSoHuu(Danh sách sở hữu xe) được sắp xếp theo tăng dần của năm đăng ký sử dụng xe. Test. 1.0 đ
         * trả lời: cần phải dể class xe implement Comparable và hien thực lại method compare()
         */
        CongDan cd1 = new CongDan("22130071", "15/06/2004", "Bình Thuận");
        CongDan cd2 = new CongDan("22222222", "11/11/2011", "Bình Dương");
        CongDan cd3 = new CongDan("33333333", "13/12/2013", "Ninh Thuận");

        cd1.themXe(xe5);
        cd1.themXe(xe1);
        cd1.themXe(xe2);
        cd1.themXe(xe4);
        cd1.themXe(xe3);

        cd2.themXe(xe1);
        cd2.themXe(xe2);
        cd2.themXe(xe4);

        cd3.themXe(xe1);
        cd3.themXe(xe2);
        cd3.themXe(xe4);
        cd3.themXe(xe3);


//        System.out.println(cd1);
//        System.out.println(cd2);
//        System.out.println(cd3);


        /**
         * Test HoKhau
         * b) Làm như thế nào để dsThanhVien(Danh sách thành viên) được sắp xếp theo giảm dần của số lượng sở hữu xe. Test.
         * trả lời: cần phải dể class CongDan implement Comparable và hien thực lại method compare()
         *
         *
         * */
        //Câu b
        HoKhau hk1 = new HoKhau("12345", cd1, "12/06 Hai Bà Trưng", "Linh Trung", "Thủ Đức", "Hồ Chí Minh");
        HoKhau hk2 = new HoKhau("12345", cd2, "123 Nơ Trang Long", "Bà Triệu", "12", "Hồ Chí Minh");
        HoKhau hk3 = new HoKhau("12345", cd3, "312 Nguyễn Du", "Lê Quý Đôn", "1", "Hồ Chí Minh");

        hk1.themThanhVien(cd1);
        hk1.themThanhVien(cd2);
        hk1.themThanhVien(cd3);
//        System.out.println(hk1);
//        System.out.println(hk2);
//        System.out.println(hk3);


        /**
         * Test thongKec) Viết hàm getSoLuong_LoaiXe_Tinh(String loaiXe, String tenTinh): int,
         * Hàm nhận vào String ghi loại xe như “Xe may”, “xe dap”,... và tên tỉnh, thành phố “HCM”,”HaNoi”,... cho ra tổng lượng xe. Test.
         */
        ThongKe tk = new ThongKe();
        tk.themHoKhau(hk1);
        tk.themHoKhau(hk2);
        tk.themHoKhau(hk3);

        //test getSoLuong_LoaiXe_Tinh
        System.out.println(tk.getSoLuong_LoaiXe_Tinh("Wave Aphal","Hồ Chí Minh" ));
        //
    }
}
