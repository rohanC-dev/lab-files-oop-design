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
public class Member extends Passenger{
    private int yearsOfMembership;
    
    public Member(String name, int age, int yearsOfMembership){
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }
    
    @Override
    public double applyDiscount(double p){
        if(yearsOfMembership > 5){
            p = p*0.5;
        }else if(yearsOfMembership > 1 && yearsOfMembership < 5){
            p = p*0.9;
        }
        return p;
    }
}
