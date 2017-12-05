/** SortedList.java
 * an interface to be used in lab 3 and lab 5 for a Sorted list of data.
 * this interface will be implemented for cosc 2125 lab #3 and lab #5
 * The interface assumes the implementing class has a sorted list of
 *  elements that are Comparable.  The list must always
 *  remain in sorted order , all methods keep the 
 *  list sorted.
 * @author Laura Baker
 * @version 1.2
 */
//Mark Hawley

public interface SortedList {
    public final static int MAX_ELEMENTS = 20;
      //list is full after this number is reached.

/** tests to see if the list has reached MAX_ELEMENTS
 *@return true if the list contains MAX_ELEMENTS false otherwise
 */
    public boolean isFull();
 
/** tests to see if the List has 0 elements
 *@ return true if the list is empty (has 0 elements) false otherwise;
 */
    public boolean isEmpty();

/** returns number of elements currently in list
 *@return - number of elements in list (always <= MAX_ELEMENTS)
 */
  public int size();

/** searches the list for a key element
 * @param  element - the Object being searched for (Comparable must be implemented)
 * @return true if the element is present in list,
              false if it is not in the list
 */
  public boolean contains (Object element);

/** adds the element to the list if its NOT already in the list
   assuming Comparable interface for elements is implemented,
   maintains sorted order of list.
   * @param element - the item to be added to the list (Comparable)
   * @return - true if succesfully added, false if no room or duplicate.
   */
  public boolean add(Object element);

/** removes element from list if its located maintains sorted list order
 * @param - element - the object to be removed (comparable equals)
 * @return - the object that was found and removed, null if not found  and
             thus not removed.
 */
  public Object remove(Object element);


/** removes all elements in the list so that it becomes empty.
 */
  public void removeAll();


}
