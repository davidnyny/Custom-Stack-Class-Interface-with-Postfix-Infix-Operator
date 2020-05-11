/** Stack Interface - a Stack is a data structure in which
 * objects are inserted into and removed from the same end (i.e., Last-In, First-Out).
HW5
 */
public interface StackInterface<E> {

    /**
     * Pushes an item onto the top of the stack
     * @param item The object to be inserted
     * @return The item that was pushed
     */
    E push(E item);

    /**
     * Returns the object at the top of the stack
     * without removing it.
     * @return The object at the top of the stack
     * @throws NoSuchElementException if stack is empty
     */
    E peek();

    /**
     * Returns the object at the top of the stack
     * and removes it.
     * @return The object at the top of the stack
     * @throws NoSuchElementException if stack is empty
     */
    E pop();

    /**
     * Returns true if the stack is empty; otherwise,
     * returns false.
     * @return true if the stack is empty
     */
    boolean isEmpty();
}
