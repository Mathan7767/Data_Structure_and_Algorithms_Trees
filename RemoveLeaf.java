package tree;

import java.util.Scanner;

public class RemoveLeaf {
	
	static BinaryTree.Node remove(BinaryTree.Node temp)
	{
		if(temp==null || (temp.left==null && temp.right==null))
			return null;
		
		temp.left=remove(temp.left);
		temp.right=remove(temp.right);
		
		return temp;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		BinaryTree.Node root=BinaryTree.insert(sc.nextLine().split("\\s"));
		remove(root);
		BinaryTree.display(root);
		sc.close();
	}

}
