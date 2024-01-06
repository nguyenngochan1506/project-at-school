import java.util.TreeSet;

public class CongDan implements Comparable<CongDan>{
    private String cccd;
    private String ngaySinh;
    private String queQuan;
    private TreeSet<Xe> dsSoHuu;

    public CongDan(String cccd, String ngaySinh, String queQuan, TreeSet<Xe> dsSoHuu) {
        this.cccd = cccd;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.dsSoHuu = dsSoHuu;
    }

    public CongDan(String cccd, String ngaySinh, String queQuan) {
        this.cccd = cccd;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.dsSoHuu = new TreeSet<>();
    }
    //phương thức thêm xe vào dssohuu
    public void themXe(Xe xe){
        this.dsSoHuu.add(xe);
    }
    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public TreeSet<Xe> getDsSoHuu() {
        return dsSoHuu;
    }
    public int getSoLuongXeSoHuu(){
        return this.dsSoHuu.size();
    }

    public void setDsSoHuu(TreeSet<Xe> dsSoHuu) {
        this.dsSoHuu = dsSoHuu;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(
                "CongDan{" +
                        "cccd='" + cccd + '\'' +
                        ", ngaySinh='" + ngaySinh + '\'' +
                        ", queQuan='" + queQuan + '\'' +
                        "\n, dsSoHuu= \n[ \n"
        );
        for(Xe x : this.dsSoHuu){
            result.append("\t"+x+"\n");
        }
        result.append("]}");
        return result.toString();
    }

    @Override
    public int compareTo(CongDan o) {
        if(this.getDsSoHuu().size() != o.getDsSoHuu().size()){
            return o.getDsSoHuu().size() - this.getDsSoHuu().size();
        }
        return o.getCccd().compareToIgnoreCase(this.getCccd());
    }
}
