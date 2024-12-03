import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private Queue<Ticket> ticketQueue;
    private int maxTicketCapacity;

    public TicketPool(int maxCapacity) {
        this.maxTicketCapacity = maxCapacity;
        this.ticketQueue = new LinkedList<>();
    }

    // The addTicket method is used by vendor to add tickets
    public void addTicket(Ticket ticket) {
        while (ticketQueue.size() >= maxTicketCapacity) {
            try{
                wait();
            }catch(InterruptedException e){
                // Immediately after the try block, the catch or finally block should come
                e.printStackTrace(); // for CLI
                throw new RuntimeException(e.getMessage());
            }
        }
        this.ticketQueue.add(ticket); // adding te ticket to the queue
        notifyAll(); // Notifying all waiting threads
        // Shows thread name, eho added and current size of the pool
        System.out.println(Thread.currentThread().getName() + ": Ticket added to the pool. Current size is "+ ticketQueue.size());
        
    }
}
