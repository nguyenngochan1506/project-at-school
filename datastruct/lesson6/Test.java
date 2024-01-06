package lesson6;

public class Test {
    public static void main(String[] args) {
        Order bag = new Order();
        bag.createData();
        System.out.println(bag.findByQuantity(3));
    }
}
