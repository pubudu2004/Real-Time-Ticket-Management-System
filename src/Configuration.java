import java.io.Serializable;
import java.io.*;

//Defining the class configuration to add serialization methods
public class Configuration implements Serializable {

    private int ticketReleaseRate;
    private int  totalTickets;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public Configuration(int ticketReleaseRate,int totalTickets,int customerRetrievalRate, int maxTicketCapacity) {
        this.ticketReleaseRate = ticketReleaseRate;
        this.totalTickets = totalTickets;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getTotalTickets() {
        return totalTickets;
    }
    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }
    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }
    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }
    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }
    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    //Saving the configuration to a text file

    public void saveFile(String filepath) {
        try(BufferedWriter configDetails = new BufferedWriter(new FileWriter(filepath))){
            configDetails.write("Ticket Release Rate: "+ticketReleaseRate+"\n");
            configDetails.write("Total Tickets: "+totalTickets+"\n");
            configDetails.write("Customer Retrieval Rate: "+customerRetrievalRate+"\n");
            configDetails.write("Max Ticket Capacity: "+maxTicketCapacity+"\n");
            System.out.println("Configuration saved successfully.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }





}
