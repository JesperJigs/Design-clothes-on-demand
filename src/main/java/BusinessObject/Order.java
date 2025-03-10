package BusinessObject;

import Builder.Product;
import java.util.ArrayList;
import java.util.List;

public class Order extends BusinessObject {
    private List<Product> products = new ArrayList<>();
    private Customer customer;

    public Order() {
        this.id = "Order " +System.currentTimeMillis();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
