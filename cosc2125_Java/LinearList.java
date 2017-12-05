/** LinearList.java
 * an interface to be used in lab5 for a linear list of data.
 * this interface will be implemented for cosc 2125 lab #5
 * A linear list is not sorted and there is no particular
 * ordering to the elements in the list.
 * @author Laura Baker
 * @version 1.1
 */

public interface LinearList {
  public final static int MAX_ELEMENTS = 30000;  //list is full after this number is reached.

/** tests to see if the LinearList has reached MAX_ELEMENTS
 *@return true if the list contains MAX_ELEMENTS false otherwise
 */
  public boolean isFull(); 
 
/** tests to see if the LinearList has 0 elements
 *@ return true if the LinearList is empty (has 0 elements) false otherwise;
 */
  public boolean isEmpty();

/** returns number of elements currently in list
 *@return - number of elements in list (always <= MAX_ELEMENTS)
 */
  public int size();


/** searches the list for a key element
 * @param  element - the Object being searched for (equals must be implemented)
 * @return true if the element  is present, false if it is not in the list
 */
  public boolean contains (Object element);


/** adds item to list
 * not allow duplicate primary key (implements equals method) items in list
 *@param element - item to be added
 *@return - true if item is added, false if not added (either full list or duplicate)
 */
  public boolean add(Object element);

/** removes item from list if its located
 * @param - element - the object to be removed (equals is implemented)
 * @return - the element that was removed , null if not found 
              and thus not removed.
 */
  public Object remove(Object element);

/** removes all elements in the LinearList so that it becomes empty.
 */
  public void removeAll();


}
