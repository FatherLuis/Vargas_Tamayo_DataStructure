/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vargas_tamayo_datastruc_proj3;


/*
Class name: LinkList

Class Author: Luis E. Vargas Tamayo

Purpose of the class:  Provides the set-up for the use of LinkList

Date: 9/26/2017

List of changes with dates: none

Special Notes: none
*/ 
public class LinkList 
{
    private int value;
    private LinkList nextLL;
    
    
        
    /*
    Method Name: getValue()  
    Purpose: gets private Class variable value
    Parameter: none
    Method Input: none
    Return Value: int
    Date:  9/7/2017
    */   
    public int getValue(){return value;}
    
    /*
    Method Name: setValue()  
    Purpose: sets private class variable value
    Parameter: int 
    Method Input: none 
    Return Value:  none
    Date:  9/7/2017
    */      
    public void setValue(int value){this.value=value;}
    
    /*
    Method Name: getNextLL()  
    Purpose: get private class varibale NextLL
    Parameter: none
    Method Input: none
    Return Value: LinkList
    Date:  9/7/2017
    */  
    public LinkList getNextLL(){return nextLL;}
     
    /*
    Method Name: setNextLL()
    Purpose: sets private class varibale NextLL
    Parameter: LinkList
    Method Input: none
    Return Value: none
    Date:  9/7/2017
    */  
    public void setNextLL(LinkList nextLL){this.nextLL= nextLL;}
    

    
    
    
    
    
    
    
    
    
    
}
