package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
	public static class BSTNode{
		int val;
		BSTNode left;
		BSTNode right;
		public BSTNode(){
			this.left=null;
			this.right=null;
			this.val=0;
		}
		public BSTNode(int n) {
			// TODO Auto-generated constructor stub
			this.val=n;
			this.left=null;
			this.right=null;
		}
	}
	public static BSTNode insertNode(BSTNode root,int val){
		if(root==null){
			root=new BSTNode(val);
		}
		else if(root.val>=val){
			root.left=insertNode(root.left,val);
		}
		else{
			root.right=insertNode(root.right, val);
		}
		return root;
		
	}
	public static BSTNode maxTree(BSTNode root){
		while(root.right!=null){
			root=root.right;
		}
		return root;
	}
	public static BSTNode minTree(BSTNode root){
		while(root.left!=null){
			root=root.left;
		}
		return root;
	}
	public static BSTNode nextSuccessor(BSTNode root,int val){
		Stack<BSTNode> stack=new Stack<BSTNode>();
		BSTNode node=root;
		while(node!=null){
			stack.push(node);
			node=node.left;
		}
		boolean status=false;
		while(!stack.isEmpty()){
			node=stack.pop();
			if(status){
				return node;
			}
			if(node.val==val){
				status=true;
			}
			node=node.right;
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
		}
		return null;
	}
	public static BSTNode nextPredecessor(BSTNode root,int val){
		Stack<BSTNode> stack=new Stack<BSTNode>();
		BSTNode node=root;
		while(node!=null){
			stack.push(node);
			node=node.right;
		}
		boolean status=false;
		while(!stack.isEmpty()){
			node=stack.pop();
			if(status){
				return node;
			}
			if(node.val==val){
				status=true;
			}
			node=node.left;
			while(node!=null){
				stack.push(node);
				node=node.right;
			}
		}
		return null;
	}
	public static BSTNode nthLargest(BSTNode root,int n){
		Stack<BSTNode> stack= new Stack<BST.BSTNode>();
		BSTNode node=root;
		while(node!=null){
			stack.push(node);
			node=node.right;
		}
		while(!stack.isEmpty()){
			node=stack.pop();
			n--;
			if(n==0)return node;
			node=node.left;
			while(node!=null){
				stack.push(node);
				node=node.right;
			}
		}
		return null;
	}
	public static boolean searchNode(BSTNode root,int val){
		if(root==null){
			return false;
		}
		else if (root.val==val)return true;
		else if (root.val>val)return searchNode(root.left, val);
		else return searchNode(root.right, val);
	}
	public static BSTNode getNode(BSTNode root,int val){
		if(root==null){
			return null;
		}
		else if (root.val==val)return root;
		else if (root.val>val)return getNode(root.left, val);
		else return getNode(root.right, val);
	}
	public static void inorderTraverse(BSTNode root){
		if(root!=null){
			inorderTraverse(root.left);
			System.out.print(root.val+" ");
			inorderTraverse(root.right);
		}
	}
	public static void preorderTraverse(BSTNode root){
		if(root!=null){
			System.out.print(root.val+" ");
			preorderTraverse(root.left);
			preorderTraverse(root.right);
		}
	}
	public static void postorderTraverse(BSTNode root){
		if(root!=null){
			postorderTraverse(root.left);
			postorderTraverse(root.right);
			System.out.print(root.val+" ");
			
		}
	}
	public static void breadthFirstTraverse(BSTNode root){
		Queue<BSTNode> queue=new LinkedList<BSTNode>();
		if(root!=null){
			queue.add(root);
			while(!queue.isEmpty()){
				BSTNode temp=queue.poll();
				System.out.print(temp.val+" ");
				if(temp.left!=null)queue.add(temp.left);
				if(temp.right!=null)queue.add(temp.right);
			}
		}
	}
	public static void inorderStack(BSTNode root){
		Stack<BSTNode> stack=new Stack<BST.BSTNode>();
		BSTNode node=root;
		while(node!=null){
			stack.push(node);
			node=node.left;
		}
		while(!stack.isEmpty()){
			node=stack.pop();
			System.out.print(node.val+" ");
			node=node.right;
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
		}
	}
	public static void reverseOrderStack(BSTNode root){
		Stack<BSTNode> stack=new Stack<BST.BSTNode>();
		BSTNode node=root;
		while(node!=null){
			stack.push(node);
			node=node.right;
		}
		while(!stack.isEmpty()){
			node=stack.pop();
			System.out.print(node.val+" ");
			node=node.left;
			while(node!=null){
				stack.push(node);
				node=node.right;
			}
		}
	}
	public static int findDepth(BSTNode root){
	         if (root == null) {
	            return 0;
	        }
	 
	        /* If tree is not empty then height = 1 + max of left
	         height and right heights */
	        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
		
	}
	public static BSTNode deleteNode(BSTNode root, int val){
		if(root==null)return root;
		else if(root.val>val)root.left=deleteNode(root.left, val);
		else if(root.val<val)root.right=deleteNode(root.right, val);
		else{
		if(root.left==null&&root.right==null){
			root=null;
		}
		else if(root.left==null){
			root=root.right;
		}
		else if(root.right==null){
			root=root.left;
		}
		else{
			BSTNode temp=minTree(root.right);
			root.val=temp.val;
			root.right=deleteNode(root.right, temp.val);
		}
		}
		return root;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTNode root;
		root=null;
		root=insertNode(root,15);
		root=insertNode(root,10);
		root=insertNode(root,8);
		root=insertNode(root,12);
		root=insertNode(root,20);
		root=insertNode(root,25);
		root=insertNode(root,16);
		root=insertNode(root,17);
		inorderTraverse(root);
		System.out.println("");
		preorderTraverse(root);
		System.out.println("");
		postorderTraverse(root);
		System.out.println("");
		breadthFirstTraverse(root);
		System.out.println("");
		System.out.println(searchNode(root, 1));
		BSTNode prev=nextPredecessor(root, 10);
		BSTNode	next=nextSuccessor(root, 10);
		System.out.println(prev.val);
		System.out.println(next.val);
		System.out.println(nthLargest(root, 3).val);
		inorderStack(root);
		System.out.println("");
		reverseOrderStack(root);
		System.out.println("");
		System.out.println(findDepth(root));
		root=deleteNode(root, 15);
		inorderTraverse(root);
	}

}
