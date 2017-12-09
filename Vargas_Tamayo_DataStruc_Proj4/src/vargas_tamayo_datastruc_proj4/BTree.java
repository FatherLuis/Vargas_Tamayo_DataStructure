package vargas_tamayo_datastruc_proj4;

/*

Class name: BTree

Class Author: Luis E. Vargas Tamayo

Purpose of the class: Creates the environment to make Binary trees

Date: 10/03/2017

List of changes with dates: none

Special Notes: none

*/ 
public class BTree 
{
    private BNode root;
    private BNode newNode;

    

    /* 
    Method Name: addNode()
    Method Inputted: recAdd()
    Parameters: String
    Purpose: adds a node to the Binary tree
    Return: none
    Date: 10/3/2017
    */     
    public void addNode(String newWord)
    {
        newNode = new BNode();
        newNode.setTerm(newWord.toLowerCase());
        newNode.setCount(0);
        
        if(root == null)
        {
            root = newNode;
        }
        else
        {
            //System.out.println("\nLine 56 "+newNode.getTerm()+" "+root.getTerm()+"\n");            
            recAdd(root);    
        }   
    }
 
    /* 
    Method Name: recAdd()
    Method Inputted: recAdd()
    Parameters: BNode
    Purpose: recurse until a null node is found and sets the new Node in its proper place
    Return: none
    Date: 10/3/2017
    */    
    private void recAdd(BNode recNode)
    {
        
       String a = recNode.getTerm(); // parameter node
       String b = newNode.getTerm(); // new node being added
        
        int compare = a.compareTo(b); // compares the two strings
           
        if(compare<0) //negative  [a] comes first
        {
            if(recNode.getRight()==null)
            {
                recNode.setRight(newNode); // sets newNode on the right of currect Node     
            }
            else
            {
                recAdd(recNode.getRight());   // move to the node on the right stored in current recNode                 
            }
        }
        else if(compare > 0) //positive [b] comes first
        {           
            if(recNode.getLeft()==null)
            {
                recNode.setLeft(newNode); // stores the new Node on the left of the current recNode
            }
            else
            { 
                recAdd(recNode.getLeft()); // move to the node on the left stored in current recNode                         
            }
        }
        else
        {
            recNode.setCount(recNode.getCount() + 1);  // if a repeated word was found, current recNode count increases by one
            //recNode.count++;
        }
        
        
    }
 
    /* 
    Method Name: PrintText()
    Method Inputted: none
    Parameters: none
    Purpose: Prints the terms found in the nodes in the Binary tree
    Return: String
    Date: 10/3/2017
    */    
    public String PrintText(){ return recPrint(root);}
  
    /* 
    Method Name:  recPrint()
    Method Inputted: recPrint()
    Parameters: BNode
    Purpose: goes through each node and collects the term variable
    Return: Alphabetical list of the words in the nodes in the binary tree
    Date: 10/3/2017
    */  
    private String recPrint(BNode node)
    { 
        String leftTerms=""; //initializes
        String rightTerms=""; //initializes
        
        if(node.getLeft() != null)
        {
            leftTerms =recPrint(node.getLeft()) +"\n";  // goes to the left and collects term
        }
        
        if(node.getRight() != null)
        {
            rightTerms="\n" + recPrint(node.getRight());  //goes to the right and collects term
        }
        
        return leftTerms + node.getTerm() +": " + node.getCount() + rightTerms; // puts everything together
    }
}

    
    
    
    
    
    
    
    
    
    
    
    
    

