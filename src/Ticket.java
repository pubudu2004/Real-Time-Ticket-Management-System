public class Ticket {
    private int ticketID;
    private String eventName;
    private double price;

    public Ticket(int ticketID, String name, double price) {
        this.ticketID = ticketID;
        this.eventName = name;
        this.price = price;
    }
    public int getTicketID() {return ticketID;}
    public String getEventName() {return eventName;}
    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}
    public void setTicketID(int ticketID) {this.ticketID = ticketID;}
    public void setEventName(String eventName) {this.eventName = eventName;}

    @Override
    public String toString() {
        return "Ticket: " +
                "ticketID=" + ticketID +
                ", eventName='" + eventName + '\'' +
                ", price=" + price;
    }
}
