package vargas_tamayo_datastruc_proj4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*

Class name: BNode

Class Author: Luis E. Vargas Tamayo

Purpose of the class: creates Nodes for Binary Tree

Date: 10/03/2017

List of changes with dates: none

Special Notes: none

*/ 
public class BNode
{  
    private String term;
    private int count;
    private BNode left;
    private BNode right;
    
    
    public String getTerm(){return term;}
    public void setTerm(String term){this.term =term;};
    
    public int getCount(){return count;}
    public void setCount(int count){this.count=count;}
    
    public BNode getLeft(){return left;}
    public void setLeft(BNode left){this.left = left;}
    
    public BNode getRight(){return right;}
    public void setRight(BNode right){this.right = right;}

    
    
    
    
    
    
}



