package tree;

import java.util.Scanner;
import tree.Avl_Insertion.Node;

public class Avl_Deletion {
	
	static int min(Node temp)
	{
		while(temp.left!=null)
			temp=temp.left;
		return temp.data;
	}
	
	static Node deletion(Node root,int data)
	{
		try {
			
			if(root==null)
				return root;
		
			if(data<root.data)
				root.left=deletion(root.left,data);
			else if(data>root.data)
				root.right=deletion(root.right,data);
			else
			{
				if(root.left!=null && root.right!=null)
				{
					int temp=min(root.right);
					root.data=temp;
					root.right=deletion(root.right,temp);
				}
				else
				{
					if(root.left==null)
						root=root.right;
					else if(root.right==null)
						root=root.left;
				}
			}
		
			if(root==null)
				return root;
			root.height=1+Math.max(Avl_Insertion.height(root.left), Avl_Insertion.height(root.right));
			int balance=Avl_Insertion.getBalance(root);
		
			if(balance>1 && Avl_Insertion.getBalance(root.left)>=0)
				return Avl_Insertion.rightRotation(root);
			else if(balance>1 && Avl_Insertion.getBalance(root.left)<0)
			{
				root.left=Avl_Insertion.leftRotation(root.left);
				return Avl_Insertion.rightRotation(root);
			}
			else if(balance<-1 && Avl_Insertion.getBalance(root.right)<=0)
				return Avl_Insertion.leftRotation(root);
			else if(balance<-11 && Avl_Insertion.getBalance(root.right)>0)
			{
				root.right=Avl_Insertion.rightRotation(root.right);
				return Avl_Insertion.leftRotation(root);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
		return root;
		
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
		Node root=null;
		String s[]=sc.nextLine().split("\\s");
		for(int i=0;i<s.length;i++)
			root=Avl_Insertion.insert(root,Integer.parseInt(s[i]));
		root=deletion(root,10);
		preOrderTraversal(root);
		sc.close();
	}

}
