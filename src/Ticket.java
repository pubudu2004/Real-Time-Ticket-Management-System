import java.math.BigDecimal;

public class Ticket {
    private int ticketID;
    private String eventName;
    private BigDecimal price;

    public Ticket(int ticketID, String eventName, BigDecimal price) {
        this.ticketID = ticketID;
        this.eventName = eventName;
        this.price = price;
    }
    public int getTicketID() {return ticketID;}
    public String getEventName() {return eventName;}
    public BigDecimal getPrice() {return price;}

    public void setPrice(BigDecimal price) {this.price = price;}
    public void setTicketID(int ticketID) {this.ticketID = ticketID;}
    public void setEventName(String eventName) {this.eventName = eventName;}

    @Override
    public String toString() {
        return "{ Ticket: " +
                "Ticket ID=" + ticketID +
                ", Event Name='" + eventName + '\'' +
                ", Price=" + price + "}";
    }
}
