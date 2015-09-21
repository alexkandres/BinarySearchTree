
public class BinarySearchTrees 
{
	
	static BST m_objBST = new BST();
	
	public static void main(String[] args) 
	{
		
		BST binarySearchTree = new BST();
		
		binarySearchTree.Insert(9);
		binarySearchTree.Insert(11);
		binarySearchTree.Insert(13);
		binarySearchTree.Insert(14);
		
		System.out.println(binarySearchTree.getRootNode().GetKeyValue());
		
		//System.out.println(binarySearchTree.Search(13).GetKeyValue());

		binarySearchTree.Delete(13);
		
		//System.out.println(binarySearchTree.Search(13).GetKeyValue());
	}
	
}
