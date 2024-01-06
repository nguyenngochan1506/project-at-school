package GiuaKy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class ChiDep implements Comparable<ChiDep> {
    private String id;
    private String hoTen;
    private TreeSet<QuaTrinhLamNghe> dsNgheNghiep;
    private LinkedList<Integer> diemQuaTrinh;
    private boolean biLoai;
    private String tenVongBiLoai;

    public ChiDep(String id, String hoTen, TreeSet<QuaTrinhLamNghe> dsNgheNghiep, LinkedList<Integer> diemQuaTrinh, boolean biLoai, String tenVongBiLoai) {
        this.id = id;
        this.hoTen = hoTen;
        this.dsNgheNghiep = dsNgheNghiep;
        this.diemQuaTrinh = diemQuaTrinh;
        this.biLoai = biLoai;
        this.tenVongBiLoai = tenVongBiLoai;
    }

    public ChiDep(String id, String hoTen, boolean biLoai, String tenVongBiLoai) {
        this.id = id;
        this.hoTen = hoTen;
        this.biLoai = biLoai;
        this.tenVongBiLoai = tenVongBiLoai;
        this.dsNgheNghiep = new TreeSet<>();
        this.diemQuaTrinh = new LinkedList<>();
    }

    public ChiDep(String id, String hoTen, boolean biLoai) {
        this.id = id;
        this.hoTen = hoTen;
        this.biLoai = biLoai;
        this.diemQuaTrinh = new LinkedList<>();
        this.dsNgheNghiep = new TreeSet<>();
    }
    public double getDiemTrungBinh(){
        double result = 0;
        if(this.getDiemQuaTrinh().isEmpty()){
            return 0;
        }
        for(Integer diem : this.getDiemQuaTrinh()){
            result += diem;
        }
        return result/this.getDiemQuaTrinh().size();
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("ChiDep{" +
                "id='" + id + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", biLoai=" + biLoai +
                ", tenVongBiLoai='" + tenVongBiLoai + "\n" +
                "\t-dsDiemQuaTrinh=" + Arrays.toString(this.diemQuaTrinh.toArray()) +
                "\n\t-dsNgheNghiep= \n[");
        for(QuaTrinhLamNghe nn: this.dsNgheNghiep){
            result.append("\t"+nn.toString()+"\n");
        }
        result.append("]}");
        return result.toString();
    }

    public void themNgheNghiep(QuaTrinhLamNghe nn) {
        this.dsNgheNghiep.add(nn);
    }

    public void themDiemQuaTrinh(Integer diem) {
        this.diemQuaTrinh.add(diem);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public TreeSet<QuaTrinhLamNghe> getDsNgheNghiep() {
        return dsNgheNghiep;
    }

    public void setDsNgheNghiep(TreeSet<QuaTrinhLamNghe> dsNgheNghiep) {
        this.dsNgheNghiep = dsNgheNghiep;
    }

    public LinkedList<Integer> getDiemQuaTrinh() {
        return diemQuaTrinh;
    }

    public void setDiemQuaTrinh(LinkedList<Integer> diemQuaTrinh) {
        this.diemQuaTrinh = diemQuaTrinh;
    }

    public boolean isBiLoai() {
        return biLoai;
    }

    public void setBiLoai(boolean biLoai) {
        this.biLoai = biLoai;
    }

    public String getTenVongBiLoai() {
        return tenVongBiLoai;
    }

    public void setTenVongBiLoai(String tenVongBiLoai) {
        this.tenVongBiLoai = tenVongBiLoai;
    }

    @Override
    public int compareTo(ChiDep o) {
        if(this.getDiemTrungBinh() != o.getDiemTrungBinh()){
            return (int)(o.getDiemTrungBinh()-this.getDiemTrungBinh());
        }
        return o.getId().compareToIgnoreCase(this.getId());
    }


}
