/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vargas_tamayo_datastruc_proj2;

/*
Class name: IntLinkList

Class Author: Luis E. Vargas Tamayo

Purpose of the class: Creates the environment for a Link List

Date:  9/7/2017

List of changes with dates: none

Special Notes: none
*/ 
public class IntLinkList 
{
    private int value; //integer value 
    private IntLinkList nextLink; // address for the previous Class object
    
    
    public int getValue(){return value;}
    public IntLinkList getNextLink(){return nextLink;}
    
    public void setValue(int value){this.value = value;}  
    public void setLinkList(IntLinkList link) {this.nextLink = link;}
    
}
