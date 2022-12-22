import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();

        CustomerFactory customerFactory = new CustomerFactory(5000, 50, customers);
        customerFactory.start();

        Cashier cashier1 = new Cashier(1000,customers );
        cashier1.start();


    }


}
