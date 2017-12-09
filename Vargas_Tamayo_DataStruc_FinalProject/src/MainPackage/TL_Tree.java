/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import javax.swing.JOptionPane;


/*
Class name: TL_Tree

Class Author: Luis E. Vargas Tamayo

Purpose of the class: Creates a tri-link tree that stores numeric values

Date: 12/02/2017

List of changes with dates: none

Special Notes: none
*/ 
public class TL_Tree 
{
    private TL_Node root;
    private DataItem newDataInfo;
      
    /*
    Method Name: getRoot()
    Purpose: gets private variable root; Used in the MAIN GUI
    Parameter: none
    Method Input: none
    Return Value: TL_Node
    Date: 12/02/2017
    */ 
    public TL_Node getRoot(){return root;}
    
    /*
    Method Name:  TL_Tree()
    Purpose:  constructor
    Parameter: none
    Method Input: none
    Return Value: none
    Date: 12/05/2017
    */
    public TL_Tree()    
    {
        root = null;
    }
     
    /*
    Method Name: insert()
    Purpose: inserts value into the TL_Tree
    Parameter: int
    Method Input: recInsert()
    Return Value: none
    Date: 12/02/2017
    */ 
    public void insert(int value)
    {
        newDataInfo = new DataItem(value);
        
        if(root == null)
        {
            TL_Node obj = new TL_Node();
            obj.setLeftData(newDataInfo);
            root = obj;
        }
        else
        {
            recInsert(root);
        }
    }
     
    /*
    Method Name: recInsert()
    Purpose: recursion method that finds the next available position for the dataItem
    Parameter: TL_Node
    Method Input: recInsert()
    Return Value: none
    Date: 12/02/2017
    */ 
    private void recInsert(TL_Node curNode)
    {
            //CHECKS IF THE VALUE IS LESS THAN THE LEFT DATA AND IF THERE EXIST ANOTHER NODE TO THE LEFT NODE, IF TRUE, RECURSION TO THE LEFT NODE    
            if(newDataInfo.getValue() < curNode.getLeftData().getValue() && (curNode.getChildrenNode(0) != null))
            {
                recInsert(curNode.getChildrenNode(0));
            }
            //CHECKS IF THE VALUE IS LESS THAN THE LEFT DATAITEM AND IF THERE DOES NOT EXIST A LEFT NODE, IF TRUE, A LEFT NODE IS CREATED        
            else if(newDataInfo.getValue() < curNode.getLeftData().getValue() && (curNode.getChildrenNode(0) == null))
            {
                TL_Node obj = new TL_Node();
                obj.setLeftData(newDataInfo);
                obj.setParent(curNode);
                curNode.setChildrenNode(0, obj);
            }
            //CHECKS IF THE VALUE IS EQUAL TO THE LEFT DATA, IF TRUE, SET DELETED BOOLEAN TO FALSE         
            else if(newDataInfo.getValue() == curNode.getLeftData().getValue())
            {
                curNode.getLeftData().setDeleted(false);                   
            }
            //CHECKS IF THE RIGHT DATAITEM EXIST, IF TRUE, THEN WE CONTINUE LOOKING FOR NEXT AVAILABLE SPOT       
            else if(curNode.getRightData() != null)
            {
                //CHECKS IF THE VALUE IS LESS THAN THE RIGHT DATAITEM VALUE AND IF THERE EXIST A NODE IN THE MIDDLE, IF TRUE RECURSION TO THE MIDDLE NODE 
                if(newDataInfo.getValue() < curNode.getRightData().getValue() && (curNode.getChildrenNode(1) != null))
                {
                    recInsert(curNode.getChildrenNode(1));
                }
                //CHECKS IF THE VALUE IS LESS THAN THE RIGHT DATAITEM VALUE AND IF THERE DOES NOT EXIST A LEFT NODE, IF TRUE, A MIDDLE NODE IS CREATED
                else if(newDataInfo.getValue() < curNode.getRightData().getValue() && (curNode.getChildrenNode(1) == null))
                {
                    TL_Node obj = new TL_Node();
                    obj.setLeftData(newDataInfo);
                    obj.setParent(curNode);
                    curNode.setChildrenNode(1, obj);
                }
                //CHECKS IF THE VALUE IS GREATER THAN THE RIGHT DATAITEM AND IF THERE EXIST A NODE TO THE RIGHT, IF TRUE, RESURSION TO THE RIGHT NODE
                else if(newDataInfo.getValue() > curNode.getRightData().getValue() && (curNode.getChildrenNode(2) != null))
                {
                    recInsert(curNode.getChildrenNode(2));
                }
                //CHECLS IF THE VALUE IS GREATED THAN THE RIGHT DATAITEM AND IF THERE DOES NOT EXIST A LEFT NODE, IF TRUE, A RIGHT NODE IS CREATED
                else if(newDataInfo.getValue() > curNode.getRightData().getValue() && (curNode.getChildrenNode(2) == null))
                {
                    TL_Node obj = new TL_Node();
                    obj.setLeftData(newDataInfo);
                    obj.setParent(curNode);
                    curNode.setChildrenNode(2, obj);
                }
            }
            //CHECKS IF THE RIGHT DATAITEM DOES NOT EXIST, IF TRUE, VALUE IS STORED TO THE RIGHT DATAITEM 
            else if(curNode.getRightData() == null)
            {
                curNode.setRightData(newDataInfo);
            }
    }
     
