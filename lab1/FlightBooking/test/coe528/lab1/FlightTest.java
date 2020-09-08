/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author r24chopr
 */
public class FlightTest {
    
    public FlightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testConstructor(){
        boolean passed = true;
        try{
            Flight flight = new Flight(123, "Atlanta", "Toronto", "04/13/97 3:00 am", 300, 5, 747.26);
        }catch(IllegalArgumentException e){
            passed = false;
        }
        assertTrue(passed);         
    }
    @Test
    public void testInvalidConstructor(){
        boolean passed = true;
        try{
            Flight flight = new Flight(123, "Atlanta", "Atlanta", "04/13/97 3:00 am", 5, 300, 747.26);
        }catch(Exception e){
            passed = false;
        }
        assertFalse(passed);
    }
    Flight flight = new Flight(123, "Atlanta", "Toronto", "04/13/97 3:00 am", 300, 5, 747.26);
    @Test
    public void testGetFlightNumber(){
       int num = flight.getFlightNumber();
       assertEquals(123, num);
    }
    @Test
    public void testSetFlightNumber(){
        flight.setFlightNumber(321);
        assertEquals(flight.getFlightNumber(), 321);
        flight.setFlightNumber(123);
    }
    @Test
    public void testGetOrigin(){
        String origin = flight.getOrigin();
        assertEquals(origin, "Atlanta");
    }
    @Test
    public void testSetOrigin(){
        flight.setOrigin("Toronto");
        assertEquals(flight.getOrigin(), "Toronto");
        flight.setOrigin("Atlanta");
    }
    @Test
    public void testGetDestination(){
        String destination = flight.getDestination();
        assertEquals(destination, "Toronto");
    }
    @Test
    public void testSetDestination(){
        flight.setDestination("Atlanta");
        assertEquals(flight.getDestination(), "Atlanta");
        flight.setDestination("Toronto");
    }
    @Test
    public void testGetDepartureTime(){
        String departureTime = flight.getDepartureTime();
        assertEquals(departureTime, "04/13/97 3:00 am");
    }
    @Test
    public void testSetDepartureTime(){
        flight.setDepartureTIme("04/13/97 6:00 am");
        assertEquals(flight.getDepartureTime(), "04/13/97 6:00 am");
        flight.setDepartureTIme("04/13/97 3:00 am");
    }
    @Test
    public void testGetCapacity(){
        assertEquals(flight.getCapacity(), 300);
    }
    @Test
    public void testSetCapacity(){
        flight.setCapacity(630);
        assertEquals(flight.getCapacity(), 630);
    }
    @Test
    public void testGetNumberOfSeatsLeft(){
        assertEquals(flight.getNumberOfSeatsLeft(), 5);
    }
    @Test
    public void testSetNumberOfSeatsLeft(){
        flight.setNumberOfSeatsLeft(130);
        assertEquals(flight.getNumberOfSeatsLeft(), 130);
    }
    @Test
    public void testGetOriginalPrice(){
        double origprice = flight.getOriginalPrice();
        boolean check;
        if(747.26 == origprice){
            check = true;
        }else{
            check = false;
        }
        assertTrue(check);
    }
    @Test
    public void testSetOriginalPrice(){
        flight.setOriginalPrice(321.32);
        boolean check;
        if(flight.getOriginalPrice() == 321.32){
            check = true;
        }else{
            check = false;
        }
        assertTrue(check);
    }
    @Test
    public void testBookASeat(){
        assertTrue(flight.bookASeat());
        Flight flight2 = new Flight(124, "Atlanta", "Toronto", "04/13/97 4:00 am", 300, 0, 749.26);
        assertFalse(flight2.bookASeat());
    }
    @Test
    public void testToString(){
        assertEquals(flight.toString(), "Flight 123, Atlanta to Toronto, 04/13/97 3:00 am, original price: $747.26");
    }
    
    

    
}
