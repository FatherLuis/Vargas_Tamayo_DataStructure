/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

/*
Class name: DataItem

Class Author: Luis E. Vargas Tamayo

Purpose of the class: Object holds a value and a boolean 

Date 12/02/2017

List of changes with dates: none

Special Notes: none

 */
public class DataItem 
{
    private int value;
    private boolean deleted;
    
    /*
    Method Name: DataItem
    Purpose: Constructor
    Parameter: int
    Method Input: none
    Return Value: none
    Date: 12/02/2017
    */  
    public DataItem(int value)
    {
        this.value = value;
        this.deleted = false;
    }
    
    
    ///////////////////////////////////////////////////////////////////// GETTERS AND SETTERS for VALUE
    public int getValue() {return value;}
    public void setValue(int value) {this.value = value;}
    ///////////////////////////////////////////////////////////////////// GETTERS AND SETTERS for DELETED
    public boolean isDeleted() {return deleted;}
    public void setDeleted(boolean blnSwitch) {this.deleted = blnSwitch;}
    
    
    
}