    /*
    Method Name: find()
    Purpose: finds a value in the tree
    Parameter: int 
    Method Input: recFind()
    Return Value: boolean
    Date: 12/02/2017
    */ 
    public boolean find(int value)
    {  
        boolean key = recFind(root,value);
        return key; 
    }
    
    /*
    Method Name: recFind()
    Purpose: recurses through the tree to see if a value is stored in the tree
    Parameter: TL_Node, value
    Method Input: recFind()
    Return Value: boolean
    Date: 12/02/2017
    */ 
    private boolean recFind(TL_Node curNode, int value)
    {
        boolean key = false;
        
        //CHECKS IF THE VALUE IS EQUAL TO THE LEFT DATAITEM AND IF THE LEFT DATAITEM IS DELETED, IF TRUE, VALUE IS FOUND
        if(value == curNode.getLeftData().getValue() && !curNode.getLeftData().isDeleted())
        {
            key = true;
        }
        //CHECKS IF THE VALUE IS LESS THAN THE LEFT DATAITEM AND IF THERE EXIST A LEFT NODE, IF TRUE, RECURSION TO THE LEFT NODE
        else if(value < curNode.getLeftData().getValue() && curNode.getChildrenNode(0) != null)
        {
            key = recFind(curNode.getChildrenNode(0), value);
        }
        //CHECKS IF THERE EXIST A RIGHT DATAITEM, IF TRUE, CONTINUE SEARCHING
        else if(curNode.getRightData() != null)
        {
            //CHECKS IF THE VALUE IS EQUAL TO THE RIGHT DATAITEM AND IF THE RIGHT DATAITEM IS DELETED, IF TRUE, VALUE IS FOUND
            if(value == curNode.getRightData().getValue() && !curNode.getRightData().isDeleted())
            {
                key = true;
            }
            //CHECKS IF THE VALUE IS LESS THAN THE RIGHT DATAITEM AND IF THERE EXIST A MIDDLE NODE, IF TRUE, RECURSION TO THE MIDDLE NODE
            else if(value < curNode.getRightData().getValue() && curNode.getChildrenNode(1) != null)
            {
                key = recFind(curNode.getChildrenNode(1),value);
            }
            //CHECKS IF THE VALUE IS GREATED THAN THE RIGHT DATAITEM AND IF THERE EXIST A RIGHT NODE, IF TRUE, RECURSION TO THE RIGHT NODE
            else if(value > curNode.getRightData().getValue() && curNode.getChildrenNode(2) != null)
            {
                key = recFind(curNode.getChildrenNode(2),value);
            }  
        }
        //SINCE VALUE WAS NOT FOUND IN THE TRUE, KEY IS FALSE
        else 
        {
            key = false;
        }
        
        return key;  
    }
      
