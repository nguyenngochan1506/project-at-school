package GiuaKy;

import java.util.*;
import java.util.stream.Collectors;

public class CuocThi {
    private ArrayList<ChiDep> dsChiDep;
    private ArrayList<VongThi> dsVongThi;
    private String tenCuocThi;
    private int namToChuc;

    public CuocThi(ArrayList<ChiDep> dsChiDep, ArrayList<VongThi> dsVongThi, String tenCuocThi, int namToChuc) {
        this.dsChiDep = dsChiDep;
        this.dsVongThi = dsVongThi;
        this.tenCuocThi = tenCuocThi;
        this.namToChuc = namToChuc;
    }

    public CuocThi(String tenCuocThi, int namToChuc) {
        this.tenCuocThi = tenCuocThi;
        this.namToChuc = namToChuc;
        this.dsVongThi = new ArrayList<>();
        this.dsChiDep = new ArrayList<>();
    }

    public void themVongThi(VongThi v) {
        this.dsVongThi.add(v);
    }

    public void themChiDep(ChiDep c) {
        this.dsChiDep.add(c);
    }

    @Override
    public String toString() {
        StringBuilder listVongThi = new StringBuilder("[");
        this.dsVongThi.forEach(vongThi -> {
            listVongThi.append(vongThi.getTenVong() + ", ");
        });

        StringBuilder listChiDep = new StringBuilder("[");
        this.dsChiDep.forEach(chiDep -> {
            listChiDep.append(chiDep.getHoTen() + ", ");
        });
        return "CuocThi{" +
                "\n\tdsChiDep=" + listChiDep.substring(0, listChiDep.length() - 2) + "]" +
                "\n\tdsVongThi=" + listVongThi.substring(0, listVongThi.length() - 2) + "]" +
                "\n\ttenCuocThi='" + tenCuocThi + '\'' +
                "\n\tnamToChuc=" + namToChuc +
                '}';
    }

    public ArrayList<ChiDep> getDsChiDep() {
        return dsChiDep;
    }

    public void setDsChiDep(ArrayList<ChiDep> dsChiDep) {
        this.dsChiDep = dsChiDep;
    }

    public ArrayList<VongThi> getDsVongThi() {
        return dsVongThi;
    }

    public void setDsVongThi(ArrayList<VongThi> dsVongThi) {
        this.dsVongThi = dsVongThi;
    }

    public String getTenCuocThi() {
        return tenCuocThi;
    }

    public void setTenCuocThi(String tenCuocThi) {
        this.tenCuocThi = tenCuocThi;
    }

    public int getNamToChuc() {
        return namToChuc;
    }

    public void setNamToChuc(int namToChuc) {
        this.namToChuc = namToChuc;
    }

    public HashMap<ChiDep, LinkedList<Integer>> thongKeChiDep_danhSachDiemSo() {
        HashMap<ChiDep, LinkedList<Integer>> result = new HashMap<>();

        for (ChiDep cd : this.dsChiDep) {
            LinkedList<Integer> dsDiem = new LinkedList<>();
            for (VongThi vt : this.dsVongThi) {
                dsDiem.addAll(layDiemTheoVongThi(vt, cd));
            }
            result.put(cd, dsDiem);
        }
        return result;
    }

    private LinkedList<Integer> layDiemTheoVongThi(VongThi vongThi, ChiDep chiDep) {
        LinkedList<Integer> result = new LinkedList<>();
        vongThi.getDsNhomTrinhDien().forEach(nhomTrinhDien -> {
            result.add((vongThi.getDiemThanhVienNhom(nhomTrinhDien).get(chiDep) != null ? vongThi.getDiemThanhVienNhom(nhomTrinhDien).get(chiDep) : 0));
        });
        return result;
    }

//    public HashMap<VongThi, Integer> thongKeChiDepBiLoai(){
//
//    }
    public LinkedList<ChiDep> loaiChiDep(VongThi vt, int slg){
        LinkedList<ChiDep> dsBiLoai = new LinkedList<>();

        //lấy ra  điểm của từng thành viên trong vòng đó
        HashMap<ChiDep, Integer> dsDiem = new HashMap<>();
        for(ChiDep cd : this.dsChiDep){
            dsDiem.put(cd, getTongDiemDiemCua1VongThi(cd, vt));
        }
        //sau khi có tổng điểm của từng vòng thi ta tiến hành xoá người thấp điểm nhất
        // Sắp xếp danh sách điểm theo thứ tự tăng dần
        List<Map.Entry<ChiDep, Integer>> sortedEntries = dsDiem.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        // Lấy slg chiếc đẹp có điểm thấp nhất
        List<Map.Entry<ChiDep, Integer>> limitedEntries = sortedEntries.subList(0, Math.min(slg, sortedEntries.size()));

        // Set thuộc tính bị loại và vòng bị loại cho các chị đẹp
        limitedEntries.forEach(entry -> {
            ChiDep chiDep = entry.getKey();
            int tongDiem = entry.getValue();

            chiDep.setBiLoai(true);
            chiDep.setTenVongBiLoai(vt.getTenVong());

            // Thêm vào danh sách bị loại
            dsBiLoai.add(chiDep);
        });
        return dsBiLoai;
    }
    private Integer getTongDiemDiemCua1VongThi(ChiDep chiDep, VongThi vt){
        Integer result = 0;
        for(NhomTrinhDien nhom : vt.getDsNhomTrinhDien()){
            result += (vt.getDiemThanhVienNhom(nhom).get(chiDep)!=null)?vt.getDiemThanhVienNhom(nhom).get(chiDep):0;
        }
        return result;
    }
    public HashMap<VongThi, Integer> thongKeChiDepBiLoai(){
        HashMap<VongThi, Integer> result = new HashMap<>();
        for(VongThi vt: this.dsVongThi){
            Integer temp  = 0;
            for(ChiDep cd: this.dsChiDep){
                if(cd.isBiLoai() && cd.getTenVongBiLoai().equals(vt.getTenVong())){
                    temp++;
                }
            }
            result.put(vt, temp);
        }
        return  result;
    }

    public TreeSet<ChiDep> getSetTongDiemChiDep(){
        TreeSet<ChiDep> result = new TreeSet<>();
        result.addAll(this.dsChiDep);
        return result;
    }
    public TreeSet<ChiDep> getSetChiDepVongThi(VongThi vt){
        TreeSet<ChiDep> result = new TreeSet<>();
        for (NhomTrinhDien nhomTrinhDien : vt.getDsNhomTrinhDien()) {
            result.addAll(nhomTrinhDien.getDsThanhVien());
        }
        return result;
    }

    public TreeSet<NhomTrinhDien> sortNhomDiemSo(){
        TreeSet<NhomTrinhDien> result = new TreeSet<>();
        for (VongThi vongThi : this.dsVongThi) {
            for (NhomTrinhDien nhomTrinhDien : vongThi.getDsNhomTrinhDien()) {
                result.add(nhomTrinhDien);
            }
        }
        return result;
    }
}
