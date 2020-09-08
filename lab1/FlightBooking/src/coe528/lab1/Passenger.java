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
public abstract class Passenger {
    protected String name;
    protected int age;
    
    public Passenger(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int a){
        age = a;
    }
    public abstract double applyDiscount(double p);
}
