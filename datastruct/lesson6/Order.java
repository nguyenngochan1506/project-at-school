package lesson6;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Order {
    private TreeSet<OrderItem> bag = new TreeSet<>();
    public Order(){};


    public void addItem(OrderItem orderItem){
        this.bag.add(orderItem);
    }
    public void removeItem(OrderItem orderItem){
        this.bag.remove(orderItem);
    }
    public OrderItem findItemByName(String name){
        for(OrderItem item: bag){
            if(item.getName().equalsIgnoreCase(name)){
                return item;
            }
        }
        return null;
    }

    public List<OrderItem> searchItemByName(String name){
        return bag.stream().filter(item -> item.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }
    public List<OrderItem> findByQuantity(int quantity){
        return bag.stream().filter(item -> item.getQuantity() > quantity).collect(Collectors.toList());
    }
    public void createData() {
        OrderItem[] listItem = {
                new OrderItem(5, "Item 5", 2, 1),
                new OrderItem(3, "Item 3", 4, 4),
                new OrderItem(2, "Item 2", 5, 7),
                new OrderItem(4, "Item 4", 23, 2),
                new OrderItem(1, "Item 1", 5, 5)
        };
        bag.addAll(List.of(listItem));
    }
    public TreeSet<OrderItem> getBag() {
        return bag;
    }

    public void setBag(TreeSet<OrderItem> bag) {
        this.bag = bag;
    }

    @Override
    public String toString() {
        return "Order{ \n" +
                "bag=" + bag +
                "\n}";
    }
}
