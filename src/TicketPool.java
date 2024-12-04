import java.nio.channels.ScatteringByteChannel;
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
        notifyAll(); // Notifying all waiting threads (all threads will be notified)
        // Shows thread name, who added and current size of the pool
        System.out.println(Thread.currentThread().getName() + ": Ticket added to the pool. Current size is "+ ticketQueue.size());
        
    }

    // Buy ticket metjod used to remove tickets when customer buys a tickets
    public synchronized Ticket buyTicket() {
        while (ticketQueue.isEmpty()) {
            try{
                wait(); // Waiting if te queue is empty
            }catch(InterruptedException e){
                throw new RuntimeException(e.getMessage());
            }
        }
        Ticket ticket = ticketQueue.poll(); // Remove the ticket from the queue
        notifyAll(); // Notifying all waiting threads
        // Prints the message to show the thread name, who added and the current size of the pool.
        System.out.println(Thread.currentThread().getName() + ": Ticket brought from the pool. Current size is "+ ticketQueue.size() + "Ticket is: "+ ticket);
        return ticket;


    }
}
