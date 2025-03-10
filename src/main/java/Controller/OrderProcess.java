package Controller;

import Builder.*;
import BusinessObject.CEO;
import BusinessObject.Customer;
import BusinessObject.Order;
import BusinessObject.Receipt;
import Command.*;
import Observer.ProductUpdate;
import View.PrintView;

public class OrderProcess {
    private PrintView printView;
    private CEO ceo;
    private ProductUpdate productUpdate;
    private Processor processor;
    private Order order;
    private Customer customer;

    public OrderProcess() {
    }

    public OrderProcess(PrintView printView, CEO ceo, Customer customer) {
        this.printView = printView;
        this.ceo = ceo;
        this.productUpdate = new ProductUpdate();
        this.processor = new Processor();
        this.order = new Order();
        this.customer = customer;
        order.setCustomer(customer);

        productUpdate.addPropertyChangeListener(ceo);
    }

    public void startOrder() {
        printView.display("Welcome " + customer.getName() + " to Clothes-On-Demand webshop!");
        printView.display("----------------------------------------");

        printView.display("Customer: " + customer.getName());
        printView.display("Address: " + customer.getAddress());
        printView.display("Email: " + customer.getEmail());
        printView.display(" ");

        printView.display("1. Pants");
        printView.display("2. T-Shirt");
        printView.display("3. Skirt");

        int choice = correctInput("Select the item you want to order: ", 1, 3);
        Product product = createProduct(choice);
        productUpdate.notifyPropertyChange("NewOrder", null, product.getClass().getSimpleName());


        if (product == null) return;

        customizeProduct(product);
        order.addProduct(product);
        notCompleteOrder();
    }

    private Product createProduct(int choice) {
        String material = getMaterial();
        String size = getSize();
        String color = getColor();

        Product product = switch (choice) {
            case 1 -> new PantsBuilder().setMaterial(material).setSize(size).setColor(color).build();
            case 2 -> new TshirtBuilder().setMaterial(material).setSize(size).setColor(color).build();
            case 3 -> new SkirtBuilder().setMaterial(material).setSize(size).setColor(color).build();
            default -> null;
        };

        if (product == null) {
            printView.display("Invalid choice");
            return null;
        }
        return product;
    }

    private void customizeProduct(Product product) {
        String fit = null;
        String length = null;
        String neck = null;
        String sleeve = null;
        String waistline = null;
        String pattern = null;

        if (product instanceof Pants) {
            printView.display("\nSelect fit:");
            printView.display("1. Slim");
            printView.display("2. Loose");

            int fitChoice = correctInput("", 1, 2);
            fit = fitChoice == 1 ? "Slim" : "Loose";
            processor.add(new PantsFit(fit));
            processor.process(product);
            processor.clear();


            printView.display("\nSelect length:");
            printView.display("1. Short");
            printView.display("2. Long");

            int lengthChoice = correctInput("", 1, 2);
            length = lengthChoice == 1 ? "Short" : "Long";
            processor.add(new PantsLength(length));
            processor.process(product);
            processor.clear();


        } else if (product instanceof Tshirt) {
            printView.display("\nSelect neck type:");
            printView.display("1. V-shape");
            printView.display("2. Rounded");

            int neckChoice = correctInput("", 1, 2);
            neck = neckChoice == 1 ? "V-shape" : "Rounded";
            processor.add(new TshirtNeck(neck));
            processor.process(product);
            processor.clear();

            printView.display("\nSelect sleeve length:");
            printView.display("1. Short");
            printView.display("2. Long");

            int sleeveChoice = correctInput("", 1, 2);
            sleeve = sleeveChoice == 1 ? "Short" : "Long";
            processor.add(new TshirtSleeve(sleeve));
            processor.process(product);
            processor.clear();

        } else if (product instanceof Skirt) {
            printView.display("\nSelect waistline:");
            printView.display("1. Narrow");
            printView.display("2. Wide");

            int waistChoice = correctInput("", 1, 2);
            waistline = waistChoice == 1 ? "Narrow" : "Wide";
            processor.add(new SkirtWaistline(waistline));
            processor.process(product);
            processor.clear();

            printView.display("\nSelect pattern:");
            printView.display("1. Stripes");
            printView.display("2. Stars");

            int patternChoice = correctInput ("", 1, 2);
            pattern = patternChoice == 1 ? "Stripes" : "Stars";
            processor.add(new SkirtPattern(pattern));
            processor.process(product);
            processor.clear();
        }

        printView.display("");

        productUpdate.notifyPropertyChange("OrderReady", null, product.getClass().getSimpleName());
    }

    private void notCompleteOrder() {
        if (order.getProducts().isEmpty()) {
            printView.display("Order is missing products");
            return;
        }

        Receipt receipt = new Receipt(order);
        receipt.printReceipt();

        order = new Order();
    }

    private String getMaterial() {
        int choice = correctInput("Choose material: \n1. Cotton \n2. Denim \n3. Leather", 1, 3);
        return switch (choice) {
            case 1 -> "Cotton";
            case 2 -> "Denim";
            case 3 -> "Leather";
            default -> "Unknown";
        };
    }

    private String getSize() {
        int choice = correctInput("Choose size: \n1. Small\n2. Medium\n3. Large", 1, 3);
        return switch (choice) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "Unknown";
        };
    }

    private String getColor() {
        int choice = correctInput("Choose color: \n1. Black\n2. Blue\n3. Red", 1, 3);
        return switch (choice) {
            case 1 -> "Black";
            case 2 -> "Blue";
            case 3 -> "Red";
            default -> "Unknown";
        };
    }

    private int correctInput(String prompt, int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(printView.customerInput(prompt));
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    printView.display("Incorrect input, select a number between " + min + " and " + max);
                }
            } catch (NumberFormatException e) {
                printView.display("Incorrect input, input needs to be a number");
            }
        }
    }
}
