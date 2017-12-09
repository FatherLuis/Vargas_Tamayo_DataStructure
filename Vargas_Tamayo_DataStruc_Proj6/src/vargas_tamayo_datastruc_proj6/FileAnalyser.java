/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vargas_tamayo_datastruc_proj6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;




/*

Class name: FileAnalyser

Class Author: Luis E. Vargas Tamayo

Purpose of the class: Reads Textfile and stores the string representation in a class variable 

Date: 10/03/2017

List of changes with dates: none

Special Notes: none

*/ 

public class FileAnalyser 
{
    
    private File textFile;
    private String strFile;
    private String fileName;
    private HashTable Table;
    
    
    /* 
    Method Name: FileAnalyser
    Method Inputted: none
    Parameters: File
    Purpose: constructor
    Return: none
    Date: 10/3/2017
    */ 
    public FileAnalyser(File textFile)
    {
        this.textFile = textFile;
        this.strFile = "";
    } 
       
    /* 
    Method Name: getFileName()
    Method Inputted: none
    Parameters: none
    Purpose: returns file Name
    Return: String
    Date:  10/3/2017
    */      
    public String getFileName(){return fileName;}      
    
    /* 
    Method Name: 
    Method Inputted: 
    Parameters: 
    Purpose:
    Return: 
    Date:  11/13/2017
    */  
    public HashTable getHashTable(){return Table;}
    
    /* 
    Method Name: readFile()
    Method Inputted: cleanScan()
    Parameters: none
    Purpose: Reads text file, then gets word and places them in alphabetical order and stores it in a private variable
    Return: none
    Date: 10/3/2017
    */ 
    public void readFile() throws IOException 
    {
        String fileName = textFile.getAbsolutePath(); //gets file's path
        
        this.fileName = textFile.getName(); // gets simple name of the File and stores it in private variable
        BufferedReader br = new BufferedReader(new FileReader(fileName));    //not sure what this is
        
        try 
        {
            StringBuilder sb = new StringBuilder(); // reads from ACII to Strings ?
            String line = br.readLine(); //Reads each line of text file

            while (line != null)  //while there exist a String?
            {
                sb.append(line); //continues
                sb.append(" "); //I am not sure
                line = br.readLine(); //not sure here either
            }
            
            
            
            strFile = sb.toString(); // the read text file is stored as a string in the private variable strFile
            
            composer(strFile); // changes the string to alphabetical order
        }
        finally 
        {
            br.close(); // closes file
        }

    }
        
    /* 
    Method Name: composer
    Method Inputted: none
    Parameters: String 
    Purpose: Takes a sentence,splits the words, and stores them in a binary tree
    Return: none
    Date: 10/3/2017
    */      
    private void composer(String sentence) 
    {      
        String word =""; // compiler wanted this initialized... empty variable

        Table = new HashTable();
        
        int i = 0;
        for(i=0; i< sentence.length(); i++) // will read each character in the String sentence
        {
            
            if(!Character.toString(sentence.charAt(i)).equals(" ")) // if the character in a given element is not a blank space,then the code will run
            {
                if(specialCase(Character.toString(sentence.charAt(i)))) // if the character is a given element is not a special character, then the code will run
                {
                    word+=Character.toString(sentence.charAt(i)); //the character of a given element is concantenated 
                }
            }
            
            if((Character.toString(sentence.charAt(i)).equals(" ") || i==sentence.length()-1) && !word.isEmpty())      
            {
               if(!word.isEmpty() && !word.trim().equals(""))
               {
                   
                   Table.put(word.trim().toLowerCase());
               }
               
                word = "";
 
            }       
        }
    
    }

    /* 
    Method Name: specialCase
    Method Inputted: none
    Parameters: String input
    Purpose: compares a single character and matches it with the special characters.. if there's a match, returns false
    Return: boolean key
    Date: 7/18/2017
    */
    private boolean specialCase(String characterInput)
    {
        String compare = characterInput; //parameter is stored in this variable
        boolean key = false; // initialized as false
        
        switch(compare) //if the character stored in compare is a special character, then, key stays false
        {
            //special characters found on an American Englsih keyboard... there may be more in other languages
            case"!": break;
            case"@": break;
            case"#": break;
            case"$": break;
            case"%": break;
            case"^": break;                    
            case"&": break;
            case"*": break;
            case"(": break;        
            case")": break;
            case"-": break;
            case"_": break;
            case"+": break;
            case"=": break;
            case"`": break;                    
            case"~": break;
            case"[": break;
            case"]": break;       
            case"{": break;
            case"}": break;
            case"\\":break; //escapes the special thing it does....  
            case"|": break;
            case";": break;
            case":": break;        
            case"\'":break; //escapes the second pair of quotation marks
            case"\"":break; //escapes the second pair of double quotation marks
            case"<": break;
            case">": break;
            case",": break;                    
            case".": break;
            case"?": break;
            case"/": break;  
            //case" ": break;
            default: key = true; //if compare was not a special character, then key is set to true
           
        }
        
        return key; // returns the boolean key
        
    }
 

    
    
    
    
    
  
    
    
    
    
    
}
