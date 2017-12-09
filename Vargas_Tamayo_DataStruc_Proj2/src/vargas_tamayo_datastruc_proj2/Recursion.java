/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vargas_tamayo_datastruc_proj2;

import javax.swing.JOptionPane;


/*
Class name: Recursion

Class Author: Luis E. Vargas Tamayo

Purpose of the class: Creates the environment to create Link List and the methods to operate the Data structure

Date: 9/7/2017

List of changes with dates: none

Special Notes: none
*/ 
public class Recursion 
{

    private IntLinkList head; // leading LinkList box
    
    /*
    Method Name:  Recursion()
    Purpose:  contructor of the Class
    Parameter:  none
    Method Input: none
    Return Value: none
    Date: 9/7/2017
    */
    
    public Recursion()
    {
        head = null; // holds data
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
    public void setHead(IntLinkList head){this.head=head;}
    
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
                IntLinkList newManager = new IntLinkList(); //creates new object of class IntLinkList
                newManager.setValue(number); //parameter is stored in the new Object
                newManager.setLinkList(head); // address of the head is stored in newObjects link
                head = newManager; // the new head is the NewObject
                
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
    public void recursionPop(IntLinkList link, int value2)
    {
        if(link != null) // If a link exist, then the if-statement will run
        {
            if(link.getValue() != value2)
            {
                IntLinkList code = head; // the object stored in class variable head is stored in code
                head=code.getNextLink(); // the new head is the link stored in the previous object stored in head
                
                recursionPop(head,value2); //repeats :)
            }
            else{ JOptionPane.showMessageDialog(null,"Your Number has been found :) "); }  
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Number Not Found"); // if a link does not exist, then this message will show
        }
    }  
}
