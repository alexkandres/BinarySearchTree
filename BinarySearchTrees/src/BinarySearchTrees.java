
public class BinarySearchTrees 
{
	
	static BST m_objBST = new BST();
	
	public static void main(String[] args) 
	{
		
		BST binarySearchTree = new BST();
		
		binarySearchTree.Insert(10);
		binarySearchTree.Insert(41);
		binarySearchTree.Insert(39);

		binarySearchTree.Delete(41);
		
		binarySearchTree.Insert(50);
		binarySearchTree.Delete(10);
		binarySearchTree.Delete(39);
		binarySearchTree.Delete(50);
		
		System.out.println("New root = "+binarySearchTree.getRootNode().GetKeyValue());
		
		//still the rreight root
//		System.out.println(binarySearchTree.getRootNode().GetKeyValue());
		
		//System.out.println(binarySearchTree.Search(11).GetKeyValue());
		//System.out.println(binarySearchTree.Search(39).GetRightNode().GetKeyValue());
	}
	
}
