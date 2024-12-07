public class Customer implements Runnable {
    private TicketPool ticketPool;  // This is shared ticket pool between vendors and customer.
    private int customerRetrievalRate; // Frequency of purchasing tickets from then pool
    public int quantity; // Quantity customer purchases

    public Customer(TicketPool ticketPool, int customerRetrievalRate, int quantity) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
        this.quantity = quantity;
    }

    public void run() {
        for (int i = 0; i < quantity; i++) {
            Ticket ticket = ticketPool.buyTicket(); // Remove ticket from the pool
            // Printing details of brought tickets
            System.out.println("Ticket brought by "+ Thread.currentThread().getName() + ". Ticket is "+ ticket);

            // Time delay when buying ticket one after another
            try{
                Thread.sleep(customerRetrievalRate * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
