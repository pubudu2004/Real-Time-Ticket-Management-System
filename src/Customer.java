public class Customer implements Runnable {
    private TicketPool ticketPool;  // This is shared ticket pool between vendors and customer.
    private int customerRetrievalRate;
    public int quantity;

    public Customer(TicketPool ticketPool, int customerRetrievalRate, int quantity) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
        this.quantity = quantity;
    }

    public void run() {

    }
}
