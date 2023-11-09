package lesson4;

import java.util.Objects;

public class Planet {
    private String tenTiengViet;
    private String tenTiengAnh;
    private double chuKy;
    private double dienTich;
    private double khoiLuong;

    public Planet(String tenTiengViet, String tenTiengAnh, double chuKy, double dienTich, double khoiLuong) {
        this.tenTiengViet = tenTiengViet;
        this.tenTiengAnh = tenTiengAnh;
        this.chuKy = chuKy;
        this.dienTich = dienTich;
        this.khoiLuong = khoiLuong;
    }

    public String getTenTiengViet() {
        return tenTiengViet;
    }

    public void setTenTiengViet(String tenTiengViet) {
        this.tenTiengViet = tenTiengViet;
    }

    public String getTenTiengAnh() {
        return tenTiengAnh;
    }

    public void setTenTiengAnh(String tenTiengAnh) {
        this.tenTiengAnh = tenTiengAnh;
    }

    public double getChuKy() {
        return chuKy;
    }

    public void setChuKy(double chuKy) {
        this.chuKy = chuKy;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public double getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(double khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "tenTiengViet='" + tenTiengViet + '\'' +
                ", tenTiengAnh='" + tenTiengAnh + '\'' +
                ", chuKy=" + chuKy +
                ", dienTich=" + dienTich +
                ", khoiLuong=" + khoiLuong +" *10^24 (kg)"+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(tenTiengViet, planet.tenTiengViet) && Objects.equals(tenTiengAnh, planet.tenTiengAnh);
    }

}
