//Mark Hawley
//Lab 7

import java.util.*;
public class StackA <T>
{
	private ArrayList<T> list_;
	
	public StackA()
	{
		list_ = new ArrayList<T>();
	}
	public int size()
	{
		return list_.size();
	}
	public String toString()
	{
		String temp = "";
		for(int i = (list_.size()-1); i >= 0; i--)
		{
			temp += list_.get(i) + "\n";
		}
		return temp;
	}
	/** places item on the top of this Stack
	 *@param element - item to be pushed
	 * @return 
	 *@return - nothing
	 */
	public void push(T element)
	{
		list_.add(element);
		return;
	}

	public T peek()
	{
		if (this.isEmpty())
		{
			throw new RuntimeException();
		}
		return list_.get(list_.size()-1);
	}
	
	public boolean isEmpty() 
	{
		return list_.isEmpty();
	}
	
	/** removes and returns the top item from this Stack if this Stack is
	 * not empty. 
	 * @throws - RuntimeException if attempt to pop an empty stack.
	 * @return - the object that was popped from the top of the stack. 
	 */
	  public T pop()
	  {
	  if (this.isEmpty())
			{
				throw new RuntimeException();
			}
	  T value = list_.get(list_.size()-1);
	  list_.remove(value);
	  return value;
	  }

	/** removes all items from this Stack, making it empty.
	 */
	  public void clear()
	  {
		  list_.clear();
		  return;
	  }
}