    /*
    Method Name: Delete()
    Purpose: deletes a value found in tree
    Parameter: int
    Method Input: recDelete()
    Return Value: none
    Date: 12/02/2017
    */ 
    public void Delete(int value)
    {  
        recDelete(root,value);
    }
     
    /*
    Method Name: recDelete()
    Purpose: recurses through the tree to find the value that is to be deleted
    Parameter: TL_Node, int
    Method Input: recDelete()
    Return Value: none
    Date: 12/02/2017
    */ 
    private void recDelete(TL_Node curNode, int value)
    {
        //CHECKS IF THE VALUE IS EQUAL TO THE LEFT DATAITEM AND IF THE LEFT DATAITEM IS NOT DELETED, IF TRUE, SET DATAITEM DELETED AS TRUE
        if(value == curNode.getLeftData().getValue() && !curNode.getLeftData().isDeleted())
        {
            curNode.getLeftData().setDeleted(true);  
        }
        //CHECKS IF THE VALUE IS LESS THAN THE LEFT DATAITEM AND IF THERE EXIST A LEFT NODE, IF TRUE, RECURSION TO THE LEFT NODE
        else if(value < curNode.getLeftData().getValue() && curNode.getChildrenNode(0) != null)
        {
            recDelete(curNode.getChildrenNode(0), value);
        }
        //CHECKS IF THERE EXIST A RIGHT DATAITEM, IF TRUE, CONTINUE SEARCHING
        else if(curNode.getRightData() != null)
        {
            //CHECKS IF VALUE IS EQUAL TO THE RIGHT DATAITEM AND IF RIGHT DATAITEM IS DELETED, IF TRUE, THEN RIGHT DATAITEM'S DELETED IS SET TO TRUE
            if(value == curNode.getRightData().getValue() && !curNode.getRightData().isDeleted())
            {
                curNode.getRightData().setDeleted(true); 
            }
            //CHECKS IF THE VALUE IS LESS THAN THE RIGHT DATAITEM AND IF THERE EXIST A MIDDLE NODE, IF TRUE, RECURSION TO THE MIDDLE NODE
            else if(value < curNode.getRightData().getValue() && curNode.getChildrenNode(1) != null)
            {
               recDelete(curNode.getChildrenNode(1),value);
            }
            //CHECKS IF THE VALUE IS GREATED THAN THE RIGHT DATAITEM AND IF THERE EXIST A RIGHT NODE, IF TRUE, RESURSION TO THE RIGHT NODE
            else if(value > curNode.getRightData().getValue() && curNode.getChildrenNode(2) != null)
            {
               recDelete(curNode.getChildrenNode(2),value);
            }  
        }
        //IF THE VALUE DOES NOT EXIST IN THE TREE, THEN SEND THIS MESSAGE
        else
        {
            JOptionPane.showMessageDialog(null, "Number is not in tree, so no deletion was made.");
        } 
    }
  
    /*
    Method Name: NodeCount()
    Purpose: counts the node and how many values are stores in them
    Parameter: none
    Method Input: recNodeCount, decoder() 
    Return Value: String
    Date: 12/02/2017
    */ 
    public String NodeCount()
    {
	String nodeCount = recNodeCount(root);

	return Decoder(nodeCount);
}
   
