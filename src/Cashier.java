import java.util.ArrayList;
import java.util.Stack;
public class Cashier extends Thread {

    private long TimeStarttoCheck;
    private long CheckTime;
    private long minCheckTime = 1000;
    private long maxCheckTime = 5000;
    private long entertime;
    private long leavetime;

    private long nextAttempt;
    private long timeSlice;
    int num=0;
    private ArrayList<Customer> customers;


    public Cashier(long timeSlice, ArrayList<Customer> customers) {
        this.timeSlice = timeSlice;
        TimeStarttoCheck = System.currentTimeMillis();
        CheckTime = (long) (minCheckTime + Math.random() * (maxCheckTime - minCheckTime));
        this.customers = customers;
        nextAttempt = System.currentTimeMillis() + this.timeSlice;
    }

    @Override
    public void run() {
        ArrayList<Customer> customerdoneshopping = new ArrayList<>();

        int totalchecktime = 0;
        int totalshoptime = 0;
        int totalentertime = 0;
        int totalleavetime = 0;
        int customerwaitingtime = 0;
        int totalwaitingtime=0;
        while (true) {
            if (nextAttempt < System.currentTimeMillis()) {
                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i).ifdoneshopping()) {
                        num++;
                        totalshoptime += customers.get(i).getShopTime();
                        System.out.println("Total shop time: " + totalshoptime);
                        System.out.println("Average shop time: " + (totalshoptime/num));
                        entertime = System.currentTimeMillis();
                        System.out.println("The customer entered at: " + entertime);
                        totalentertime += entertime;
                        customerdoneshopping.add(customers.get(i));
                        System.out.println("People waiting in the line: ");
                        System.out.println(customerdoneshopping);
                        System.out.println("");
                        customers.remove(i);
                        i--;
                    }

                }
                for (int j = 0; j < customerdoneshopping.size(); j++) {
                    if (customerdoneshopping.get(j).ifCheckedout()) {

                        totalchecktime += customerdoneshopping.get(j).getCheckoutTime();
                        System.out.println("Total check out time: " + totalchecktime);
                        System.out.println("Average process time: " + (totalchecktime/num));
                        customerdoneshopping.remove(j);
                        leavetime = System.currentTimeMillis();
                        System.out.println("The customer leaves at: " + leavetime);
                        totalleavetime += leavetime;
                        customerwaitingtime = totalleavetime - totalentertime;
                        totalwaitingtime+=customerwaitingtime;
                        System.out.println("Customer waiting time: " + customerwaitingtime);
                        System.out.println("Total waiting time: " + (totalwaitingtime));
                        System.out.println("Average waiting time: " + (totalwaitingtime/num));

                    }

                }
            }
        }
    }
}
