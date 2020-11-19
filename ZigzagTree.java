package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ZigzagTree {
	static int count=0;
	static void zigzag(BinaryTree.Node root)
	{
		Queue<BinaryTree.Node> q=new LinkedList<>();
		q.add(root);
		q.add(null);
		List<Integer> l=new ArrayList<>();
		while(!q.isEmpty())
		{
			BinaryTree.Node temp=q.poll();
			if(temp==null)
			{
				if(!q.isEmpty())
					q.add(null);
				 if(count%2==0)
					 System.out.println(l);
				 else
				 {
					 Collections.reverse(l);
					 System.out.println(l);
				 }
				 count++;
				 l.clear();
				 
			}
			else
			{
				l.add(temp.data);
				
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		BinaryTree.Node root=BinaryTree.insert(sc.nextLine().split("\\s"));
		zigzag(root);
		sc.close();
	}

}
