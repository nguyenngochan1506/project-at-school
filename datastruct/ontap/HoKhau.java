import java.util.TreeSet;

public class HoKhau {
    private String maHK;
    private CongDan chuHo;
    private TreeSet<CongDan> dsThanhVien;
    private String soNha;
    private String phuong;
    private String quan;
    private String tinh;

    public HoKhau(String maHK, CongDan chuHo, TreeSet<CongDan> dsThanhVien, String soNha, String phuong, String quan, String tinh) {
        this.maHK = maHK;
        this.chuHo = chuHo;
        this.dsThanhVien = dsThanhVien;
        this.soNha = soNha;
        this.phuong = phuong;
        this.quan = quan;
        this.tinh = tinh;
    }

    public HoKhau(String maHK, CongDan chuHo, String soNha, String phuong, String quan, String tinh) {
        this.maHK = maHK;
        this.chuHo = chuHo;
        this.soNha = soNha;
        this.phuong = phuong;
        this.quan = quan;
        this.tinh = tinh;
        this.dsThanhVien =  new TreeSet<>();
    }

    @Override
    public String toString() {
        return "HoKhau{" +
                "maHK='" + maHK + '\'' +
                ", chuHo=" + chuHo +
                ", dsThanhVien=" + dsThanhVien +
                ", soNha='" + soNha + '\'' +
                ", phuong='" + phuong + '\'' +
                ", quan='" + quan + '\'' +
                ", tinh='" + tinh + '\'' +
                '}';
    }
public void themThanhVien(CongDan congDan){
        this.dsThanhVien.add(congDan);
}
    public String getMaHK() {
        return maHK;
    }

    public void setMaHK(String maHK) {
        this.maHK = maHK;
    }

    public CongDan getChuHo() {
        return chuHo;
    }

    public void setChuHo(CongDan chuHo) {
        this.chuHo = chuHo;
    }

    public TreeSet<CongDan> getDsThanhVien() {
        return dsThanhVien;
    }

    public void setDsThanhVien(TreeSet<CongDan> dsThanhVien) {
        this.dsThanhVien = dsThanhVien;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

}
