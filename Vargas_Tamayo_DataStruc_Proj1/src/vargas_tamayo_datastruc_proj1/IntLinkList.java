/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vargas_tamayo_datastruc_proj1;

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
    public int value; //integer value 
    public IntLinkList nextLink; // address for the previous Class object
    
    
    
    public int getValue(){return value;}
    public void setValue(int value){this.value=value;}
    
    public IntLinkList getNextLink(){return nextLink;}
    public void setNextlink(IntLinkList nextLink){this.nextLink = nextLink;}
    
}