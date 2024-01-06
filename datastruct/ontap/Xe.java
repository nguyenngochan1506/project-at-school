public class Xe implements Comparable<Xe>{
    private String bangSo;
    private String loaiXe;
    private boolean dangSuDung;
    private boolean suDungXang;
    private int namDK;

    public Xe(String bangSo, String loaiXe, boolean dangSuDung, boolean suDungXang, int namDK) {
        this.bangSo = bangSo;
        this.loaiXe = loaiXe;
        this.dangSuDung = dangSuDung;
        this.suDungXang = suDungXang;
        this.namDK = namDK;
    }

    @Override
    public String toString() {
        return "Xe{" +
                "bangSo='" + bangSo + '\'' +
                ", loaiXe='" + loaiXe + '\'' +
                ", dangSuDung=" + dangSuDung +
                ", suDungXang=" + suDungXang +
                ", namDK=" + namDK +
                '}';
    }

    public String getBangSo() {
        return bangSo;
    }

    public void setBangSo(String bangSo) {
        this.bangSo = bangSo;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public boolean isDangSuDung() {
        return dangSuDung;
    }

    public void setDangSuDung(boolean dangSuDung) {
        this.dangSuDung = dangSuDung;
    }

    public boolean isSuDungXang() {
        return suDungXang;
    }

    public void setSuDungXang(boolean suDungXang) {
        this.suDungXang = suDungXang;
    }

    public int getNamDK() {
        return namDK;
    }

    public void setNamDK(int namDK) {
        this.namDK = namDK;
    }

    @Override
    public int compareTo(Xe o) {
        if(this.getNamDK() != o.getNamDK()){
            return this.getNamDK() - o.getNamDK();
        }
        return this.getBangSo().compareToIgnoreCase(o.getBangSo());
    }
}
