/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vargas_tamayo_datastruc_proj6;

import javax.swing.JOptionPane;

/*

Class name: HashTable

Class Author: Luis E. Vargas Tamayo

Purpose of the class: Creates the environment for a classic hash tables

Date: 11/13/2017

List of changes with dates: none

Special Notes: none

*/ 
public class HashTable 
{
    LinkList[] Table;
    
    /* 
    Method Name: HashTable()
    Method Inputted: none
    Parameters: none
    Purpose: Constructor
    Return: none
    Date:  11/13/2017
    */ 
    public HashTable()
    {
        Table = new LinkList[1000];     
    }
    
    /* 
    Method Name: put() 
    Method Inputted: HashFunctionKey()
    Parameters: String
    Purpose: Places the string in a hash table
    Return: none
    Date:  11/13/2017
    */ 
    public void put(String newWord)
    { 

         
        try
        {
                
        int indexKey = HashFunctionKey(newWord); //Gives a key for the location of the string
        
        System.out.println(newWord  + ": " + indexKey );
        //if(newWord.equals("greenbar")){System.out.println("greenbar: "+ indexKey);}
        
        
        if(indexKey <= 1000) //if the key is less than 1000
        {
            if(Table[indexKey] == null) //If the location in the array if empty, then fill it
            {
                LinkList newObj = new LinkList(); //new LinkList object is made
                newObj.setTerm(newWord); //New LinkList object is honored to store a string variable
                newObj.setLinkList(null); // LinkList reference variable is null
                
                Table[indexKey] = newObj; //LinkList is placed in the array            
            }
            else
            {
                LinkList temp = Table[indexKey]; // temp will reference the beginning of the temp
                
                do
                {
                    if(temp.getTerm().equals(newWord)) // if the parameter word is found in the hash table, dont do anything
                    {
                        break;
                    }
                    else if(temp.getNextLink() == null)
                    {
                        LinkList newObj = new LinkList(); //new LinkList object is made
                        newObj.setTerm(newWord); //New linklist object is honored to store a string variable
                        
                        temp.setLinkList(newObj);    //temp will hold the addreess of the new linklist
                        break;
                    } 
                    else
                    {
                        temp = temp.getNextLink();
                    }   
                }while(temp != null);
            } 
        }
        else //I'm pretty sure its not an english word
        {
            JOptionPane.showMessageDialog(null,"NOT AN ENGLISH WORD");
        }
        
        }
        catch(Exception ex)
        {
        }
    }
    
    /* 
    Method Name: isFound()
    Method Inputted: HashFunctionKey()
    Parameters: String
    Purpose: Checks if word is found in Hash Table
    Return: Boolean
    Date:  11/13/2017
    */ 
    public Boolean isFound(String findWord)
    {

        boolean isFound = false;
        
        try{
        
        int indexKey = HashFunctionKey(findWord);    //gets the key that this string would have
     
        if(Table[indexKey] != null) // if the location is not empty, then
        {
            LinkList temp = Table[indexKey]; //holds reference of location

                do
                {
                    
                    if(temp.getTerm().equals(findWord)) //if the linklist matches the word, then
                    {
                        isFound = true; //change to true that the word is found in hash table
                        break;
                    } 
                    else if(temp.getNextLink().getTerm().equals(findWord))
                    {
                        isFound = true; //change to true that the word is found in hash table
                        break;
                    }   
                    else if(temp.getNextLink() != null)
                    {
                        temp = temp.getNextLink();
                    }
                    else
                    {
                        break;
                    }
                }while(!(temp.getTerm().equals(findWord)));
                
                
        }
        }catch(Exception ex){}
        
        return isFound;
    }
    
    /* 
    Method Name: HashFunctionKey
    Method Inputted: LetterValue()
    Parameters: String
    Purpose: Creates a key for a String
    Return: integer
    Date:  11/13/2017
    */ 
    private int HashFunctionKey(String word)
    {
        int hashIndex=0;
        
        //iterates through string and gets the value of each character
        
        for(int i=0; i < word.length(); i++) 
        {
          
            hashIndex += LetterValue(Character.toString(word.charAt(i)));
        }
        
        return hashIndex;
    
    }
    
    /* 
    Method Name: LetterValue()
    Method Inputted: none
    Parameters: String
    Purpose: Places a weighted value on string 
    Return: integer
    Date:  11/13/2017
    */ 
    private int LetterValue(String letter)
    {
        int value = -1;
        
        switch(letter.toUpperCase())
        {
            case"A":value = 0;break;
            case"B":value = 1;break;                
            case"C":value = 2;break;                
            case"D":value = 3;break;
            case"E":value = 4;break;                
            case"F":value = 5;break;        
            case"G":value = 6;break;
            case"H":value = 7;break;                
            case"I":value = 8;break;        
            case"J":value = 9;break;
            case"K":value = 10;break;                
            case"L":value = 11;break;        
            case"M":value = 12;break;
            case"N":value = 13;break;                
            case"O":value = 14;break; 
            case"P":value = 15;break;
            case"Q":value = 16;break;                
            case"R":value = 17;break;        
            case"S":value = 18;break;
            case"T":value = 19;break;                
            case"U":value = 20;break;  
            case"V":value = 21;break;
            case"W":value = 22;break;                
            case"X":value = 23;break;        
            case"Y":value = 24;break;
            case"Z":value = 25;break;  
            default:break; 
        }       
        return value;
    }
    
    
    
    
    
    
    
    
    
    
}
