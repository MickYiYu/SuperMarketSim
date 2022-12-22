import java.util.ArrayList;

public class CustomerFactory extends Thread{
    private long timeSlice;
    private long chance;
    private long nextAttempt;

    private ArrayList<Customer> customers;


    public CustomerFactory( long timeSlice, long chance, ArrayList<Customer> customers){
        this.timeSlice = timeSlice;
        this.chance = chance;
        nextAttempt = System.currentTimeMillis() + this.timeSlice;
        this.customers = customers;
    }



    @Override
    public void run(){
        while(true){
            if(nextAttempt< System.currentTimeMillis()){
                long randNum = (long)(1+Math.random()*100);
                if(randNum<= chance){
                    //System.out.println("make customer");
                    Customer c = new Customer();
                    customers.add(c);
                    c.start();
                    System.out.println("Customers in shopping:");
                    System.out.println(customers);
                    System.out.println("");
                }
                else{
                    //System.out.println("didn't make customer");
                }
                nextAttempt = System.currentTimeMillis()+timeSlice;
            }
        }
    }
}