    /*
    Method Name: recNodeCount()
    Purpose: recurses throught the tree and counts the node and occupancy
    Parameter: TL_Node
    Method Input: recNodeCount()
    Return Value: String
    Date: 12/02/2017
    */ 
    private String recNodeCount(TL_Node curNode)
    {
	String noteTaker = "";

        //CHECKS IF A LEFT NODE EXIST, IF TRUE, THEN RECURSION TO THE LEFT NODE
	if(curNode.getChildrenNode(0) != null)
	{
		noteTaker += recNodeCount(curNode.getChildrenNode(0));
	}
        //CHECKS IF A MIDDLE NODE EXIST. IF TRUE, THEN RECURSION TO THE MIDDLE NODE
	if(curNode.getChildrenNode(1) != null)
	{
		noteTaker += recNodeCount(curNode.getChildrenNode(1));
	}
        //CHECKS IF A RIGHT NODE EXIST, IF TRUE, THEN RESURSION TO THE RIGHT NODE
	if(curNode.getChildrenNode(2) != null)
	{
		noteTaker += recNodeCount(curNode.getChildrenNode(2));
	}
        // CHECK IF LEFT DATAITEM IS NOT DELETED AND IF RIGHT DATAITEM EXIST AND IF RIGHT DATAITEM IS NOT DELETED, IF BOTH DATAITEMS EXIST, THEN DO THAT
	if(!curNode.getLeftData().isDeleted() && (curNode.getRightData() != null && !curNode.getRightData().isDeleted()))
	{
		noteTaker+="B";
	}
        //CHECKS IF LEFT DATAITEM IS NOT DELETED OR IF RIGHT DATAITEM IS NOT DELETED
        else if(!curNode.getLeftData().isDeleted() || (curNode.getRightData() != null && !curNode.getRightData().isDeleted()))
	{	
		noteTaker+= "A";
	}
            
	return noteTaker;
    }
    
    /*
    Method Name: decoder()
    Purpose: reads a string to determine the node occupancy
    Parameter: String
    Method Input: node
    Return Value: String
    Date: 12/02/2017
    */ 
    private String Decoder(String strAB)
    {

	int countA = 0; // Number of nodes with one value
	int countB = 0; //number of nodes with two values
	
	for(int i = 0; i < strAB.length() ; i++)
	{
                //CHECKS IF STRING CHARACTER IS A, IF TRUE, INCREASE COUNTA
		if(Character.toString(strAB.charAt(i)).equals("A"))
		{
			countA += 1;
		}
                //CHECKS IF STRING CHARACTER IS B, IF TRUE, INCREASE COUNTB
		else
		{	
			countB += 1;
		}		
	}
	return "There are " + countA + " nodes with one value and " + countB + " nodes with two values.";
}
    
    /*
    Method Name: Print()
    Purpose: tranverses through tree and prints values in ascending order
    Parameter: string
    Method Input: recPrint()
    Return Value: String
    Date: 12/02/2017
    */ 
    public String Print()
    {
        return recPrint(root);
    }
      
    /*
    Method Name: recPrint()
    Purpose: recurses through tree and prints values
    Parameter: Tl_Node
    Method Input: recPrint()
    Return Value: String
    Date: 12/02/2017
    */ 
    private String recPrint(TL_Node curNode)
    {
        String collector = "";
    
        //CHECKS IF A LEFT NODE EXIST, IF TRUE, RECURSE TO THE LEFT NODE
        if(curNode.getChildrenNode(0) != null)
        {
            collector += recPrint(curNode.getChildrenNode(0));   
        }
        //CHECKS IF LEFT DATAITEM IS NOT DELETED, IF TRUE, THEN GET VALUE
        if(!curNode.getLeftData().isDeleted())
        {
            collector += curNode.getLeftData().getValue() + "\n";
        }
        
        //CHECLS IF RIGHT DATAITEM EXIST, IF TRUE, THEN CONTINUE TRANSVERSING
        if(curNode.getRightData() != null)
        {
            //CHECKS IF A MIDDLE NODE EXIST, IF TRUE, THEN RESURSE TO THE MIDDLE NODE
            if(curNode.getChildrenNode(1) != null)
            {
                collector += recPrint(curNode.getChildrenNode(1));
                
            }
            //CHECKS IF RIGHT DATAITEM IS NOT DELETED, IF TRUE, THEN GET VALUE
            if(!curNode.getRightData().isDeleted())
            {
                collector += curNode.getRightData().getValue() + "\n";
               
            }
            //CHECKS IF RIGHT NODE EXIST, IF TRUE, RECURSE TO THE RIGHT NODE
            if(curNode.getChildrenNode(2) != null)
            {
                collector += recPrint(curNode.getChildrenNode(2));  
            }
        }
        return collector;
    }
  
}
