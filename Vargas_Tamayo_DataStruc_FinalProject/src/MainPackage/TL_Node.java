/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

/*
Class name: TL_Node

Class Author: Luis E. Vargas Tamayo

Purpose of the class: Object holds references to other nodes and contributes to the completion of the TL_Tree

Date: 12/02/2017

List of changes with dates: none

Special Notes: none
*/ 
public class TL_Node 
{
    
    private TL_Node Parent;
    private DataItem leftData;
    private DataItem rightData;
    private TL_Node[] childrenNode = new TL_Node[3];

///////////////////////////////////////////////////////////////////////GETTER AND SETTER for PARENT
    public TL_Node getParent() {return Parent;}
    public void setParent(TL_Node Parent) {this.Parent = Parent;}
///////////////////////////////////////////////////////////////////////GETTER AND SETTER for LEFTDATA
    public DataItem getLeftData() {return leftData;}
    public void setLeftData(DataItem leftData) {this.leftData = leftData;}
///////////////////////////////////////////////////////////////////////GETTER AND SETTER for RIGHTDATA
    public DataItem getRightData() {return rightData;}
    public void setRightData(DataItem rightData) {this.rightData = rightData;}
///////////////////////////////////////////////////////////////////////GETTER AND SETTER for CHILDRENNODE
    public TL_Node getChildrenNode(int index) {return childrenNode[index];}
    public void setChildrenNode(int index ,TL_Node childrenNode) {this.childrenNode[index] = childrenNode;}
    







    
}
