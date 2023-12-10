package sept20_BinarySearchTree;

public class BST {
	//DATA MEMBERS
	//what do you need to know to get complete access to...
		//linked list: head + tail
		//BST: root
	
	public Node root;
	
	public BST() {
		root = null;
	}
	
	//ADD A NODE
		//can never insert nodes, always add as a child
	public void addNode(String newNode) {
		//begin search at root, traverse down
		Node temp = new Node(newNode);
		
		//SCENARIO 1: tree is empty
		if (root == null) {
			root = temp;
		}
		
		//SCENARIO 2: node is found --> do nothing
		//SCENARIO 3: insert node at last spot on path traversed
		else {
			insert(root, temp);
		}
		
	}
	
	private void insert(Node pointer, Node temp) {
		while (true) {
			//ignore duplicate words
			if (temp.word.compareTo(pointer.word) == 0){
				return;
			}
			
			//travel to left side
			if(temp.word.compareTo(pointer.word) <= - 1) {
				if (pointer.left != null) {
					pointer = pointer.left;
				} else {
					pointer.left = temp;
					break;
				}
			}
			
			//travel to right side
			else {
				if (pointer.right != null) {
					pointer = pointer.right;
				} else {
					pointer.right = temp;
					break;
				}
			}
		}
	}
	
	/*
	private static Node findWordRecursion (Node pointer, String word) {
		if (pointer == null) {
			return pointer;
		} else if (pointer.word == word) {
			return pointer;
		} else {
			return findWordRecursion(pointer.left, word) || findWordRecursion(pointer.right, word);
		}
	}
	*/
	/*
	public static Node findNode(Node pointer, String word) {
		while (true) {
			//travel to left side
			if(word.compareTo(pointer.word) <= - 1) {
				if (pointer.left != null) {
					pointer = pointer.left;
				} else {
					break;
				}
			}
			//travel to right side
			else if (word.compareTo(pointer.word) >= - 1) {
				if (pointer.right != null) {
					pointer = pointer.right;
				} else {
					break;
				}
			} else {
				return pointer;
			}
		}
	}
	*/
	
	public static Node findNode(Node pointer, String word) {
        // Base Cases: root is null or key is present at root
        if (pointer == null || pointer.word == word)
            return pointer;
 
        // Key is greater than root's key
        if (word.compareTo(pointer.word) >= - 1)
            return findNode(pointer.right, word);
 
        // Key is smaller than root's key
        return findNode(pointer.left, word);
    }
	
	public void removeWord(String wordToRemove) {
		//search for node containing that word
		Node toRemove = findNode(root, wordToRemove);
		
		//SCENARIO 1: node to be removed is not in the tree
		if (toRemove == null) {
			System.out.println("\nThe word you are trying to remove does not exist\n");
		} else {
			System.out.println("\nThe word you are trying to remove is: " + toRemove.word + "\n");
		}
		
		/*
		//SCENARIO 2: node has no children
		if (toRemove.right == null && toRemove.left == null) {
			//delete
		}
		
		//SCENARIO 3: node has one child
		*/
		
		//SCENARIO 4: node has two children
		if (toRemove.right != null && toRemove.left != null) {
			toRemove.word = toRemove.left.word;
			toRemove.left = null;
			
		}
	
	}
	
	public void spellCheck(String word) {
		spellCheckRecursion(root, word);
		if (!spellCheckRecursion(root, word)) {
			System.out.println("word not found");
		} else {
			System.out.println("word spelled correctly");
		}
	}
	
	private static boolean spellCheckRecursion (Node pointer, String word) {
		if (pointer == null) {
			return false;
		} else if (pointer.word == word) {
			return true;
		} else {
			return spellCheckRecursion(pointer.left, word) || spellCheckRecursion(pointer.right, word);
		}
	}
	
	//DISPLAY ALL NODES USING IN ORDER TRAVERSAL
	public void inOrder() {
		inOrderRecursive(root);
	}
	
	private void inOrderRecursive(Node pointer) {
		if (pointer != null) {
			inOrderRecursive(pointer.left);
			System.out.println(pointer.word);
			inOrderRecursive(pointer.right);
		}
	}
}
