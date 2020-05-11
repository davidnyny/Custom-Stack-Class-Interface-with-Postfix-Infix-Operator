import java.util.NoSuchElementException;
//David Nygren
//IT179 003
//Homework 05

//Implementation of the Stack Interface
/** Implementation of the interface StackInterface using an array as internal data structure.
HW5
 */
public class ArrayStack<E> implements StackInterface<E> {

    // Data Fields
    E[] theData; // create an array for the stack
    int top = -1; // Index to top of stack, initially empty stack.
    private static final int INITIAL_CAPACITY = 10;
    private int size;
    /**
    * Construct an empty stack with the default
    * initial capacity.
    */
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        theData = (E[]) new Object[INITIAL_CAPACITY];
        size = INITIAL_CAPACITY;
    }

    //add E item on top of the stack. If the stack is full, reallocate
    public E push(E item){
        if (top == size -1){
            reallocate();   
        }
        theData[++top] = item;
        return item;
    }

    //take the top of the stack and return
    public E peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else return theData[top];
    }

    //take the top of the stack, remove it, and return it
    public E pop(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return theData[top--];
    }

    //return true if the stack is empty
    public boolean isEmpty(){
        return top == -1;
    }

    //return the size of the stack
    public int size(){
        return top + 1;
    }

    /**
     * Method to reallocate the array containing the stack data
     * @post The size of the data array has been doubled
     *       and all of the data has been copied to the new array
     */
    private void reallocate() {
        E[] temp = (E[]) new Object[2 * theData.length];
        System.arraycopy(theData, 0, temp, 0, theData.length);
        theData = temp;
    }

}

