package tree;

import java.util.Scanner;

public class BoundaryTraversal {
	
	static void printLeft(BinaryTree.Node root)
	{
		if(root==null)
			return;
		
		if(root.left!=null)
		{
			System.out.print(root.data+" ");
			printLeft(root.left);
		}
		else if(root.right!=null)
		{
			System.out.print(root.data+" ");
			printLeft(root.right);
		}
		else
			return;
	}
	static void printLeaves(BinaryTree.Node root)
	{
		if(root==null)
			return;
		printLeaves(root.left);
		if(root.left==null && root.right==null)
		{
			System.out.print(root.data+" ");
			return;
		}
		
		printLeaves(root.right);
	}
	
	static void printRight(BinaryTree.Node root)
	{
		if(root==null)
			return;
		
		if(root.right!=null)
		{
			printRight(root.right);
			System.out.print(root.data+" ");
		}
		else if(root.left!=null)
		{
			printRight(root.left);
			System.out.print(root.data+" ");
		}
		else 
			return;
	}
	static void boundaryTraversal(BinaryTree.Node root)
	{
		if(root==null)
			return;
		System.out.print(root.data+" ");
		printLeft(root.left);
		printLeaves(root);
		printRight(root.right);
		
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		BinaryTree.Node root=BinaryTree.insert(sc.nextLine().split("\\s"));
		
		boundaryTraversal(root);
		//BinaryTree.display(root);
		sc.close();
	}

}
