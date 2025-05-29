package lab2;

import java.util.*;

class User {
    private String name;
    private double balance;
    private String address;

    public User(String name, double balance, String address) {
        this.name = name;
        this.balance = balance;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class Item {
    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Order {
    private User user;
    private ArrayList<Item> items;
    private double totalPrice;

    public Order(User user, ArrayList<Item> items, double totalPrice) {
        this.user = user;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setItem(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItem() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

class OrderService {
    public static Order addOrder(User user, ArrayList<Item> items) {
        double totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.getProduct().getPrice() * item.getQuantity();
        }

        if (user.getBalance() < totalPrice) {
            System.out.println("用户余额不足");
            return null;
        } else {
            user.setBalance(user.getBalance() - totalPrice);
            System.out.println(String.format("购买商品总额：%.2f", totalPrice));
            System.out.println(String.format("用户余额：%.2f", user.getBalance()));
            System.out.println(String.format("地址：%s", user.getAddress()));
            return new Order(user, items, totalPrice);
        }
    }
}

public class _6 {
    public static void main(String[] args) {
        Product p1 = new Product("方便面", 5.5);
        Product p2 = new Product("火腿肠", 2.2);
        Product p3 = new Product("矿泉水", 1.0);
        Product p4 = new Product("饮料", 3.5);
        HashMap<String, Product> products = new HashMap<String, Product>();
        products.put(p1.getName(), p1);
        products.put(p2.getName(), p2);
        products.put(p3.getName(), p3);
        products.put(p4.getName(), p4);

        try (Scanner sc = new Scanner(System.in)) {
            String line[] = sc.nextLine().trim().split("\\s+");
            String name = line[0];
            double balance = Double.parseDouble(line[1]);
            String address = line[2];
            User user = new User(name, balance, address);

            ArrayList<Item> items = new ArrayList<Item>();
            int n = sc.nextInt();
            sc.nextLine();
            while (n-- > 0) {
                String[] itemLine = sc.nextLine().trim().split("\\s+");
                String itemName = itemLine[0];
                int quantity = Integer.parseInt(itemLine[1]);
                items.add(new Item(products.get(itemName), quantity));
            }
            OrderService.addOrder(user, items);
        }
    }
}