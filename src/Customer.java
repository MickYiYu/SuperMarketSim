import java.util.ArrayList;

public class Customer extends Thread{
    private int id;
    private long shopTime;
    private long checkoutTime;
    private boolean ifCheckedout = false;
    private long minCheckTime = 1000;
    private long maxCheckTime = 5000;
    private long enterTime;
    private long leaveTime;

    private long minShopTime = 3000;
    private long maxShopTime = 20000;

    private static int nextID = 0;
    //every customer will share the ID

    public Customer(){
        id = nextID;
        nextID++;
        this.ifCheckedout = ifCheckedout;
        enterTime = System.currentTimeMillis();
        shopTime = (long)(minShopTime + Math.random()* (maxShopTime-minShopTime));
        checkoutTime = (long)(minCheckTime + Math.random()* (maxCheckTime-minCheckTime));
    }
    @Override
    public String toString(){
        return "Customer" + id;
    }
    @Override
    public void run(){
        while(enterTime + shopTime > System.currentTimeMillis()){

        }
        System.out.println(this.toString() + " is done shopping with shop time " + shopTime);

        long timestarttoCheck = System.currentTimeMillis();
        while(checkoutTime + timestarttoCheck >System.currentTimeMillis()){
            ifCheckedout=false;
        }
        ifCheckedout = true;
        System.out.println(this.toString()+ " check out with the time of " + checkoutTime);
    }



    public boolean ifdoneshopping() {
        if (enterTime + shopTime > System.currentTimeMillis()) {
            return false;
        }
        return true;
    }
    public boolean ifCheckedout(){
        if(ifCheckedout == false){
            return false;
        }
        return true;
    }

    public long getShopTime() {
        return shopTime;
    }

    public void setShopTime(long shopTime) {
        this.shopTime = shopTime;
    }

    public long getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(long checkoutTime) {
        this.checkoutTime = checkoutTime;
    }
}

