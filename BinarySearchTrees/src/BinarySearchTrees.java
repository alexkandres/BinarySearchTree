import java.io.ObjectInputStream.GetField;


public class BinarySearchTrees 
{
	
	static BST m_objBST = new BST();
	
	public static void main(String[] args) 
	{
		
		BST binarySearchTree = new BST();
		
		binarySearchTree.Insert(10);
	//	binarySearchTree.Insert(11);
//		binarySearchTree.Insert(9);
//		
		binarySearchTree.Delete(10);

		System.out.println("Search found "+binarySearchTree.Search(10));
		BSTNode root = binarySearchTree.getRootNode();
		binarySearchTree.inOrder(root);
		
	}
	
}
