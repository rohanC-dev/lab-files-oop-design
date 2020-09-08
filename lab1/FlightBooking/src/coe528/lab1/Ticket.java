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
public class Ticket {
    private Passenger p;
    private Flight flight;
    private double price;
    private static int ticketNumber = 0;
    
    public Ticket(Passenger p, Flight flight, double price){
        this.p = p;
        this.flight = flight;
        this.price = price;
        this.ticketNumber = ticketNumber;
        ticketNumber++;
    }
    public Passenger getPassenger(){
        return p;
    }
    public void setPassenger(Passenger passenger){
        p = passenger;
    }
    public Flight getFlight(){
        return flight;
    }
    public void setFlight(Flight f){
        flight = f;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double p){
        price = p;
    }
    public int getTicketNumber(){
        return ticketNumber;
    }
    public void setTicketNumber(int ticketNum){
        ticketNumber = ticketNum;
    }
    @Override
    public String toString(){
        return p.getName() + ", Flight " + flight.getFlightNumber() + ", " + flight.getOrigin() + " to " + flight.getDestination() + ", " + flight.getDepartureTime() + ", " + "original price: $ " + flight.getOriginalPrice() + ", ticket price: $ " + p.applyDiscount(flight.getOriginalPrice());
    }
}
