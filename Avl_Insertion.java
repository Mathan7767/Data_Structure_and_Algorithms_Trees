package tree;

import java.util.Scanner;

public class Avl_Insertion 
{
	static class Node
	{
		int data,height;
		Node left,right;
		
		Node(int data)
		{
			this.data=data;
			this.height=1;
		}
	}
	static int height(Node temp)
	{
		return (temp==null)?0:temp.height;
	}
	
	static int getBalance(Node temp)
	{
		return (temp==null)?0:height(temp.left)-height(temp.right);
	}
	static Node insert(Node root,int data)
	{
	
		if(root==null)
			return (new Node(data));
		if(data<root.data)
			root.left=insert(root.left,data);
		else if(data>root.data)
			root.right=insert(root.right,data);
		else
			return root;
		
		root.height=1+Math.max(height(root.left), height(root.right));
		
		int balance=getBalance(root);
		
		if(balance>1 && data<root.left.data)
			return rightRotation(root);
		else if(balance>1 && data>root.left.data)
		{
			root.left=leftRotation(root.left);
			return rightRotation(root);
		}
		else if(balance<-1 && data>root.right.data)
			return leftRotation(root);
		else if(balance<-1 && data<root.right.data)
		{
			root.right=rightRotation(root.right);
			return leftRotation(root);
		}
		
		return root;
			
	}
	
	static Node leftRotation(Node root)
	{
		Node temp=root.right;
		Node old=temp.left;
		
		temp.left=root;
		root.right=old;
		
		root.height=Math.max(height(root.left), height(root.right))+1;
		temp.height=Math.max(height(temp.left), height(temp.right))+1;
		
		return temp;
	}
	static Node rightRotation(Node root)
	{
		Node temp=root.left;
		Node old=temp.right;
		
		temp.right=root;
		root.left=old;
		
		root.height=Math.max(height(root.left),height(root.right));
		temp.height=Math.max(height(temp.left), height(temp.right))+1;
		
		return temp;
	}
	static void preOrderTraversal(Node temp)
	{
		if(temp==null)
			return;
		System.out.print(temp.data+" ");
		preOrderTraversal(temp.left);
		preOrderTraversal(temp.right);
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s[]=sc.nextLine().split("\\s");
		Node root=null;
		for(int i=0;i<s.length;i++)
			root=insert(root,Integer.parseInt(s[i]));
		preOrderTraversal(root);
		sc.close();
	}
}
