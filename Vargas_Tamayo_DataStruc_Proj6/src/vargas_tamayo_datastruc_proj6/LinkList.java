/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vargas_tamayo_datastruc_proj6;

/*

Class name: LinkList

Class Author: Luis E. Vargas Tamayo

Purpose of the class: Creates the necessary components of a classic Link list

Date: 11/13/2017

List of changes with dates: none

Special Notes: none

*/ 
public class LinkList 
{
    
    private String term;
    private LinkList nextLL;
    
    /* 
    Method Name: getTerm()
    Method Inputted: none
    Parameters: none
    Purpose: returns private class variable
    Return: string
    Date:  11/13/2017
    */ 
    public String getTerm(){return term;}  
    
    /* 
    Method Name: getNextLink()
    Method Inputted: none
    Parameters: none
    Purpose: returns private class variable
    Return: LinkList
    Date:  11/13/2017
    */ 
    public LinkList getNextLink(){return nextLL;} 
    
    /* 
    Method Name: setTerm()
    Method Inputted: none
    Parameters: String
    Purpose: places a new value on private variable
    Return: none
    Date:  11/13/2017
    */ 
    public void setTerm(String term){this.term = term;} 
    
    /* 
    Method Name: setLinkList()
    Method Inputted: none
    Parameters: LinkList
    Purpose: places a new value on private variable
    Return: none
    Date:  11/13/2017
    */ 
    public void setLinkList(LinkList link) {this.nextLL = link;}
    
    
    
    
}
