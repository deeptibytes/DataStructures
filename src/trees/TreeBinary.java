package trees;

import bst.BinarySearchTree;

public class TreeBinary {

	Node root;
	
	/*
	 * Height/depth of single element tree or leaf node is 0
	 * Height of empty tree is -1
	 * Height of tree (height of root node)  and depth of tree (depth of leaf nodes) is always same
	 * Height and depth of any other node may or may not be the same.
	 * Depth: distance from root node (DL). root node has 0 depth
	 * Height: distance from leaf nodes (HL). leaf nodes has 0 height
	 * Full -- zero or 2 nodes
	 * Perfect --2 nodes. all leaf nodes at the same level
	 * Complete: Heap. grows from left to right. Once level is full then next level starts.  all levels are full except last level
	 * Balanced: height diff b/w left and right sub tree is no more than 1
	 * Number of levels in a tree is one less than maxHeight
	 */

	
	//https://www.geeksforgeeks.org/dfs-traversal-of-a-tree-using-recursion/
	
	//Depth First Traversal = inorder, postorder, preorder
	  /*         1
     *      2       3
     *  4      5         6
     *                7
     *              9
     */
		
	void inOrderTraversal(Node root) {
		if(root == null) return ;		
		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);	
	}
	
	void preOrderTraversal(Node root) {
		if(root == null) return ;
		System.out.println(root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	void postOrderTraversal(Node root) {
		if(root == null) return ;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root.data);
		
	}
	
	
	/*
	 * Breadth First Search...traverse level by level
	 *   /*         1
         *      2       3
         *  4      5         6
         *                7
         *              9
         */
	 
	
	void breadthFirstTraversal(Node root) {
		int height = getMaxTreeHeight(root);
		for(int i = 1; i<= height; i++) {
			System.out.println();
			System.out.print("Nodes at level "+i+"--> ");
			printByLevel(root, i);
		}
	}
	
	void printByLevel1(Node root, int level) {
		
		if(root == null)  
			return;
		
		
		if(level == 1)
		System.out.print(root.data + " "); 
		
		if(level > 1) {
			
			printByLevel(root.left, level - 1);
			printByLevel(root.right, level - 1);
		}
		
		
	}
	
	
	
	
	public int getMaxTreeHeight(Node root) {///same will be maxDepth. Same will be any Node height
		
		 /*         1
         *      2       3
         *  4      5         6
         *                7
         *              9
         */
   
		
		if(root ==null) {
			return 0; //we can also return -1, result will be same;
		}
		int LHeight = getMaxTreeHeight(root.left);
		int RHeight = getMaxTreeHeight(root.right);
		
		int maxHeight = (LHeight > RHeight)? LHeight: RHeight;
		return maxHeight + 1 ;//+1 is done to add root
		
		
	}
	
  
	
	public int getNumberOfNodes(Node root) {
		if(root ==null) {
			return 0;
		}
	int lNodes = getNumberOfNodes(root.left);
	int rNodes = getNumberOfNodes(root.right)	;
	
	return lNodes + rNodes + 1; //+1 is done to add root
		
		
		
		
	}
	
	//Full -- zero or 2 nodes
	public boolean isFullTree(Node root) {
		
		
		if(root ==null) {
			return true;
		}
		//Both left and right are null >> true
		if(root.left == null && root.right == null) return true;
		
		//If left and right not null, recursive call to check if left and right are full trees
		if(root.left != null && root.right != null)
		return isFullTree(root.left) && isFullTree(root.right);
		
		return false; // if it reaches here that means node has only one child and that is why returning false
	}

	
	public boolean isPerfectTree(Node root) {
		   return isPerfectTree(root, 0, getMaxTreeHeight(root));
	   }
	
	
 //Perfect --2 nodes. all leaf nodes at the same level. Except leaf node, all will have two children
   public boolean isPerfectTree(Node root, int level, int maxHeight) {
		
	   if(root ==null) {
			return true;
		}
	   
	   
		if(root.left == null && root.right == null) {
			return (maxHeight == level + 1);//when this is true, means they are leaf nodes and leaf nodes can have null children
		}
		
		if(root.left == null || root.right == null) {//if any child is null, false
			return false;
		}
		
		//we are traversing level by level
		return isPerfectTree(root.left, level + 1, maxHeight)  && isPerfectTree(root.right, level+ 1, maxHeight);
	   	  	  
	}
   
   
   public boolean isCompleteTree(Node root) {
	   return isCompleteTree(root, 0, getNumberOfNodes(root));
	   
   }
   
   //Complete: Heap. grows from left to right. Once level is full then next level starts.  all levels are full except last level
   public boolean isCompleteTree(Node root, int childIdx, int numOfNodes) {
		
	   if(root ==null) {
			return true;
		} 
	   
	   //this is main condition. for Complete tree, childIds will always be less than numOfNodes
	   if(childIdx >= numOfNodes)
		   return false;
	   
	   int leftChildIdx = 2*childIdx + 1;
	   int rightChildIdx = leftChildIdx + 1;
	   
	   return isCompleteTree(root.left, leftChildIdx, numOfNodes)  && isCompleteTree(root.right, rightChildIdx, numOfNodes);
 
	}
   
  
   
   
  /*
   * https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/ 
   */
   public boolean isBalanced(Node root) {
	   
	   if(root == null) {
		   return true;
	   }
	   int leftHeight = getMaxTreeHeight(root.left);
	   int rightHeight = getMaxTreeHeight(root.right);
	   
	   if(    (Math.abs(leftHeight - rightHeight)) > 1     ) {
		   return false;
	   }
	   
	   return isBalanced(root.left) && isBalanced (root.right);
	   

  	}
	
	
	/*
	 * check if binary tree is binary search tree
	 */
   
   boolean isBST(Node root) {
	   return isBST(root, Integer.MIN_VALUE, 
               Integer.MAX_VALUE);
   }
   
   
   
   /*bst.root = new Node(20); 
   bst.root.left = new Node(10); //45
   bst.root.right = new Node(30);
   bst.root.right.left = new Node(5);
   bst.root.right.right = new Node(40);*/
   
   boolean isBST(Node root, int min, int max) {
	   if(root == null) 
		   return true;	
	   
	   if(root.data < min || root.data > max) return false;
	  // if(root.data == 5);
	   return isBST( root.left, min, root.data)   //true
			   && isBST(root.right, root.data, max);//30, 20 (min), mx
   }
   
   
   
   int[] createArrayBST(Node root, int[] arr, Index index) {
	   if(root == null) 
		   return null;	
	   
	   createArrayBST(root.left, arr, index) ;
	  
	   System.out.print(" Adding  "+root.data +" at "+index);
	   arr[index.id++] = root.data; 
	   createArrayBST(root.right, arr, index) ;
	   
	   return arr;
   }
   
   class Index{
	  int id;
	  public Index(int id) {
		  this.id = id;
	  }
	   
   }
   
  void  printArray(int[] arr) {
	  for(int i = 0; i< arr.length; i++) {
		   System.out.print(" * "+arr[i]);
	  }  
  }
  
   
   boolean isBSTByInorder(Node root) {
	   
	   int[] arr = new int[getNumberOfNodes(root)];
	   createArrayBST(root, arr, new Index(0));
	   System.out.println();
	   
	   printArray(arr);
	   
	   
	   for(int i = 0; i< arr.length; i++) {
		   if(arr[i] > arr[i+1])
			   return false;
	   }
	   
	   return true;
   }
   
   
   
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		TreeBinary tree = new TreeBinary(); 
		  /*         1
         *      2       3
         *  4      5         6
         *                7
         *              9
         */  
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        
        tree.root.right.right = new Node(6);
        tree.root.right.right.left = new Node(7);
        tree.root.right.right.left.left = new Node(9);
        
        
        /*BST
         *               50
         *      45                    80
         *  40      47           70       85
         *                
         *              
         */
        TreeBinary bst = new TreeBinary();
       // bst.root = new Node(20); 
       // bst.root.left = new Node(10); //45
        //bst.root.right = new Node(30);
       /* bst.root.left.left = new Node(40);//40
        bst.root.left.right = new Node(47);*/
        //bst.root.right.left = new Node(25);
       // bst.root.right.right = new Node(40);
        
        //boolean isBST = bst.isBST(bst.root);
       // boolean isBST = bst.isBSTByInorder(bst.root);
        //System.out.println("isBST "+isBST);
        
        System.out.println("**** breadthFirstTraversal ");
         tree.breadthFirstTraversal(tree.root);
        
        
        
        
        
        
        
        /*         1
         *      2       3
         *  4      5         6
         *                7
         *              9
         */
   
   
      /*  System.out.println("Height of tree is : " +  
                                      tree.getMaxTreeHeight(tree.root));	

        System.out.println("Number of nodes tree is : " +  
        tree.getNumberOfNodes(tree.root));
        System.out.println("**** breadthFirstTraversal ");
        tree.breadthFirstTraversal(tree.root);*/
        
       // System.out.println(Integer.MIN_VALUE);
	   // System.out.println(Integer.MAX_VALUE);
	    
	}

}
