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
public class Flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
    
    public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, int numberOfSeatsLeft, double originalPrice){
        this.flightNumber = flightNumber;
        if(origin == destination){
            throw new IllegalArgumentException("Origin and Destination are the same.");
        }else{
            this.origin = origin;
            this.destination = destination;
        }
        this.departureTime = departureTime;
        this.capacity = capacity;
        if(numberOfSeatsLeft > capacity){
            throw new IllegalArgumentException("More seats left on the plane than capacity of plane");
        }else{
            this.numberOfSeatsLeft = numberOfSeatsLeft;
        }
        this.originalPrice = originalPrice;
    }
    
    public int getFlightNumber(){
        return flightNumber;
    }
    public void setFlightNumber(int flightNum){
        flightNumber = flightNum;
    }
    public String getOrigin(){
        return origin;
    }
    public void setOrigin(String originPlace){
        origin = originPlace;
    }
    public String getDestination(){
        return destination;
    }
    public void setDestination(String destinationPlace){
        destination = destinationPlace;
    }
    public String getDepartureTime(){
        return departureTime;
    }
    public void setDepartureTIme(String departureT){
        departureTime = departureT;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacitySize){
        capacity = capacitySize;
    }
    public int getNumberOfSeatsLeft(){
        return numberOfSeatsLeft;
    }
    public void setNumberOfSeatsLeft(int numberOfSeatsL){
        numberOfSeatsLeft = numberOfSeatsL;
    }
    public double getOriginalPrice(){
        return originalPrice;
    }
    public void setOriginalPrice(double origPrice){
        originalPrice = origPrice;
    }
    public boolean bookASeat(){
        if(numberOfSeatsLeft > 0){
            numberOfSeatsLeft--;
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return "Flight " + flightNumber + ", " + origin + " to " + destination +  ", " + departureTime + ", " + "original price: $" + originalPrice;
    }
}
