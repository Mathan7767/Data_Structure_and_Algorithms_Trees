package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VerticalOrder {
	
	static void verticalTraversal(BinaryTree.Node root,int index,Map<Integer,List<Integer>> map)
	{
		if(root==null)
			return;
		
		List<Integer> l=map.get(index);
		if(l==null)
		{
			l=new ArrayList<>();
			l.add(root.data);
		}
		else
			l.add(root.data);
		
		map.put(index, l);
		
		verticalTraversal(root.left, index-1, map);
		verticalTraversal(root.right,index+1,map);
		
	}
	static void verticalTraversal(BinaryTree.Node root)
	{
		if(root==null)
			return;
		
		Map<Integer,List<Integer>> map=new TreeMap<>();
		verticalTraversal(root,0,map);
		
		Iterator<List<Integer>> itr=map.values().iterator();
		
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println("Sucess");
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		BinaryTree.Node root=BinaryTree.insert(sc.nextLine().split("\\s"));
		verticalTraversal(root);
		
		
		sc.close();
	}

}
