package tree;

import java.util.Scanner;

public class PrintLeaf {

	static BinaryTree.Node removeLeaf(BinaryTree.Node root)
	{
		
		if(root==null)
			return null;
		
		if(root.left==null && root.right==null)
			return null;
		
		root.left=removeLeaf(root.left);
		root.right=removeLeaf(root.right);
		
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
			
		
		BinaryTree.Node root=BinaryTree.insert(sc.nextLine().split("\\s"));
		
		removeLeaf(root);
		
		
		
		BinaryTree.display(root);
		sc.close();

	}

}
