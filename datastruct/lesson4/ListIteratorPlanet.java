package lesson4;

import java.util.Arrays;
import java.util.ListIterator;
import java.util.Random;

public class ListIteratorPlanet {
    private static ListIterator<Planet> listInterPlanet;
    private int size = 0;
    public ListIteratorPlanet(Planet[] listPlanet){
        listInterPlanet = Arrays.asList(listPlanet).listIterator();
        this.size = listPlanet.length;
    }

    @Override
    public String toString() {
        //vì mỗi lần in xong poiter sẽ ở cuối danh sách nên ta sẽ cần gọi nó về đầu lại môi lần gọi
        refesh();
        StringBuilder result = new StringBuilder();
        while (listInterPlanet.hasNext()){
            result.append(listInterPlanet.next()).append("\n");
        }
        return result.toString();
    }

    private void refesh() {
        while(listInterPlanet.hasPrevious()){
            listInterPlanet.previous();
        }
    }

    public Planet ngoiSaoCoDienTichLonNhat(){
        refesh();
        //lấy ra hành tinh đầu tiên
        Planet result = listInterPlanet.next();//giả định hành tinh đầu có diện tích lớn nhất

        while (listInterPlanet.hasNext()){
            Planet temp = listInterPlanet.next(); //lấy ra hành tinh thứ hai để so sánh => poiter sẽ ở vị trí tiếp theo
            if(temp.getDienTich() > result.getDienTich()){
                result = temp;
            }
        }
        return result;
    }

    public Planet ngoiSaoCoKhoiLuongLonNhat(){
        refesh();
        Planet result = listInterPlanet.next();
        while (listInterPlanet.hasNext()){
            Planet temp = listInterPlanet.next();
            if(temp.getKhoiLuong() > result.getKhoiLuong()){
                result = temp;
            }
        }
        return  result;
    }
    public Planet ngoiSaoCoChuKyLonNhat(){
        refesh();
        Planet result = listInterPlanet.next();
        while (listInterPlanet.hasNext()){
            Planet temp = listInterPlanet.next();
            if(temp.getChuKy() > result.getChuKy()){
                result = temp;
            }
        }
        return  result;
    }

    public Planet timNgoiSaoTheoTen(String tenHanhTinh){
        refesh();
        Planet result = null;
        while (listInterPlanet.hasNext()){
            Planet planet = listInterPlanet.next();
            String tenTiengViet = planet.getTenTiengViet();
            String tenTiengAnh = planet.getTenTiengAnh();
            if(tenHanhTinh.equalsIgnoreCase(tenTiengAnh) || tenHanhTinh.equalsIgnoreCase(tenTiengViet)){
                result = planet;
            }
        }
        return result;
    }

    public Planet layNgauNhienMotNgoiSao(){
        refesh();
        int randomViTri = new Random().nextInt(size); //tạo ngẫu nhiên vị trí cần lấy
        int step = 0;
        Planet result = null;

        while (step<=randomViTri){
            if(listInterPlanet.hasNext()){
                result = listInterPlanet.next();
            }
            step++;
        }
        return result;
    }
    //phương thức so sánh chu kì của một hành tinh đối với các hành tinh còn lại
    public String soSanhChuKy(Planet planet) {
        refesh();
        StringBuilder result = new StringBuilder();
        //lấy ra chu kì của hành tinh cần so sánh
        double chuKy = planet.getChuKy();

        //đem đi so lần luot với các hành tinh khác
        while (listInterPlanet.hasNext()) {
            Planet comparePlanet = listInterPlanet.next();
            if (!comparePlanet.equals(planet)) {
                if (chuKy > comparePlanet.getChuKy()) {
                    result.append(String.format("Chu kỳ của %s nhanh hơn %s khoảng %.3f lần \n", planet.getTenTiengViet(), comparePlanet.getTenTiengViet(), (chuKy / comparePlanet.getChuKy()) ));
                } else {
                    result.append(String.format("Chu kỳ của %s chậm hơn %s khoảng %.3f lần \n", planet.getTenTiengViet(), comparePlanet.getTenTiengViet(), (comparePlanet.getChuKy() / chuKy) ));
                }
            }
        }
        return result.toString();

    }
}
