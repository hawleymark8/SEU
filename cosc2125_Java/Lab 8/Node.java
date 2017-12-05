/** Node.java
 *implements Node class generically
 * used for Linked List classes
 * @version 1.1
 */

public class Node <T> {
  public T data_;       // the data_ portion of a Node
  public Node<T> link_; // the link portion of a Node

/** creates an empty Node with both data_ and link null
 */
  public Node () {
    this.data_=null;
    this.link_ = null;
  }
/** creates a Node with given data_ value, link is null
 *@param theData_ - the data_ value to use
 */
  public Node  (T theData_) {
    this.data_ = theData_;
    this.link_ = null;
  }
/** creates a Node with given link value, data_ is null
 *@param theLink - the link value to use
 */
  public Node  (Node<T> theLink) {
    this.data_ = null;
    this.link_ = theLink;
  }


/** creates a Node with given data_ and link
 *@param  - theData - the data_ value to place into Node's data_
 *@param  - theLink - the value to link the Node to (next link)
*/
  public Node  (T theData, Node<T> theLink) {
    this.data_ = theData;
    this.link_ = theLink;
 }
}//end of Node<T> class

