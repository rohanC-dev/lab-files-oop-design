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
public class NonMember extends Passenger{
    public NonMember(String name, int age){
        super(name, age);
    }
    @Override
    public double applyDiscount(double p){
        int age = getAge();
        if(age > 65){
            p = p*0.9;
        }
        return p;
    }
}
