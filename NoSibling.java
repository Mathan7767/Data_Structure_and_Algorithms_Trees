package tree;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import tree.BinaryTree.Node;
public class NoSibling {

	static void noSibling(Node temp,Set<Integer> set)
	{
		if(temp==null)
			return;
		
		if(temp.left!=null && temp.right==null)
			set.add(temp.left.data);

		if(temp.left==null && temp.right!=null)
			set.add(temp.right.data);
		
		noSibling(temp.left, set);
		noSibling(temp.right, set);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Node root=BinaryTree.insert(sc.nextLine().split("\\s"));
		Set<Integer> set=new TreeSet<>();
		
		noSibling(root,set);
		
		if(set.isEmpty())
			System.out.println("-1");
		else
		{
			Iterator<Integer> itr=set.iterator();
			while(itr.hasNext())
				System.out.print(itr.next()+" ");
			
		}
		
		sc.close();
	}

}
