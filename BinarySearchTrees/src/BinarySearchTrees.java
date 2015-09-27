import java.io.ObjectInputStream.GetField;


public class BinarySearchTrees 
{
	
	static BST m_objBST = new BST();
	
	public static void main(String[] args)
	{
		
		BST binarySearchTree = new BST();
		
		binarySearchTree.Insert(10);
		binarySearchTree.Insert(5);
		binarySearchTree.Insert(3);
		binarySearchTree.Insert(1);
		
		System.out.println("Root in begining: "+binarySearchTree.getRootNode().GetKeyValue());
		binarySearchTree.inOrder(binarySearchTree.getRootNode());
	
		//binarySearchTree.Delete(10);
		
		try {
			
			//System.out.println("\nSearch found "+binarySearchTree.Search(5).GetKeyValue());
			
		} catch (NullPointerException e) {
			
			System.out.println("\nI caught the exception! "+e.getMessage());
			
		}
		System.out.println();
		
		binarySearchTree.inOrder(binarySearchTree.getRootNode());
		
		int searchValue = 3;
		System.out.println("\nRoot in end: "+binarySearchTree.getRootNode().GetKeyValue());
		System.out.println("subtree size of "+searchValue+": "+binarySearchTree.Search(searchValue).getSubTreeSize());
		
		
	}
	
}
