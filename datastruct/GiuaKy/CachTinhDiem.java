package GiuaKy;

public class CachTinhDiem {
    private double phanTramDiemBGK;
    private double phanTramDiem;

    public CachTinhDiem(double phanTramDiemBGK, double phanTramDiem) {
        this.phanTramDiemBGK = phanTramDiemBGK;
        this.phanTramDiem = phanTramDiem;
    }

    public double getPhanTramDiemBGK() {
        return phanTramDiemBGK;
    }

    public void setPhanTramDiemBGK(double phanTramDiemBGK) {
        this.phanTramDiemBGK = phanTramDiemBGK;
    }

    public double getPhanTramDiem() {
        return phanTramDiem;
    }

    public void setPhanTramDiem(double phanTramDiem) {
        this.phanTramDiem = phanTramDiem;
    }
}
