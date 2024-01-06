package GiuaKy;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        /*
          Test for QuaTrinhLamNghe
        */
        QuaTrinhLamNghe nn1 = new QuaTrinhLamNghe("001", "Giữ Xe", 2012);
        QuaTrinhLamNghe nn2 = new QuaTrinhLamNghe("002", "Bán Kem Trộn", 2000);
        QuaTrinhLamNghe nn3 = new QuaTrinhLamNghe("003", "Fuho", 2020);
        QuaTrinhLamNghe nn4 = new QuaTrinhLamNghe("004", "Chạy bàn", 2012);
        QuaTrinhLamNghe nn5 = new QuaTrinhLamNghe("005", "Vá Xe", 2020);

//        System.out.println(nn1);
//        System.out.println(nn2);
//        System.out.println(nn3);
//        System.out.println(nn4);
//        System.out.println(nn5);

        /*
        Test for ChiDep
         */
        ChiDep cd1 = new ChiDep("123", "Nguyễn Ngọc Hân", false);
        ChiDep cd2 = new ChiDep("321", "Nguyễn Quang Tèo", false);
        ChiDep cd3 = new ChiDep("213", "ToNy Tủn", true, "Gửi Xe");

        cd1.themDiemQuaTrinh(99);
        cd1.themDiemQuaTrinh(89);
        cd1.themDiemQuaTrinh(100);
        cd1.themNgheNghiep(nn1);
        cd1.themNgheNghiep(nn2);
        cd1.themNgheNghiep(nn5);


        cd2.themDiemQuaTrinh(78);
        cd2.themDiemQuaTrinh(66);
        cd2.themDiemQuaTrinh(56);
        cd2.themNgheNghiep(nn2);
        cd2.themNgheNghiep(nn1);
        cd2.themNgheNghiep(nn4);

        cd3.themDiemQuaTrinh(40);
        cd3.themDiemQuaTrinh(22);
        cd3.themDiemQuaTrinh(30);
        cd3.themNgheNghiep(nn5);
        cd3.themNgheNghiep(nn1);
        cd3.themNgheNghiep(nn3);

//        System.out.println(cd1);
//        System.out.println(cd2);
//        System.out.println(cd3);
    /*
    Test for NhomTrinhDien
     */
        NhomTrinhDien ntd1 = new NhomTrinhDien("Nhảy", "Đắp mộ cuộc tình", "Tèo");
        NhomTrinhDien ntd2 = new NhomTrinhDien("Hát", "Cứ Chill Thôi", "Hân");
        NhomTrinhDien ntd3 = new NhomTrinhDien("Múa", "Đồi Thông Hai Mộ", "Tý");

        ntd1.setNhomTruong(cd1);
        ntd1.setPhieuBauTV(cd1, 99);
        ntd1.setDiemNhom(100);

        ntd2.setNhomTruong(cd2);
        ntd2.setPhieuBauTV(cd3, 88);
        ntd2.setPhieuBauTV(cd1, 81);
        ntd2.setPhieuBauTV(cd2, 99);
        ntd2.setDiemNhom(80);

        ntd3.setPhieuBauTV(cd3, 77);
        ntd1.setDiemNhom(60);

//        System.out.println(ntd1);
//        System.out.println(ntd2);
//        //Test loaiThanhVien
//        System.out.println(ntd2.loaiThanhVien(2));
//        System.out.println(ntd3);

        /*
        Test for CachTinhDiem
         */
        CachTinhDiem ctd1 = new CachTinhDiem(0.7, 0.3);


        /*
        Test for VongThi
         */
        ArrayList<NhomTrinhDien> dsNhomTrinhDien1 = new ArrayList<>();
        dsNhomTrinhDien1.add(ntd1);
        dsNhomTrinhDien1.add(ntd2);
        dsNhomTrinhDien1.add(ntd3);
        ArrayList<NhomTrinhDien> dsNhomTrinhDien2 = new ArrayList<>();
        dsNhomTrinhDien2.add(ntd2);
        dsNhomTrinhDien2.add(ntd3);

        VongThi vt1 = new VongThi("333", "Vòng Loại", dsNhomTrinhDien1, ctd1);
        VongThi vt2 = new VongThi("444", "Vòng Chung Kết", dsNhomTrinhDien2, ctd1);

        //Test getDiemTVNhom()
//        for(ChiDep cd : ntd2.getDsThanhVien()){
//            System.out.println(String.format("%s được %d điểm",cd.getHoTen(),vt1.getDiemThanhVienNhom(ntd2).get(cd)));
//        }

        /*
        Test for CuocThi
         */
        CuocThi ct =  new CuocThi("Ai Là Triệu Phú", 2023);
        ct.themVongThi(vt1);
        ct.themVongThi(vt2);

        ct.themChiDep(cd1);
        ct.themChiDep(cd2);
        ct.themChiDep(cd3);

//        System.out.println(ct);

        //test thongKeChiDep_danhSachDiemSo()
//         ct.thongKeChiDep_danhSachDiemSo().forEach((chiDep, diemSo)->{
//             System.out.println(String.format("Chị đẹp %s có điểm %s",chiDep.getHoTen(), diemSo.toString()));
//         });



        //test loaiChiDep()
//        ct.loaiChiDep(vt1, 2).forEach(chiDepBiLoai ->{
//            System.out.println(chiDepBiLoai);
//        });
//        ct.loaiChiDep(vt2, 1).forEach(chiDepBiLoai ->{
//            System.out.println(chiDepBiLoai);
//        });

        //test thongKeChiDepBiLoai()
//        ct.thongKeChiDepBiLoai().forEach((vongThi, soLuongBiLoai)->{
//            System.out.println(String.format("Vòng thi %s có %d thành viên bị loại!", vongThi.getTenVong(), soLuongBiLoai));
//        });

        //test getSetTongDiemChiDep()
//        for (ChiDep chiDep : ct.getSetTongDiemChiDep()) {
//            System.out.println(String.format("%s có điểm trung bình là: %.0f", chiDep.getHoTen(), chiDep.getDiemTrungBinh()));
//        }


        //test getSetChiDepVongThi()
//        System.out.println(ct.getSetChiDepVongThi(vt1));
//        System.out.println(ct.getSetChiDepVongThi(vt2));

        //test sortNhomDiemSo()
        for (NhomTrinhDien nhomTrinhDien : ct.sortNhomDiemSo()) {
            System.out.println(String.format("Nhóm của biên đạo %s có điểm số: %d", nhomTrinhDien.getTenBienDao(), nhomTrinhDien.getDiemNhom()));
        }

    }

}
