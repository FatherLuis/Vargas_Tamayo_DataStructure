/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;



/*

Class name: TTF_Node

Class Author: Luis E. Vargas Tamayo

Purpose of the class: These is the Node and methods needed for the 2-3-4 Tree being constructed 

Date: 10/30/2017

List of changes with dates: none

Special Notes: none

*/ 
public class TTF_Node 
{
    
    private static final int ORDER = 4; // max number of children
    private int numItems;
    private TTF_Node parent;
    private TTF_Node childArray[] = new TTF_Node[ORDER];
    private DataInfo itemArray[] = new DataInfo[ORDER-1];

    
    /* 
    Method Name: connectedChild()
    Method Inputted: none
    Parameters: int, TTF_Node
    Purpose: Connects TTF_Node with parent TTF_Node
    Return: none
    Date: 10/30/2017
    */ 
    public void connectChild(int childNum, TTF_Node child)
    {
        childArray[childNum] = child;
        
        if(child != null)
        {
            child.parent = this;
        }
    }
    
    /* 
    Method Name: disconnectChild()
    Method Inputted: none
    Parameters: int
    Purpose: Disconnects TTF_Node from parent TTF_Node
    Return: TTF_Node
    Date: 10/30/2017
    */ 
    public TTF_Node disconnectChild(int childNum)
    {
        TTF_Node tempNode = childArray[childNum]; //collects adress of the soon-to-be-disconnected TTF_Node
        childArray[childNum] = null; //Clears TTF_Node spot
        return tempNode; //returns TTF_Node that was disconnected
    }
    
    /* 
    Method Name: getChild()
    Method Inputted: none
    Parameters: int
    Purpose: get child node
    Return: TTF_node
    Date: 10/30/2017
    */ 
    public TTF_Node getChild(int childNum)
    {
        return childArray[childNum];
    }
  
    /* 
    Method Name: getParent()
    Method Inputted: none
    Parameters: none
    Purpose: gets parent
    Return: TTF_Node
    Date: 10/30/2017
    */    
    public TTF_Node getParent()
    {
        return parent;
    }
  
    /* 
    Method Name: isLeaf()
    Method Inputted: none
    Parameters: none
    Purpose: Checks if TFF_Node has no children
    Return: boolean
    Date: 10/30/2017
    */     
    public boolean isLeaf()
    {
        return (childArray[0] == null) ? true : false; 
        //if first index of the array is null, then return true because there are no children, otherwise false
    }

    /* 
    Method Name: getNumItems()
    Method Inputted: none
    Parameters: none
    Purpose: gets the numItems from TTF_Node
    Return: int
    Date: 10/30/2017
    */     
    public int getNumItems()
    {
        return numItems;
    }
 
    /* 
    Method Name: getItem()
    Method Inputted: none
    Parameters: int
    Purpose: get item from given index
    Return: DataInfo
    Date: 10/30/2017
    */    
    public DataInfo getItem(int index)
    {
        return itemArray[index];
    }
   
    /* 
    Method Name: isFull()
    Method Inputted: none
    Parameters: none
    Purpose: checks if TTF_Node is full of DataInfo objects
    Return: boolean
    Date: 10/30/2017
    */     
    public boolean isFull()
    {
        //if number of items is equivalent to 3, then return true, otherwise false
        return (numItems == ORDER-1)? true : false;
    }
    
    /* 
    Method Name: insertItem()
    Method Inputted: duplicate()
    Parameters: DataInfo
    Purpose: inserts the word 
    Return: int
    Date: 10/30/2017
    */     
    public int insertItem(DataInfo newData)
    {
        
        numItems++; // number of items is increased
        String currentWord=""; // will hold the term from given DataInfo in the array
        boolean dupFree = duplicate(newData); // checks if its a duplicate
        
        String newWord = newData.term; // stores the parameter string here
        
        for(int i = ORDER-2; i >= 0; i--)//iterates
        {
            if (itemArray[i] == null) // if there are no items, move one
            {
                continue;
            }
            else // if not null
            {
                currentWord = itemArray[i].term; // gets current word from itemArray[]
                
                if(newWord.compareTo(currentWord) == 0) // if the current word and parameter word are the same, then
                {
                    numItems--; // decrease the item count
                    itemArray[i].count++; // increase the word count on DataInfo
                    break;  //leave the for-loop
                }
                else if(newWord.compareTo(currentWord) < 0 && !dupFree) // if the word is alphabetically first and is not a duplicate
                {
                    itemArray[i+1] = itemArray[i]; // move the current word up the ItemArray
                }
                else if (newWord.compareTo(currentWord) > 0 && !dupFree) //if the word is alphabetically last and is not a duplicate
                {                 
                        itemArray[i+1] = newData; // stores parameter word here
                        return i+1; // returns this
                    
                }        
            }
        }
        
        if(newWord.compareTo(currentWord) != 0){itemArray[0] = newData; } // if the word is not a duplicate, then new word is stored in the first index of ItemArray[]
                 

        return 0;
        
    }

    /* 
    Method Name: removeItem()
    Method Inputted: none
    Parameters: none
    Purpose: Removes an item from the array
    Return: returns the removed item ; DataInfo
    Date: 10/30/2017
    */     
    public DataInfo removeItem()
    {
        DataInfo temp = itemArray[numItems-1];
        itemArray[numItems-1] = null;
        numItems--;
        return temp;
    }
  
    /* 
    Method Name: displayNode()
    Method Inputted: none
    Parameters: none
    Purpose: Returns the words from the array stored in TTF_Node
    Return: String
    Date: 10/30/2017
    */     
    public String displayNode()
    {
        String collector = ""; // will hold the words
        
        for (int i = 0; i < numItems; i++) //iterates
        {
            collector += itemArray[i].displayItem() + "\n"; // gets the word and count from each index
        }
        
        return collector; // returns all the words with their counts

    }
 
    /* 
    Method Name: duplicate()
    Method Inputted: none
    Parameters: DataInfo
    Purpose: Checks if the incoming word is found in the stored words in the array
    Return: boolean
    Date: 10/30/2017
    */ 
    public boolean duplicate(DataInfo laNode)
    {
        boolean key = false; // default
        String currentWord="";
        
        String newWord; 
        
        for(int i = 2; i >= 0; i--) //iterates
        {
            newWord = laNode.term; // stores the value of the incoming word 
        
            if (itemArray[i]== null)
            {
                continue;
            }
            else
            {
                currentWord = itemArray[i].term; // holds the value of the words iterated from the array
                
                if(newWord.compareTo(currentWord) == 0) // if there is a match
                {
                    key = true; // key is true; there is a duplicate
                    break;//leave for-loop
                    
                }      
            }   
        }     
            
            
        return key; // returns boolean
        
    }
}
            
    
  
    
    
    

