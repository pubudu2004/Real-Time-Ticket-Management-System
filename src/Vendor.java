import java.math.BigDecimal;

public class Vendor implements Runnable {

    private TicketPool ticketPool; // The TicketPool which is shared by all the vendors and customers
    private int totalTickets; // The total tickets that vendor will make available
    private int ticketReleaseRate; // The time delay to add tickets (Frequency of adding tickets)

    public Vendor(TicketPool ticketPool, int totalTickets, int ticketReleaseRate) {
        this.ticketPool = ticketPool;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    // Implement the thread
    // Runnable interface should write the implementation for runnable interface
    public void run(){
        for (int i = 0; i <= totalTickets; i++) {
            Ticket ticket = new Ticket(i,"Event Simple",new BigDecimal(1000));
            ticketPool.addTicket(ticket);

            // The ticket release frequency means the delay.
            // We should convert the value in Second to milliseconds
            try {
                Thread.sleep(ticketReleaseRate * 1000);
            } catch (InterruptedException e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }


}
