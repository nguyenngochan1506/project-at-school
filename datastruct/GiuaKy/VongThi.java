package GiuaKy;

import java.util.ArrayList;
import java.util.HashMap;

public class VongThi {
    private String idVT;
    private String tenVong;
    private ArrayList<NhomTrinhDien> dsNhomTrinhDien;
    private CachTinhDiem cachTinhDiem;

    public VongThi(String idVT, String tenVong, ArrayList<NhomTrinhDien> dsNhomTrinhDien, CachTinhDiem cachTinhDiem) {
        this.idVT = idVT;
        this.tenVong = tenVong;
        this.dsNhomTrinhDien = dsNhomTrinhDien;
        this.cachTinhDiem = cachTinhDiem;
    }

    public VongThi(String idVT, String tenVong, CachTinhDiem cachTinhDiem) {
        this.idVT = idVT;
        this.tenVong = tenVong;
        this.cachTinhDiem = cachTinhDiem;
        this.dsNhomTrinhDien = new ArrayList<NhomTrinhDien>();
    }
    public HashMap<ChiDep, Integer> getDiemThanhVienNhom(NhomTrinhDien nhomTrinhDien){
        HashMap<ChiDep, Integer> result = new HashMap<>();

        //lấy tir lệ chấm điểm
        double tiLeBGK = this.cachTinhDiem.getPhanTramDiemBGK();
        double tiLePhieuBau = this.cachTinhDiem.getPhanTramDiem();

        //lấy điểm từ bgk
        int diemBGK = (int)(nhomTrinhDien.getDiemNhom() * tiLeBGK);

        //tính điểm phiê bầucủa từng thành viên
        nhomTrinhDien.getPhieuBauThanhVien().forEach((thanhVien, soPhieu)->{
            int diemPhieuBau = (int)(soPhieu*tiLePhieuBau);
            result.put(thanhVien,diemPhieuBau+diemBGK );
        });
        return  result;
    }
    public String getIdVT() {
        return idVT;
    }

    public void setIdVT(String idVT) {
        this.idVT = idVT;
    }

    public String getTenVong() {
        return tenVong;
    }

    public void setTenVong(String tenVong) {
        this.tenVong = tenVong;
    }

    public ArrayList<NhomTrinhDien> getDsNhomTrinhDien() {
        return dsNhomTrinhDien;
    }

    public void setDsNhomTrinhDien(ArrayList<NhomTrinhDien> dsNhomTrinhDien) {
        this.dsNhomTrinhDien = dsNhomTrinhDien;
    }

    public CachTinhDiem getCachTinhDiem() {
        return cachTinhDiem;
    }

    public void setCachTinhDiem(CachTinhDiem cachTinhDiem) {
        this.cachTinhDiem = cachTinhDiem;
    }
}
