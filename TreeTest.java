package t;

import java.util.Random;

public class TreeTest {
	
	public static void main(String[] args) {
	
		
		Random random = new Random();
		Node root = new Node();
		root.setData(5);
		root.setLeft(null);
		root.setRight(null);
	
		int rNum = random.nextInt();
		addNode(root,3);
		addNode(root,11);
		addNode(root,7);
		addNode(root,4);
		addNode(root,2);
		addNode(root,8);
		addNode(root,6);
		addNode(root,1);
		addNode(root,10);
		
		PreOrder(root);
		System.out.println("\n");
		PostOrder(root);
		System.out.println("\n");
		InOrder(root);
	}

	private static void addNode(Node root, int rNum) {
		Node newNode = new Node();
		newNode.setData(rNum);
		newNode.setRight(null);
		newNode.setLeft(null);
		
		Node p = root;
		while((p.getData() < rNum && p.getRight() != null) || (p.getData() > rNum && p.getLeft() != null)){
			if(p.getData() < rNum){
				p = p.getRight();
			}else{
				p = p.getLeft();
			}
		}
			
		if(p.getData() < rNum){
			p.setRight(newNode);
		}else{
			p.setLeft(newNode);
		}
	}
	
	private static void PreOrder(Node root){
		System.out.print(root.getData()+" ");
		if(root.getLeft() != null)PreOrder(root.getLeft());
		if(root.getRight() != null) PreOrder(root.getRight());
	}
	
	private static void PostOrder(Node root){
		if(root.getLeft() != null)PreOrder(root.getLeft());
		if(root.getRight() != null) PreOrder(root.getRight());
		System.out.print(root.getData()+" ");
		
	}

	private static void InOrder(Node root){
		if(root.getLeft() != null)PreOrder(root.getLeft());
		System.out.print(root.getData()+" ");
		if(root.getRight() != null) PreOrder(root.getRight());
	}
}
