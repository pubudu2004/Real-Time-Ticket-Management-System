import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner inputs = new Scanner(System.in); // Creating a scanner to take user inputs

        int totalTickets = 0; int ticketReleaseRate = 0; int customerRetrievalRate = 0; int maxTicketCapacity = 0; // Initializing variables to zero

        // Prompting user for the total tickets while checking/validating inputs
        while(totalTickets <= 0) {
            System.out.println("Enter the total number of tickets:");
            try {
                totalTickets = Integer.parseInt(inputs.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            if (totalTickets <= 0) {
                System.out.println("The total of tickets cannot be negative.");
            }
        }

        // Prompting user for the ticket release rate while checking/validating inputs
        while(ticketReleaseRate <= 0 || ticketReleaseRate > totalTickets) {
            System.out.println("Enter the ticket release rate:");
            try {
                ticketReleaseRate = Integer.parseInt(inputs.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            if (ticketReleaseRate <= 0) {
                System.out.println("The ticket release rate cannot be negative.");
            } else if (ticketReleaseRate > totalTickets) {
                System.out.println("The ticket release rate cannot be greater than the total number of tickets.");
            }
        }

        // Prompting user for the customer retrieval rate while checking/validating inputs
        while(customerRetrievalRate <= 0 || customerRetrievalRate > totalTickets || customerRetrievalRate >= ticketReleaseRate) {
            System.out.println("Enter the customer retrieval rate:");
            try{
                customerRetrievalRate = Integer.parseInt(inputs.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            if (customerRetrievalRate <= 0) {
                System.out.println("The customer retrieval rate cannot be negative.");
            } else if (customerRetrievalRate > totalTickets) {
                System.out.println("The customer retrieval rate must be less than the total number of tickets.");
            } else if (customerRetrievalRate >= ticketReleaseRate) {
                System.out.println("The customer retrieval rate cannot be greater than ticket release rate.");
            }
        }

        // Prompting user for the maximum ticket capacity while checking/validating inputs
        while(maxTicketCapacity <= 0 || maxTicketCapacity < totalTickets) {
            System.out.println("Enter the maximum ticket capacity:");
            try{
                maxTicketCapacity = Integer.parseInt(inputs.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            if (maxTicketCapacity <= 0) {
                System.out.println("The maximum ticket capacity cannot be negative.");
            } else if (maxTicketCapacity < totalTickets) {
                System.out.println("The maximum ticket capacity cannot be less than the total number of tickets.");
            }
        }

        TicketPool ticketPool = new TicketPool(maxTicketCapacity);

        Vendor[] vendors = new Vendor[5]; // Array of vendors (Used an array of objects)
        for (int i = 0; i < vendors.length; i++) {
            vendors[i] = new Vendor(ticketPool,totalTickets,ticketReleaseRate);
            Thread vendorThread = new Thread(vendors[i],"Vendor-"+i); // Used 3rd constructor of thread class
            vendorThread.start(); // Start the vendor thread
        }

        Customer[] customers = new Customer[totalTickets]; // Array of customers
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(ticketPool,customerRetrievalRate,5);
            Thread customerThread = new Thread(customers[i],"Customer-"+i); // Used 3rd constructor of thread class
            customerThread.start(); // Start customer thread
        }

        //Saving the configuration to a text file
        try(BufferedWriter configDetailsIn = new BufferedWriter(new FileWriter("configuration.txt"))){
            configDetailsIn.write("Ticket Release Rate: "+ticketReleaseRate+"\n");
            configDetailsIn.write("Total Tickets: "+totalTickets+"\n");
            configDetailsIn.write("Customer Retrieval Rate: "+customerRetrievalRate+"\n");
            configDetailsIn.write("Max Ticket Capacity: "+ maxTicketCapacity+"\n");
            System.out.println("Configuration saved successfully.");
        }catch (IOException e){
            e.printStackTrace();
        }

        // Loading saved configuration data from a file
        try(BufferedReader configDetailsOut =  new BufferedReader(new FileReader("configuration.txt"))){
            String line;
            while ((line = configDetailsOut.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}