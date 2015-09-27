
public class BST 
{
	// This is the root node, which starts off as null
	//   when the BST is empty.
	private BSTNode m_objRootNode;
	
	// Class constructor.
	public BST()
	{
		// Not really necessary, provided for clarity.
		m_objRootNode = null;
	}
	
	public void Delete(int nValue){
		
			Delete(m_objRootNode, nValue);
		
	}
	
	@SuppressWarnings("unused")
	public void Delete(BSTNode root, int key){
		
	
		//look for node to delete
		BSTNode nodeToDelete = Search(root, key);
		
		System.out.println("nodeToDelete found = "+nodeToDelete.GetKeyValue());
		System.out.println("root = "+ root.GetKeyValue());
		
		//find parent of node to delete
		BSTNode parentNode = getParent(root, nodeToDelete);
		
		if(parentNode == null)
			System.out.println("Parent is null");
		
		//if node to delete is leaf
		if(nodeToDelete.isLeaf()){
			System.out.println("It is a leaf");
			
			//if parent is null then it is the only one in bst
			//Delete it
			if(nodeToDelete == m_objRootNode){
				m_objRootNode = null;
				return;
			}
			
			//if is the right child delete right
			else if(parentNode.GetRightNode() == nodeToDelete){
				parentNode.SetRightNode(null);
				return;
			}
		
			
			//if is the left child delete left
			else if(parentNode.GetLeftNode() == nodeToDelete){
				parentNode.SetLeftNode(null);
				return;
			}
			
		}
		
		//right child only
		else if(nodeToDelete.hasRightChildOnly()){
			
			if(parentNode == null){
				
				m_objRootNode = nodeToDelete.GetRightNode();
				nodeToDelete = null;
				return;
			}
			
			//if it is the right child
			if(parentNode.GetRightNode() == nodeToDelete){
				
				//set the parent equal to the right of nodefound
				parentNode.SetRightNode(nodeToDelete.GetRightNode());
				nodeToDelete = null;
			}
			
			//if left child
			else{
				
				parentNode.SetLeftNode(nodeToDelete.GetRightNode());
				nodeToDelete = null;
			}
		}
		
		//left child only
		else if(nodeToDelete.hasLeftChildOnly()){
			
			if(parentNode == null){
				
				m_objRootNode = nodeToDelete.GetLeftNode();
				nodeToDelete = null;
				return;
			}
			
			if(parentNode.GetRightNode() == nodeToDelete){
				
				parentNode.SetRightNode(nodeToDelete.GetLeftNode());
				nodeToDelete = null;
			}
			
			else{
				
				parentNode.SetLeftNode(nodeToDelete.GetLeftNode());
				nodeToDelete = null;
			}
		}
		
		//nodetodelete has two child
		else if(nodeToDelete.hasBothChild()){
			
			//get min on the right
			BSTNode minNodeOnRight = getMinNode(nodeToDelete.GetRightNode());
			
			System.out.println("min node "+minNodeOnRight.GetKeyValue());
			int tempkey = minNodeOnRight.GetKeyValue();
			
			Delete(tempkey);
			nodeToDelete.SetKeyValue(tempkey);
			
			if(parentNode == null)
				m_objRootNode = nodeToDelete;
						
		}
			
		
		return;
	}
	public BSTNode getMinNode(BSTNode root){
		
		//if left child is null then this node is the minimum
		if(root.GetLeftNode() == null)
			return root;
		
		//recursively get min node
		return getMinNode(root.GetLeftNode());
	}
	
	public BSTNode getMax(BSTNode nodeToGetMax){
		return nodeToGetMax;
		
	}

	public BSTNode getParent(BSTNode root, BSTNode node){
		
		if(root == node || root == null)
			return null;
		
		
		System.out.println("Reached getParent Method");
		
		//parent of mode
		if(root.GetLeftNode() == node || root.GetRightNode() == node){
			return root;
		}
		
		if(node.GetKeyValue() < root.GetKeyValue())
			return getParent(root.GetLeftNode(), node);
		
		else if (node.GetKeyValue() > root.GetKeyValue())
			return getParent(root.GetRightNode(), node);
		
		return null;
		
	}

	public BSTNode inOrder(BSTNode node){
		
		if(node == null){
			return null;
		}
		
		inOrder(node.GetLeftNode());
		System.out.print(node.GetKeyValue()+" ");
		inOrder(node.GetRightNode());
		
		return null;
	}
	public BSTNode getRootNode(){
		return m_objRootNode;
	}

	// Method to see if the tree is empty.
	public boolean IsEmpty()
	{
		// Return a boolean indicating whether the
		//   three is empty or not.
		return( m_objRootNode == null );
	}

	/* Functions to search for an element */
    public BSTNode Search( int nKeyValue )
    {
        return( Search( m_objRootNode, nKeyValue ) );
    }
    
    // Method to search for an element recursively.
    public BSTNode Search( BSTNode objNode, int nKeyValue )
    {
    	
    	if( objNode == null )
    	{
    		return( null );
    	}
    	
    	// First, we get the key value for this node.
    	int nThisKeyValue = objNode.GetKeyValue();
            
    	// See if the passed in key value is less. If so,
    	//   this indicates that we need to go left.
    	if( nKeyValue < nThisKeyValue )
    	{
    		// Get the left node object reference so we
    		//   can walk down it.
    		objNode = objNode.GetLeftNode();
    	}
            
    	// See if the passed in key value is greater. If so,
    	//   this indicates that we need to go right.
    	else if( nKeyValue > nThisKeyValue )
    	{
    		// Get the right node object reference so we
    		//   can walk down it.
    		objNode = objNode.GetRightNode();
    	}

    	// Here we have found the node with the key
    	//   value that was passed in.
    	else
    	{
    		return( objNode );
    	}
            
    	// Now call Search recursively.
    	return( Search( objNode, nKeyValue ) );
	}
    
    // This method inserts a node based on the key value.
    public void Insert( int nKeyValue ) 
    {
    	// The root node is returned to m_objRootNode from Insert()
    	m_objRootNode = Insert( nKeyValue, m_objRootNode );
    }    

    // Class protected (internal) method to insert nodes. This method
    //   will be called recursively.
    protected BSTNode Insert( int nKeyValue, BSTNode objNode ) 
    {	
    	// This node is null and simply needs to be allocated.
        if( objNode == null )
        {
        	objNode = new BSTNode( nKeyValue );
        }

        // Here we need to walk left.
        else if( nKeyValue < objNode.GetKeyValue() )
        {
        	// Set the left node of this object by recursively walking left.
        	objNode.SetLeftNode( Insert( nKeyValue, objNode.GetLeftNode() ) );
        }
        
        // Here we need to talk right.
        else if( nKeyValue > objNode.GetKeyValue() )
        {
        	// Set the right node of this object by recursively walking right.
        	objNode.SetRightNode( Insert( nKeyValue, objNode.GetRightNode() ) );
        }
        
        return( objNode );
    }
    
}
