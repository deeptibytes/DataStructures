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
			 return node;
			 
	 }
	 
	 
	 
	 
	 
	 
	
	/*public int search(int key) {
			
		Node node = searchKey(root, key);
		
		if(node != null) return node.data;
		return -1;
		
	}
	
	private static Node searchKey(Node root, int key) {
		
		If root == NULL 
	    return NULL;
	If number == root->data 
	    return root->data;
	If number < root->data 
	    return search(root->left)
	If number > root->data 
	    return search(root->right)
		
		if(root == null) return null;
		if( root.data == key ) return root;
		if(key > root.data) return searchKey(root.right, key);
		return searchKey(root.left, key);//if(key > root.data)
	}
	
	
	
	
	
	
	
	 * Insert with Recursion
	 
	public void insert(int key) {
		
		root = insertKey(root, key);	//very important to return the value here	
	    //insertKey(root, key);	//if you do this, root will be null in subsequent calls. Pss by value
	}
	
	private Node insertKey(Node root, int key) {
		
		if(root == null) {
			root = new Node(key);
		    return root;
		}	
		
		if(key > root.data) 
			root.right =  insertKey(root.right, key);
		if(key < root.data) 
			root.left =  insertKey(root.left, key);
		
		return root;
	}
	
	
	
	 * Insert with iteration
	 
  public Node insertIteration(int key) {
		
	  
	  Node newNode = new Node(key);
	  
		if(root == null) {
			root = newNode;
		    return root;
		}
		
		
		
		Node current = root;
		Node parent;
		
		while(true) {
			parent = current;
			
			if(key > current.data) {//traverse left subtree
				current = current.right;
				if(current == null) {
					parent.right = newNode;
					return newNode;
				}
			}
			
			if(key < current.data) { //traverse right subtree
				current = current.left;
				if(current == null) {
					parent.left = newNode;
					return newNode;
				}
			}
			
		}//what if key == current.data
	
		

	}
	
	
	
	//Inorder traversal of BST
	 void inorder()  { 
	       inorderRec(root); 
	    } 
	 
	  * Algorithm Inorder(tree)
   1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   2. Visit the root.
   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
	  
	 
	 void inorderRec(Node root) { 
	        if(root != null) {
	        	inorderRec(root.left);
	        	System.out.print(root.data + "---> ");
	        	inorderRec(root.right);
	        	
	        	
	        }
	    } 
	
	
	 void deleteKey(int key) {
		    root = deleteRec(root, key);
		  }

     
	 
	 Node deleteKey(Node root, int key) {
		 BinarySearchTree bst = new BinarySearchTree();
		 //First search the node to be deleted.
		 Node toBeDeleted = bst.searchKey(root, key);
		 
		 if(toBeDeleted == null) return null;
		 
		//Case 1 :: toBeDeleted is the leaf node
		 if(toBeDeleted.left == null && toBeDeleted.right == null) {
			 toBeDeleted = null;
		 }
		 
		//Case 2 :: toBeDeleted has only one child
		    //2.1 toBeDeleted has only one LEFT child, put that left child in toBeDeleted node.
		 if(toBeDeleted.right == null) toBeDeleted = toBeDeleted.left;
		   //2.2toBeDeleted has only one RIGHT child, put that left child in toBeDeleted node.
		 if(toBeDeleted.left == null) toBeDeleted = toBeDeleted.right;
		 
		
		 * Case 3:: tobeDeleted has 2 children. Find the inorder successor 
		 * Inorder successor is the minimum value in right child of the node. so we need to traverse left side of right child
		 
		 
		 //3.1 replace toBeDeleted key with inorder successor.
		 toBeDeleted.data = findSuccessor(toBeDeleted.right);
		 
		 //3.2 delete inorder successor. Call recursive delete method.
		 deleteKey(toBeDeleted.right, toBeDeleted.data);//why we cant call delete(key) here?? think think think!!!!
		 
		 
	 }
	 
	 
	 private int findSuccessor(Node node) {//means find minimum
		 int minValue = node.data;
		 
		 while(node.left!=null) {
			 minValue = node.left.data;
			 node = node.left;			 
		 }
		 
		 return minValue;
	 }
	 
	 
	 private int findMax() {
		 int maxValue = root.data;
		 
		 while(root.right!=null) {
			 root = root.right;	
			 maxValue = root.data;
			 		 
		 }
		 
		 return maxValue;
	 }




	 
	 */
	 
	 
	 
	 }
