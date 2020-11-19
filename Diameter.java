package tree;

import java.util.Scanner;



public class Diameter 
{
	static int diameter(BinaryTree.Node root)
	{
		if(root==null)
			return 0;
		
		int lheight=height(root.left);
		int rheight=height(root.right);
		
		int ldiameter=diameter(root.left);
		int rdiameter=diameter(root.right);
		
		return Math.max(1+lheight+rheight,Math.max(ldiameter, rdiameter));
		
	}
	static int height(BinaryTree.Node root)
	{
		if(root==null)
			return 0;
		
		return 1+Math.max(height(root.left),height(root.right));
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		BinaryTree.Node root=BinaryTree.insert(sc.nextLine().split("\\s"));
		System.out.println(diameter(root));
		
		sc.close();
	}
}
