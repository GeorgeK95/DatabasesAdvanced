package Problem_06_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name){
        if(name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if(product.getCost() > this.money) {
            System.out.println(this.name + " can't afford " + product.getName());
        } else {
            this.products.add(product);
            this.setMoney(this.money - product.getCost());
            System.out.println(this.name + " bought " + product.getName());
        }
    }

    @Override
    public String toString() {
        String result = this.name + " - ";
        if(this.products.size() == 0) {
            result += "Nothing bought";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Product product : products) {
                sb.append(product.getName()).append(", ");
            }
            result += sb.substring(0, sb.length() - 2);
        }
        return result;
    }
}
