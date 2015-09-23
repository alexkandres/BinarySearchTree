
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
	
	public BSTNode Delete(BSTNode root, int key){
		
		//look for node to delete
		BSTNode nodeFound = Search(root, key);
		
		System.out.println("node found = "+nodeFound.GetKeyValue());
		System.out.println("root = "+ root.GetKeyValue());
		
		//find parent of node to delete
		BSTNode parentNode = getParent(root, nodeFound);
		
		
		
		if(parentNode == null)
			System.out.println("Parent is null");
		
		System.out.println("parent = "+parentNode.GetKeyValue());
		
		//if node to delete is leaf
		if(nodeFound.isLeaf()){
			System.out.println("It is a leaf");
			
			//if is the right child delete right
			if(parentNode.GetRightNode() == nodeFound){
				
				parentNode.SetRightNode(null);
			}
			
			//if is the left child delete left
			if(parentNode.GetLeftNode() == nodeFound){
				
				parentNode.SetLeftNode(null);
			}
		}
		
		if(nodeFound.hasOneChild()){
			
			//if it is the right child
			if(nodeFound.GetRightNode() != null){
				
				//set the parent equal to the right of nodefound
				parentNode.SetRightNode(nodeFound.GetRightNode());
				nodeFound = null;
			}
			
			//if left child
			else{
				
				parentNode.SetLeftNode(nodeFound.GetLeftNode());
				nodeFound = null;
			}
		}
		
			
		
		return null;
	}

	public BSTNode getParent(BSTNode root, BSTNode node){
		
		if(root == node || root == null){
			return null;
		}
		
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
    	System.out.println("insert "+ nKeyValue);
    	
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
