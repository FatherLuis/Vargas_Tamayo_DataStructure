/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

/*

Class name: DataInfo

Class Author: Luis E. Vargas Tamayo

Purpose of the class: Object holds the word and the count 

Date: 10/30/2017

List of changes with dates: none

Special Notes: none

*/ 
public class DataInfo 
{
    public int count; //Holds the number of times the word is encountered
    public String term; //Holds the word
    
    /* 
    Method Name: DataInfo()
    Method Inputted: none
    Parameters: String
    Purpose: Constructor
    Return: none
    Date: 10/30/2017
    */ 
    public DataInfo(String term)
    {
        this.term = term; //Objects is given the parameter's value
        this.count = 1;   // Count is initialized to one
    }
    
    
    /* 
    Method Name: displayItem()
    Method Inputted: none
    Parameters: none
    Purpose: returns a string with the word and count number
    Return: String
    Date: 10/30/2017
    */     
    public String displayItem()
    {
        return term + ": " + count;
    }
    
    
    
}
