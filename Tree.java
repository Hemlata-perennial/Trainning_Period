
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hemlata  Ahire
 */
public class Tree {
    private class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode RightChild;
        
        TreeNode(int data)
        {
            this.data=data;
        }
    }
    TreeNode root=null;
    public void search(int key)
    {
        TreeNode temp;
        temp=root;
        
        if(temp.data==key)
        {
            System.out.println(key+" found at root node");
        }
        else
        {
            while(temp.data !=key)
            {
                if( key<temp.data)
                {
                    temp=temp.leftChild;
                    
                }
                else
                {
                    temp=temp.RightChild;
                  
                }
              if(temp==null)
              {
                  System.out.println("not found");
              }
            }
            
            
        }
    }
    public void inorder(TreeNode head)
    {
        
        if(head!=null)
        {
            inorder(head.leftChild);
            System.out.println(head.data);
            inorder(head.RightChild);
        }
    }
    public void preorder(TreeNode head)
    {
        
        if(head!=null)
        {
            
            System.out.println(head.data);
            inorder(head.leftChild);
            inorder(head.RightChild);
        }
    }
    public void postorder(TreeNode head)
    {
        
        if(head!=null)
        {
            
            
            inorder(head.leftChild);
            inorder(head.RightChild);
            System.out.println(head.data);
        }
    }
    
    public void addNode(int val)
    {
        TreeNode newNode=new TreeNode(val);
        if(root==null)
        {
            root=newNode;
            System.out.println(val+" is now root node");
        }
        else
        {
            TreeNode tempNode;
            TreeNode parent;
            tempNode=root;
            while(true)
            {
                parent=tempNode;
                if(val<parent.data)
                {
                    tempNode=tempNode.leftChild;
                    if(tempNode==null)
                    {
                        parent.leftChild=newNode;
                        System.out.println(val+" is added to left of "+ parent.data);
                        return;
                    }
                    
                }else
                {
                    tempNode=tempNode.RightChild;
                    if(tempNode==null)
                    {
                        parent.RightChild=newNode;
                        System.out.println(val+" is added to right of "+ parent.data);
                        return;
                    }
                }
            }
            
        }
    }
    
    public static void main(String[] args)
    {
        Tree t=new Tree();
        int ip;
        Scanner sc=new Scanner(System.in);
       System.out.println("Enter number of node in a tree ");
       ip=sc.nextInt();
        int num;
        for(int i=0;i<ip;i++)
        {
            num=sc.nextInt();
            t.addNode(num);
        }
        System.out.println("Inorder of a tree is : ");
        t.inorder(t.root);
        System.out.println("preorder of a tree is : ");
         t.preorder(t.root);
         System.out.println("postorder of a tree is : ");
          t.postorder(t.root);
          System.out.println("enter key to search : ");
          int k=sc.nextInt();
          t.search(k);
    }
    
    
}
