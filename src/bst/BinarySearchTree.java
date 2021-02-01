package bst;

public class BinarySearchTree {
	
	//https://www.netjstech.com/2019/03/delete-node-from-binary-search-tree-java.html
	
	
	Node root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree bst = new BinarySearchTree ();
		//bst.insertIteration(20);
		
		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		bst.insert(7);
		bst.insert(12);
		bst.insert(25);
		bst.insert(17);
		
		System.out.println("Inorder traversal of the given tree"); 
        bst.inorderRec(); 
		
     /*   System.out.println();
		System.out.println("Max Number is "+bst.findMax());
		System.out.println("Min Number is "+bst.findMin());
		
		System.out.println("Searching 20 "+bst.search(20));
		
		bst.delete(25);
		System.out.println("Inorder traversal of the given tree after deletion"); 
        bst.inorderRec(); */

	}
	
	 void inorderRec() { 
     	inorderRec(root);
     	
     	
     }
	 void inorderRec(Node root) { 
	        if(root != null) {
	        	inorderRec(root.left);
	        	System.out.print(root.data + "---> ");
	        	inorderRec(root.right);
	        	
	        	
	        }
	    }
	 
	
	    
	public void insert(int key) {
		root = insertKey(root, key);
	}
	
	 
	 public Node insertKey( Node node, int key) { //class variables should not be passed in recursive function
	
		if(node == null) {
			node = new Node(key);//base case creating new object so necessary to return value
			return node;
		}
		
		
		if(key == node.data) return null; //key is already present in Tree
		
		
		if(key < node.data) {
			node.left = insertKey(node.left, key);//once we pass null here, 
			//then base case will be triggered and node.left will be assigned to not null value. therefore necessary to save returned value
		}else {
			node.right = insertKey(node.right, key);
		}
		
		return node;//this is the root of tree passed in the method not the inserted node!!!
	}
	 
	 public int search(int key) {
		 return searchKey(root, key);
	 }
	 
	 public int searchKey(Node node, int key) {
		 
		 if(node == null) {
			 return -1;
		 }else if(node.data == key) {
			 return key; //base case not creating any new object. not necessary to return
		 }else if(key < node.data) {
			 return searchKey(node.left, key);
		 }else {
			 return searchKey(node.right, key);
		 }
		 
		 
	 }
	 public int findMax() {
		 return findMax(root);
	 }
	 public int findMax(Node node) {
		 		 
		 if(node == null) return -1 ;
		 if(node.right == null) return node.data;		 
		 return findMax(node.right);
		 
		 
	 }
	 
	 public int findMin() {
		 return findMin(root);
	 }
	 public int findMin(Node node) {
		 		 
		 if(node == null) return -1 ;
		 if(node.left == null) return node.data;		 
		 return findMin(node.left);
		 
		 
	 }
	 
	 
	 public void delete(int key) {
		 root =  deleteKey(root, key);
		 
	 }
	 public Node deleteKey(Node node, int key) {
		 
		 if(node == null) return null;
		 else if (key < node.data)
			 node.left =  deleteKey(node.left, key);
		 else if (key > node.data)  
		 node.right =  deleteKey(node.right, key);
		 
		 else { //node == nodeToDelete  or key == node.data
			 
			 if(node.left == null && node.right == null) {//leaf node
				 node = null;				 
			 } else if(node.right == null) {//having only one child--left
				 node = node.left;
			 }else if(node.left == null) {////having only one child-right
				 node = node.right;
			 }else {//complex case
				 int min = findMin(node.right);//pay attention, here we are replacing node data with successor data. We are not replacing 
				 //entire node. Why? if you replace entire node, you have to reassign references. Successor has different left and right and 
				 //nodeToDelete has different left and right. If you replace, we have to reassign left and right references to correct one. In case of leaf node, re replace entire node because 1. leaf Node. parent will still point to null. 
				 //2. In case of one child case --> we put the that child in place of node ToDelete because child left and right is null
				 //and after we put child in nodeToDelete, still left and right will be null
				 node.data = min;
				 
				 //delete min node now
				 
				 node.right = deleteKey(node.right, min);				 
			 }
			 
			 
		 }	 
			 return node;//this is root of the tree not the deleted node
			 
	 }
	 
	 
	 
	 
	 
	 
	 }
