package GiuaKy;

import java.util.*;
import java.util.stream.Collectors;

public class NhomTrinhDien implements Comparable<NhomTrinhDien>{
    private String loaiNhom;
    private String tenBaiHat;
    private String tenBienDao;
    private int diemNhom;
    private ChiDep nhomTruong;
    private LinkedList<ChiDep> dsThanhVien;
    private HashMap<ChiDep, Integer> phieuBauThanhVien;
    private String trangThaiNhom;

    public NhomTrinhDien(String loaiNhom, String tenBaiHat, String tenBienDao) {
        this.loaiNhom = loaiNhom;
        this.tenBaiHat = tenBaiHat;
        this.tenBienDao = tenBienDao;
        this.dsThanhVien = new LinkedList<>();
        this.phieuBauThanhVien = new HashMap<>();
    }

    public String getLoaiNhom() {
        return loaiNhom;
    }

    public void setLoaiNhom(String loaiNhom) {
        this.loaiNhom = loaiNhom;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getTenBienDao() {
        return tenBienDao;
    }

    public void setTenBienDao(String tenBienDao) {
        this.tenBienDao = tenBienDao;
    }

    public int getDiemNhom() {
        return diemNhom;
    }

    public void setDiemNhom(int diemNhom) {
        this.diemNhom = diemNhom;
    }

    public ChiDep getNhomTruong() {
        return nhomTruong;
    }
    public void themThanhVien(ChiDep cd){
        this.dsThanhVien.add(cd);
    }
    public void setNhomTruong(ChiDep nhomTruong) {
        this.nhomTruong = nhomTruong;
        this.dsThanhVien.add(nhomTruong);
    }

    public LinkedList<ChiDep> getDsThanhVien() {
        return dsThanhVien;
    }

    public void setDsThanhVien(LinkedList<ChiDep> dsThanhVien) {
        this.dsThanhVien = dsThanhVien;
    }

    public HashMap<ChiDep, Integer> getPhieuBauThanhVien() {
        return phieuBauThanhVien;
    }

    public void setPhieuBauThanhVien(HashMap<ChiDep, Integer> phieuBauThanhVien) {
        this.phieuBauThanhVien = phieuBauThanhVien;
    }
    public void setPhieuBauTV(ChiDep cd, Integer soLuongPhieu) {
        if(!this.dsThanhVien.contains(cd)){
            this.themThanhVien(cd);
        }
        this.phieuBauThanhVien.put(cd, soLuongPhieu);
    }

    public String getTrangThaiNhom() {
        return trangThaiNhom;
    }

    public void setTrangThaiNhom(String trangThaiNhom) {
        this.trangThaiNhom = trangThaiNhom;
    }

    /**
     * hàm sắp xếp dsthanhvien theo thứ tự điểm tăng dần
     */
    public void sortDsThanhVien(){
        Collections.sort(this.dsThanhVien, Comparator.comparing(ChiDep::getDiemTrungBinh));
    }
    public LinkedList<ChiDep> loaiThanhVien(int soLuong){
        this.sortDsThanhVien();
        LinkedList<ChiDep> dsDaXoa = new LinkedList<>();
        int temp = soLuong;
        ListIterator<ChiDep> inter = this.dsThanhVien.listIterator();
        while (temp >0 && inter.hasNext()){
            dsDaXoa.add(inter.next());
            inter.remove();
            temp--;
        }
        return dsDaXoa;
    }
    @Override
    public String toString() {
        String truongNhom = (this.nhomTruong!=null)?this.nhomTruong.getHoTen():"Không có";
        StringBuilder phieuBauTV = new StringBuilder("[");
        this.phieuBauThanhVien.forEach((thanhVien, soPhieu)->{
            phieuBauTV.append("{"+thanhVien.getHoTen() + ", "+soPhieu+" phiếu},");
        });
        phieuBauTV.append("]");
        return "NhomTrinhDien{" +
                "\n\tloaiNhom='" + loaiNhom + '\'' +
                ", \n\ttenBaiHat='" + tenBaiHat + '\'' +
                ", \n\ttenBienDao='" + tenBienDao + '\'' +
                ", \n\tdiemNhom=" + diemNhom +
                ", \n\tnhomTruong=" + truongNhom +
                ", \n\tdsThanhVien=" + dsThanhVien.stream().map(thanhvien -> thanhvien.getHoTen()).collect(Collectors.toList()).toString() +
                ", \n\tphieuBauThanhVien=" + phieuBauTV +
                ", \n\ttrangThaiNhom='" + trangThaiNhom + '\'' +
                "\n}";
    }

    @Override
    public int compareTo(NhomTrinhDien o) {
        if(this.getDiemNhom() != o.getDiemNhom()){
            return (int)(o.getDiemNhom()-this.getDiemNhom());
        }
        return o.getTenBaiHat().compareToIgnoreCase(this.getTenBaiHat());
    }
}
