package lesson4;

public class Test {
    public static void main(String[] args) {

        // Thêm các đối tượng Planet vào danh sách
        Planet mecury = new Planet("Sao Thủy", "Mercury", 88, 0.056, 0.330);
        Planet venus = new Planet("Sao Kim", "Venus", 225, 0.86, 4.689);
        Planet earth = new Planet("Trái Đất", "Earth", 365, 1.0, 5.974);
        Planet mars =  new Planet("Sao Hoả", "Mars", 687, 0.15, 0.642);
        Planet jupiter = new Planet("Sao Mộc", "Jupiter", 4333, 317.8, 1899);
        Planet saturn = new Planet("Sao Kim", "Saturn", 10759, 95.2, 568.46);
        Planet uranus = new Planet("Sao Thiên Vương", "Uranus", 30687, 14.5, 86.832);

        // Tạo danh sách chứa thông tin về tất cả các hành tinh trong hệ Mặt Trời
        ListIteratorPlanet listIteratorPlanet = new ListIteratorPlanet(new Planet[]{mecury, venus, earth, mars, jupiter, saturn, uranus });

        System.out.printf("Câu1: \n \t Hành Tinh Có diện tích lớn nhất là: %s \n", listIteratorPlanet.ngoiSaoCoDienTichLonNhat());
        System.out.printf("Câu2: \n \t Hành Tinh Có khối lượng lớn nhất là: %s \n", listIteratorPlanet.ngoiSaoCoKhoiLuongLonNhat());
        System.out.printf("Câu3: \n \t Hành Tinh Có Chu kỳ lớn nhất là: %s \n", listIteratorPlanet.ngoiSaoCoChuKyLonNhat());
        System.out.printf("Câu3: \n \t Tìm hành tinh theo tên tiếng Việt hoặc Anh: %s \n", listIteratorPlanet.timNgoiSaoTheoTen("sao hoả"));
        System.out.printf("Câu4: \n \t Lấy ngẫu nhiên 1 hành tinh trong danh sách: %s \n", listIteratorPlanet.layNgauNhienMotNgoiSao());
        System.out.printf("Câu5: So sánh chu kỳ quay của trái đất đối với các hành tinh khác \n " +
                "\t- Lấy ra hành tinh trái đất: %s \n" +
                "\t- tiến hành so sánh: \n" +
                "%s", earth, listIteratorPlanet.soSanhChuKy(earth));
    }

}
