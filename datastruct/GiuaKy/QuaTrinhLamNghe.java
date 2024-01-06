package GiuaKy;

public class QuaTrinhLamNghe implements Comparable<QuaTrinhLamNghe>{
    private String maNN;
    private String tenNN;
    private int namBD;

    public QuaTrinhLamNghe(String maNN, String tenNN, int namBD) {
        this.maNN = maNN;
        this.tenNN = tenNN;
        this.namBD = namBD;
    }

    @Override
    public String toString() {
        return "QuaTrinhLamNghe{" +
                "maNN='" + maNN + '\'' +
                ", tenNN='" + tenNN + '\'' +
                ", namBD=" + namBD +
                '}';
    }

    public String getMaNN() {
        return maNN;
    }

    public void setMaNN(String maNN) {
        this.maNN = maNN;
    }

    public String getTenNN() {
        return tenNN;
    }

    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }

    public int getNamBD() {
        return namBD;
    }

    public void setNamBD(int namBD) {
        this.namBD = namBD;
    }

    @Override
    public int compareTo(QuaTrinhLamNghe o) {
        int result = this.getNamBD() - o.getNamBD();
        if (result != 0){
            return result;
        }
        return this.getMaNN().compareToIgnoreCase(o.getMaNN());
    }
}
