/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

/**
 *
 * @author r24chopr
 */
import java.util.ArrayList;
public class Manager{
    ArrayList<Flight> myFlights = new ArrayList<Flight>();
    ArrayList<Ticket> myTickets = new ArrayList<Ticket>();
    public void createFlights(Flight f){
        myFlights.add(f);
    }
    public void displayAvailableFlights(String origin, String destination){
        System.out.println("\t\t\t-----Available Flights-----");
        for(int i = 0; i < myFlights.size(); i++){
            if(myFlights.get(i).getOrigin() == origin && myFlights.get(i).getDestination() == destination && myFlights.get(i).getNumberOfSeatsLeft() > 0){
                System.out.println("\n >"+myFlights.get(i).toString());
            }
        }
    }
    public Flight getFlight(int flightNumber){
        Flight specFlight = null; // this is a fake flight created to be able to store new flight
        for(int i = 0; i < myFlights.size(); i++){
            if(myFlights.get(i).getFlightNumber() == flightNumber){
                specFlight = myFlights.get(i);
            }
        }
        return specFlight;
    }
    public void bookSeat(int flightNumber, Passenger p){
        Flight flight = getFlight(flightNumber);
        if(flight != null){
            if(flight.bookASeat()){
                double price = p.applyDiscount(flight.getOriginalPrice());
                Ticket ticket = new Ticket(p, flight, price);
                myTickets.add(ticket);
                System.out.println("\n> Flight " + flightNumber + " booked for " + p.getName());
                System.out.println("    > Ticket Number: " + ticket.getTicketNumber());
                System.out.println("    > Ticket Info: " + ticket.toString());
            }else if(!flight.bookASeat()){
                System.out.println("---------------");
                System.out.println("Flight is full!");
                System.out.println("---------------");
            }
        }else{
            System.out.println("---------------------");
            System.out.println("Flight doesn't exist!");
            System.out.println("---------------------");
        }
        
    }
    public static void main(String[] args){
        // 1) First part declares a bunch of flights from Atlanta to Chicago
        Flight flight = new Flight(123, "Atlanta", "Chicago", "04/13/97 3:00 am", 300, 5, 747.26);
        Flight flight2 = new Flight(124, "Atlanta", "Chicago", "04/14/97 7:00 pm", 630, 3, 943.26);
        Flight flight3 = new Flight(125, "Atlanta", "Chicago", "04/15/97 3:00 pm", 270, 122, 453.26);
        Flight flight4 = new Flight(126, "Atlanta", "Chicago", "04/16/97 2:00 am", 270, 265, 576.26);
        Flight flight5 = new Flight(127, "Atlanta", "Chicago", "04/17/97 4:00 am", 280, 1, 439.26);
        // end of 1)
        // 2) Second part creates a variety of passengers, 3 members and 3 non-members
        Member mem9year = new Member("Bucky", 23, 9);
        Member mem4year = new Member("Tom", 34, 4);
        Member mem0year = new Member("Steve", 27, 0);
        NonMember nonMemYoung = new NonMember("Chad", 22);
        NonMember nonMemOld = new NonMember("Brad", 75);
        NonMember extraPassenger = new NonMember("Ted", 43);
        // end of 2)
        // 3) Third part creates a manager object and adds all the flights to the array list
        Manager m = new Manager();
        m.createFlights(flight);
        m.createFlights(flight2);
        m.createFlights(flight3);
        m.createFlights(flight4);
        m.createFlights(flight5);
        // end of 3)
        // 4) lists all information about flights from origin to destination
        // Shows functionality of displayAvailableFlights method
        m.displayAvailableFlights("Atlanta", "Chicago");
        // end of 4)
        // 5) Fifth part tries to book a seat for the specified passenger
        // Shows functionality of:
        // bookSeat method
        // bookASeat method
        // getFlight method
        // applyDiscount method
        // toString method for ticket class
        // Inhertiance relationship between Passenger, Member and Non-Member
        // Ticket number counting procedure
        m.bookSeat(123, mem9year);
        m.bookSeat(123, mem4year);
        m.bookSeat(123, mem0year);
        m.bookSeat(123, nonMemYoung);
        m.bookSeat(123, nonMemOld);
        m.bookSeat(123, extraPassenger);
        m.bookSeat(122, extraPassenger);
        m.bookSeat(124, extraPassenger);
        // end of 5)
        
        
    }
}
