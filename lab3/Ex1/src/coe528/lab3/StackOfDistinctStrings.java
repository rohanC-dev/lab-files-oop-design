/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab3;

/**
 *
 * @author r24chopr
 */
import java.util.ArrayList;
public class StackOfDistinctStrings {
 // Overview: StacksOfDistinctStrings are mutable, bounded
 // collection of distinct strings that operate in
 // LIFO (Last-In-First-Out) order.
 //
 // The abstraction function is:
 // AF(c) = a stack of distinct strings p such that
 // where p.top = c.items.get(items.size()-1)
 // p = {c.items.get(i)....c.items.get(i+1)} for each adjacent string in p
 //
 //
 // The rep invariant is:
 // RI(c) = true if
 // 1. for(int i =0; i < c.items.size(); i++){
 //     c.items.get(i) != null
 // }
 // 2. c.items.get(i) != c.items.get(j)
 // 
    
 private ArrayList<String> items;
 // constructor
 public StackOfDistinctStrings() {
 // EFFECTS: Creates a new StackOfDistinctStrings object
    items = new ArrayList<String>();
 }
 public void push(String element) throws Exception {
 // MODIFIES: this
 // EFFECTS: Appends the element at the top of the stack
 // if the element is not in the stack, otherwise
 // does nothing.
    if(element == null) throw new Exception();
    if(false == items.contains(element))
        items.add(element);
 }
 public String pop() throws Exception {
 // MODIFIES: this
 // EFFECTS: Removes an element from the top of the stack
 if (items.size() == 0) throw new Exception();
    return items.remove(items.size()-1);
 }
 public boolean repOK() {
 // EFFECTS: Returns true if the rep invariant holds for this
 // object; otherwise returns false
    for(int i = 0; i< items.size();i++){
        if(items.get(i) == null){
            return false;
        }
    }
    for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.size(); j++) {
                if (items.get(i).equals(items.get(j)) && i != j) {
                    return false;
                }
            }
    }
    return true;
 }
 public String toString() {
 // EFFECTS: Returns a string that contains the strings in the
 // stack and the top element. Implements the
 // abstraction function.
 }
 }

 
 

