package BusinessObject;

import Builder.Pants;
import Builder.Product;
import Builder.Skirt;
import Builder.Tshirt;

import java.util.List;

public class Receipt extends BusinessObject {

    private Order order;

    public Receipt(Order order) {
        this.order = order;
    }

    public void printReceipt() {
        if (order == null || order.getProducts().isEmpty()) {
            System.out.println("No products have been ordered");
            return;
        }

        System.out.println("\n#### RECEIPT ####");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Address: " + order.getCustomer().getAddress());
        System.out.println("Email: " + order.getCustomer().getEmail());
        System.out.println("\nOrdered Products: ");

        List<Product> products = order.getProducts();
        for (Product product : products) {
            System.out.println("\nProduct: " + product.getName());
            System.out.println("Material: " + product.getMaterial());
            System.out.println("Size: " + product.getSize());
            System.out.println("Color: " + product.getColor());

            if (product instanceof Pants) {
                Pants pants = (Pants) product;
                System.out.println("Fit: " + pants.getFit());
                System.out.println("Length: " + pants.getLength());
            }else if (product instanceof Tshirt) {
                Tshirt tshirt = (Tshirt) product;
                System.out.println("Neck: " + tshirt.getNeck());
                System.out.println("Sleeves: " + tshirt.getSleeves());

            } else if (product instanceof Skirt) {
                Skirt skirt = (Skirt) product;
                System.out.println("Waistline: " + skirt.getWaistline());
                System.out.println("Pattern: " + skirt.getPattern());

            }
            System.out.println("Price: $" + product.getPrice());

            System.out.println("--------------------------");


        }

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