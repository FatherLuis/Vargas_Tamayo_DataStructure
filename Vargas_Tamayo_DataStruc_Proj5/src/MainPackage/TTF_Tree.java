/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;


/*

Class name: TTF_Tree

Class Author: Luis E. Vargas Tamayo

Purpose of the class: The 2-3-4 tree will hold the word and count in this balanced tree

Date: 10/30/2017

List of changes with dates: none

Special Notes: none

*/ 
public class TTF_Tree
{
    private TTF_Node root = new TTF_Node(); //Creates a TTF_Node object

    /* 
    Method Name: Insert()
    Method Inputted: Split(), getNextChild(),
    Parameters: String 
    Purpose: Inserts new word into the TTF_Tree
    Return:  none
    Date: 10/30/2017
    */ 
    public void insert(String newTerm)
    {
        TTF_Node curNode = root; //Holds the root
        DataInfo tempItem = new DataInfo(newTerm); //Create a DataInfo Object, here lies the container of the word
        
        while(true)
        {
            if(curNode.isFull()) //Checks if the TTF_Node is filled (DataInfo objects Max of 3)
            {
                split(curNode); //Splits the current Node
                curNode = curNode.getParent(); //current Node gets his parent and is stored in curNode
                curNode = getNextChild(curNode, newTerm); //curNode becomes the Node of the child that is not filled
            }
            else if (curNode.isLeaf()) //Checks if the TTF_node is a leaf (No Children)
            {
                break; 
            }
            else
            {
                if(!curNode.duplicate(tempItem)) // Checks if the incoming word is a duplicate in the current TTF_Node
                {
                    curNode = getNextChild(curNode, newTerm); // if its not, it goes to the children
                }
                else
                {
                    break;
                }
            }    
        }
        
        curNode.insertItem(tempItem);// Inserts the DataInfo object into the Node 
    }
 
    /* 
    Method Name: Split()
    Method Inputted: none
    Parameters: TTF_Node
    Purpose: Splits the TFF_Node and creates new one due to capacity reasons
    Return: none
    Date: 10/30/2017
    */    
    private void split(TTF_Node thisNode)
    {
        DataInfo itemB, itemC; //Create reference variables of type DataInfo
        TTF_Node parent, child2, child3; // creates reference variables of type TTF_Node
        int itemIndex; //Create reference variable of type int
        
        itemC = thisNode.removeItem(); //removes DataInfo from Node and stores it here
        itemB = thisNode.removeItem(); //removes DataInfo from Node and stores it here
        child2 = thisNode.disconnectChild(2); //Disconnects child from Parent and stores it here
        child3 = thisNode.disconnectChild(3); //Disconnects child from Parent and stores it here
        
        TTF_Node newRight = new TTF_Node(); //Creates new TTF_Node
        
        if(thisNode == root) // is the node that split is the root, then do code
        {
            root = new TTF_Node(); //Root becomes a new TTF_node
            parent = root; //The parent becomes the root
            root.connectChild(0, thisNode);// connect the children to the root
        }
        else
        {
            parent = thisNode.getParent(); // Gets the parent of the Node that split  
        }
        
        itemIndex = parent.insertItem(itemB); // Gets the number of DataInfo items the parent has 
        int n = parent.getNumItems(); // Number of num items parent has
        
        for (int i = n-1; i > itemIndex; i--) // For loop and sees the array of children
        {
            TTF_Node temp = parent.disconnectChild(i); // Children is sent away from parent
            parent.connectChild(i+1, temp); //parent gets new chldren
        }
        
        parent.connectChild(itemIndex+1, newRight); //Parent gets new children
        newRight.insertItem(itemC); //Data Item is given to new child
        newRight.connectChild(0, child2); // Child is connected to parent
        newRight.connectChild(1,child3); //Child is connected to parent
    }
  
    /* 
    Method Name: getNextChild() 
    Method Inputted: none
    Parameters: TTF_Node, String
    Purpose: Gets the next TTF_Node from current TTF_Node
    Return: TTF_Node
    Date: 10/30/2017
    */    
    private TTF_Node getNextChild(TTF_Node currentNode, String newTerm)
    {
        int j; // Counter 
        int numItems = currentNode.getNumItems(); // Gets number of items stored in Node
        
        for(j=0; j<numItems; j++) //Iterates through array
        {
            if(newTerm.compareTo(currentNode.getItem(j).term) < 0)  //compares the incoming word to the word already in the tree, if incoming word is first alphabetically
            {
                return currentNode.getChild(j); // return child Node
            }
        }
        return currentNode.getChild(j); //returns last child on the list
    }
  
    /* 
    Method Name: displayTree()
    Method Inputted:recDisplay() 
    Parameters: none
    Purpose: Goes through the tree collecting all the words 
    Return: String
    Date: 10/30/2017
    */    
    public String displayTree()
    {
        String collector = recDisplayTree(root); // gets all the words w/ their count from the tree
        return collector; // returns the collected words

    }
  
    /* 
    Method Name: recDisplayTree()
    Method Inputted: recDisplayTree()
    Parameters: TTF_Node
    Purpose: Goes through the TTF_Node and gets the words stored
    Return: String
    Date: 10/30/2017
    */   
    private String recDisplayTree(TTF_Node currentNode) 
    {
        String collector=""; // will hold word
        
        if(!currentNode.isLeaf()) // if current Node is not a leaf
        {
            int numChildren = currentNode.getNumItems();// get the number of children 
            
            for(int i = 0; i < numChildren +1; i++) //iterate
            {
                TTF_Node nextNode = currentNode.getChild(i); //get the child of the current node
                collector +=recDisplayTree(nextNode); // recursion
                
                try
                {
                    collector += currentNode.getItem(i).term + ": " +currentNode.getItem(i).count + "\n"; // collects the word and count
                
                }
                catch(Exception ex)
                {}  
            }
  
        }
        else
        {
            collector += currentNode.displayNode(); // Collects the word and count
        }
      
        
        return collector; // returns collection of words
   
    }
}
