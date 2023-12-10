package sept20_BinarySearchTree;

public class MyMain {

	public static void main(String[] args) {
		BST dictionary = new BST();
		dictionary.addNode("ghost");
		dictionary.addNode("donut");
		dictionary.addNode("apple");
		dictionary.addNode("froyo");
		dictionary.addNode("lamb");
		dictionary.addNode("icee");
		dictionary.addNode("nougat");
		dictionary.addNode("eclair");
		
		dictionary.inOrder();
		
		dictionary.removeWord("donut");
		
		dictionary.inOrder();
		
		assert dictionary.root != null: "Root is not null";
		
		//dictionary.spellCheck("dout");
	}

}
