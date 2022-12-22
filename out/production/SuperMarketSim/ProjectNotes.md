##Project Notes

####Project Summary

Simulate a supermarket where customers entered
according to some random interval, shop for random
interval of time, get in line to check when it is
their turn, check out for random interval of time.

### Classes

*Customer (Threaded)
*CustomerFactory
*Cashiers (Threaded)
 *This needs to be written

### Data Structures
* ArrayList of Customers
* Queue to hold Customers as they wait for checkout
  * Use a ConcurrentLinkedQueue, which is Thread safe

### Key Terms

*Thread - A piece of code, a class, an object, ect. that runs on its own process thread

*Serializable - a function or data structure that is Thread safe
  * It locks access and unlocks access as different threads interact with it

### End Results
* a list of stats
  *Total customers
  *Total number of Cashiers used
  *Average shop time per customer
  * Average process time per customer
  * Average wait time in the Queue per customer
    * Not implemented
    * We need to add time-stamps to Customer when they
      *Enter the Queue
      * Exit the Queue
  * Average down-time per Cashier (stretch goal)