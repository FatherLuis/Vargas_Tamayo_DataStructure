/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vargas_tamayo_datastruc_proj1;

import javax.swing.JOptionPane;

/*
Class name: Stack

Class Author: Luis E. Vargas Tamayo

Purpose of the class: Creates the environment to create Link List and the methods to operate the Data structure

Date: 9/7/2017

List of changes with dates: none

Special Notes: none
*/ 
public class Stack 
{
     
    private IntLinkList head; // leading LinkList 
    
    /*
    Method Name:  Stack()
    Purpose:  contructor of the Class
    Parameter:  none
    Method Input: none
    Return Value: none
    Date: 9/7/2017
    */
    public Stack()
    {
        head = null; // holds the leading linklist
        
    }
    
    /*
    Method Name: getHead()
    Purpose: returns the private class variable head
    Parameter: none
    Method Input: none
    Return Value: class Variable
    Date: 9/7/2017
    */
    public IntLinkList getHead(){return head;}
    
    /*
    Method Name: push()
    Purpose: creates a new Link to the data structure Stack
    Parameter: none
    Method Input: none
    Return Value: none
    Date: 9/7/2017
    */
    public void push(int number)
    {

        try //although this should never get an error, its just for precaution
        {  
            if(head == null) // if there is no link created, then one will be made 
            {
                IntLinkList manager = new IntLinkList(); //creates new object of class IntLinkList
                manager.setValue(number); // Parameter is stored in the new Object
            
                head = manager; //Object created is now the head of the link list
            }      
            else
            {
                IntLinkList newManager = new IntLinkList();
                newManager.setValue(number);
                newManager.setNextlink(head);
                head = newManager;
            }
        }
        catch(Exception ex)
        {
            System.out.println("Code should never make it ");
        }   
    }
    
    /*
    Method Name: pop()
    Purpose: Deletes a link from the data structure stack
    Parameter: none
    Method Input: none
    Return Value: none
    Date: 9/7/2017
    */
    public void pop()
    {
        if(head != null) // If a link exist, then the if-statement will run
        {
            IntLinkList code = head; // the object stored in class variable head is stored in code
            head = code.getNextLink(); // the new head is the link stored in the previous object stored in head
        }
        else
        {
            JOptionPane.showMessageDialog(null, "There are no more Integers to pop from Stack"); // if a link does not exist, then this message will show
        }
    }
    
}

