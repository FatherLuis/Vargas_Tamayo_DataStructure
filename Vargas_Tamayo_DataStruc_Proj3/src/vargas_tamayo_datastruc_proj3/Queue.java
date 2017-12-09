/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vargas_tamayo_datastruc_proj3;

import javax.swing.JOptionPane;


/*
Class name: Queue

Class Author: Luis E. Vargas Tamayo

Purpose of the class:  Provides the environment to create a Queue

Date: 9/26/2017

List of changes with dates: none

Special Notes: none
*/ 
public class Queue 
{
    private LinkList head;
    
    /*
    Method Name:  
    Purpose:
    Parameter: 
    Method Input: 
    Return Value: 
    Date:  9/7/2017
    */   
    public Queue()
    {
        head = null;
    }
    
    /*
    Method Name: getHead()
    Purpose: returns private variable head
    Parameter: none
    Method Input: none
    Return Value: LinkList
    Date:  9/7/2017
    */  
    public LinkList getHead(){return head;}
      
    /*
    Method Name:  setHead()
    Purpose: sets private variable head
    Parameter: LinkList
    Method Input: none
    Return Value: none
    Date:  9/7/2017
    */  
    public void setHead(LinkList head){this.head=head;}
      
    /*
    Method Name: enqueue  
    Purpose: queue's a integer on the queue
    Parameter: int
    Method Input: none
    Return Value: none
    Date:  9/26/2017
    */  
    public void enqueue(int value)
    {
        try //although this should never get an error, its just for precaution
        { 
            if(head == null) // if there is no link created, then one will be made 
            {
                LinkList manager = new LinkList(); //creates new object of class IntLinkList
                manager.setValue(value); // Parameter is stored in the new Object
                manager.setNextLL(null);
                head = manager; //Object created is now the head of the link list   
            }      
            else
            {
                LinkList newManager = new LinkList(); //creates new object of class IntLinkList
                newManager.setValue(value); //parameter is stored in the new Object
                  
                LinkList temp=head; // temp takes the address of head
  
                while(temp.getNextLL()!=null) // reads through the queue to find a null Linklist
                {
                    temp = temp.getNextLL(); // next Linklist
                }
                    
                temp.setNextLL(newManager); // when Null nextLinklist is found, the location is written as the adrress of the new created LinkList 
            }
        }
    
        catch(Exception ex)
        {
            System.out.println("Code should never make it ");
        }
    }
     
    /*
    Method Name: dequeue  
    Purpose: dequeue's a integer from the queue
    Parameter: none
    Method Input: none 
    Return Value: none 
    Date:  9/26/2017
    */     
    public void dequeue()
    {
        if(getHead()!=null) // if head is not null, run code
        {
            setHead(head.getNextLL()); // new head becomes the head's nextLinkList
        }
        else
        {
            JOptionPane.showMessageDialog(null,"There is no more integers to dequeue");  
        }
    }
    
    
    
    
    
 
    
    
    
    
    
    
    
    
    
    
    
    
}
