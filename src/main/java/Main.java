import BusinessObject.CEO;
import BusinessObject.Customer;
import Controller.OrderProcess;
import View.PrintView;

public class Main {
    public static void main(String[] args) {


        PrintView printView = new PrintView();
        CEO ceo = new CEO();
        ceo.setName("Bill Clinton");
        Customer customer = new Customer();
        customer.setId("001");
        customer.setName("Elvis Presley");
        customer.setAddress("Kings Road 56, Graceland");
        customer.setEmail("elvispresley@gmail.com");

        OrderProcess orderProcess = new OrderProcess(printView,ceo,customer);

        orderProcess.startOrder();








    }
}
