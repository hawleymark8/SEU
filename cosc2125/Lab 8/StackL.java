
public class StackL <T>
{
	private Node<T> first_;
	private int count_;
	
	public StackL()
	{
		this.first_=null;
		this.count_=0;
	}
	
	/** tests to see if the Stack has 0 elements
	 *@ return true if the Stack is empty (has 0 elements) false otherwise;
	 */
	  public boolean isEmpty()
	  {
		  if(this.count_ == 0)
		  {
			  return true;
		  }
		  return false;
	  }

	/** returns number of elements currently on this Stack
	 * @return - number of elements on this Stack
	 */
	  public int size()
	  {
		  return this.count_;
	  }

	/** creates a readable String containing the contents of this Stack 
	from top to bottom does NOT modify the stack
	 *@return - readable String of stack contents from top to bottom
	 *  
	 */
	  public String toString()
	  {
		  String temp = "";
		for(Node<T>p = this.first_; p != null; p = p.link_)
		    {
			temp += p.data_ + "\n";
		    }
		return temp;
	  }

	/** places item on the top of this Stack
	 *@param element - item to be pushed
	 *@return - nothing
	 */
	  public void push(T element)
	  {
		  Node<T> p = new Node<T>(element,first_);
		  first_=p;
		  count_++;
	  }

	/** removes and returns the top item from this Stack if this Stack is
	 * not empty. 
	 * @throws - RuntimeException if attempt to pop an empty stack.
	 * @return - the object that was popped from the top of the stack. 
	 */
	  public T pop()
	  {
		  if(this.isEmpty())
		  {
			  throw new RuntimeException(); //empty list?
		  }
		  T value = this.first_.data_;
		  this.first_=this.first_.link_;
		  this.count_--;
		  return value;
	  }

	/** returns the top item from this Stack if this Stack is
	 * not empty.  DOES NOT POP IT.
	 * @throws - RuntimeException if attempt to peek at an empty stack.
	 * @return - object that is currently on the top of the stack
	 */
	  public T peek()
	  {
		  if(this.isEmpty())
		  {
			  throw new RuntimeException(); //empty list?
		  }
		  T value = this.first_.data_;
		  return value;
	  }

	/** removes all items from this Stack, making it empty.
	 */
	  public void clear()
	  {
		  this.first_=null;
		  this.count_ = 0;
	  }
}
