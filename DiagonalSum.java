package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import tree.BinaryTree.Node;

public class DiagonalSum {
	
	static void diagonalSum(Node root,int index,Map<Integer,List<Integer>> map)
	{
		if(root==null)
			return;
		
		List<Integer> l=map.get(index);
		
		if(l==null)
			l=new ArrayList<>();
		l.add(root.data);
		map.put(index, l);
		
		diagonalSum(root.left,index-1,map);
		diagonalSum(root.right, index, map);
	}
	static int sum(List<Integer> l)
	{
		int sum=0;
		for(int i:l)
			sum+=i;
		return sum;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Node root=BinaryTree.insert(sc.nextLine().split("\\s"));
		Map<Integer,List<Integer>> map=new TreeMap<>(Collections.reverseOrder());
		diagonalSum(root,0,map);
		
		Iterator<List<Integer>> itr=map.values().iterator();
		
		while(itr.hasNext())
			System.out.print(sum(itr.next())+" ");
		
		
		sc.close();
	}
}
