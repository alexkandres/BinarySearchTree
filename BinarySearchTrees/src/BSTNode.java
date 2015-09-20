
public class BSTNode 
{
	private BSTNode parentNode;
	private BSTNode m_objLeftNode, m_objRightNode;
	private int m_nKeyValue;
	
	public BSTNode()
	{
		// Explicit set to null may not be necessary,
		//   but provided for clarity.
		parentNode = m_objLeftNode = m_objRightNode = null;
		
		// Set this node's key value to default of 0.
		m_nKeyValue = 0;
	}

	public BSTNode(int nKeyValue)
	{
		// Explicit set to null may not be necessary,
		//   but provided for clarity.
		m_objLeftNode = m_objRightNode = null;
		
		// Set this node's key value
		m_nKeyValue = nKeyValue;
	}

	// Accessor method to set the root node.
	public void setParent( BSTNode objParentNode)
	{
		// Assign the left node object reference.
		objParentNode.parentNode = objParentNode;
	}
	
	// Accessor method to get the right node.
	public BSTNode getParent()
	{
		// return root
		return parentNode;
	}
	
	// Accessor method to set the left node.
	public void SetLeftNode( BSTNode objLeftNode)
	{
		// Assign the left node object reference.
		
		m_objLeftNode = objLeftNode;
		objLeftNode.parentNode = this;
	}
	
	// Accessor method to set the right node.
	public void SetRightNode( BSTNode objRightNode)
	{
		// Assign the right node object reference.
		
		m_objRightNode = objRightNode;
		objRightNode.parentNode = this;
	}
	
	// Accessor method to get the left node object.
	public BSTNode GetLeftNode()
	{
		// Return the object.
		return( m_objLeftNode );
	}
	
	// Accessor method to get the right node object.
	public BSTNode GetRightNode()
	{
		// Return the object.
		return( m_objRightNode );
	}

	// Accessor method to set the node's key value.
	public void SetKeyValue( int nKeyValue )
	{
		// Set the value.
		m_nKeyValue = nKeyValue;
	}
	
	// Accessor method to get the node's key value.
	public int GetKeyValue()
	{
		// Return the value.
		return( m_nKeyValue );
	}

}
