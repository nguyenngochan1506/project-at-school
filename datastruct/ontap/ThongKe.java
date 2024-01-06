import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ThongKe {
    private ArrayList<HoKhau> dsHoKhau;

    public ThongKe() {
        this.dsHoKhau = new ArrayList<>();
    }

    public ThongKe(ArrayList<HoKhau> dsHoKhau) {
        this.dsHoKhau = dsHoKhau;
    }

    public ArrayList<HoKhau> getDsHoKhau() {
        return dsHoKhau;
    }

    public void themHoKhau(HoKhau hoKhau) {
        this.dsHoKhau.add(hoKhau);

    }

    @Override
    public String toString() {
        return "ThongKe{" +
                "dsHoKhau=" + dsHoKhau +
                '}';
    }

    public void setDsHoKhau(ArrayList<HoKhau> dsHoKhau) {
        this.dsHoKhau = dsHoKhau;
    }

    public int getSoLuong_LoaiXe_Tinh(String loaiXe, String tinh) {
        int count = 0;
        for (HoKhau hoKhau : this.dsHoKhau) {
            if (hoKhau.getTinh().equalsIgnoreCase(tinh)) {
                for (CongDan congDan : hoKhau.getDsThanhVien()) {
                    count += congDan.getSoLuongXeSoHuu();
                }
            }
        }
        return count;
    }
}
