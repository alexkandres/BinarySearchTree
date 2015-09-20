
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
		
		//get value node to be deleted
		BSTNode deleteNode = Search(nValue);
		
		if(deleteNode != null)
			Delete(deleteNode);
		
	}
	
	public void Delete(BSTNode bstNode){
		
		//if no child
		if(bstNode.GetRightNode() == null && bstNode.GetLeftNode() == null)
			deleteNoChildNode(bstNode);
		
		//if one child
		else if(bstNode.GetRightNode() == null ^ bstNode.GetLeftNode() == null)
			deleteOneChildNode(bstNode);
				
		//if two child
		else if(bstNode.GetRightNode() != null && bstNode.GetLeftNode() != null)
			deleteTwoChildNode(bstNode);
	}

	private void deleteNoChildNode(BSTNode bstNode) {
		
		BSTNode tempNode = bstNode.getParent();

		System.out.println("Reached here");
		//this node is less than parent then swap left
		if(bstNode.GetKeyValue() < bstNode.getParent().GetKeyValue()){
			
			//bstNode = bstNode.GetLeftNode();
		}
		
		//swap this node with right if it is greater
		else if(bstNode.GetKeyValue() > bstNode.getParent().GetKeyValue()){
			
		}
			bstNode = bstNode.GetRightNode();
		
		//set it to the right parent
		bstNode.setParent(tempNode);
	}

	private BSTNode getRootNode(){
		return m_objRootNode;
	}
	
	private void deleteOneChildNode(BSTNode bstNode) {
		// TODO Auto-generated method stub
		
	}
	
	private void deleteTwoChildNode(BSTNode bstNode) {
		// TODO Auto-generated method stub
		
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
    private BSTNode Search( BSTNode objNode, int nKeyValue )
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