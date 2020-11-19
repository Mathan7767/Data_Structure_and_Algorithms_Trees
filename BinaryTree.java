package tree;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree 
{
	static class Node
	{
		int data;
		Node left,right;
		
		Node(String data)
		{
			left=null;
			right=null;
			this.data=Integer.parseInt(data);
		}
	}
	
	static Node insert(String s[])
	{
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(s[0]));
		
		Node root=q.peek();
		
		for(int i=1;i<s.length;i++)
		{
			Node temp=q.poll();
			if(!s[i].equals("N") && temp.left==null)
					q.add(temp.left=new Node(s[i]));
			
			i++;
			
			if(i<s.length && !s[i].equals("N") && temp.right==null)
				q.add(temp.right=new Node(s[i]));
		}
		return root;
	}
	
	static void display(Node root)
	{
		/*boolean first=true;
		if(first)
		{
			System.out.print("Inorder Traversal");
			first=false;
		}*/
		if(root!=null)
		{
			display(root.left);
			System.out.print(root.data+" ");
			display(root.right);
		}
	}
	static void preOrderTraversal(Node temp)
	{
		if(temp==null)
			return;
		System.out.println(temp.data);
		preOrderTraversal(temp.left);
		preOrderTraversal(temp.right);
	}
	/*public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Node root=insert(sc.nextLine().split("\\s"));
		sc.close();
		
	}*/

}