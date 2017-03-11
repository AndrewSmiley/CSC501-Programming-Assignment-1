/**
 * Created by andrewsmiley on 3/10/17.
 */
public class BaseLinkedList {
    Node head;
    int size;
    //overload the constructors
    public BaseLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Override toString method to get the contents of our list
     * @return
     */
    @Override
    public String toString() {
        //base case of empty string
        if(this.isEmpty()){
            return "Empty Linked List";
        }
        StringBuilder sb = new StringBuilder();
        Node currentNode = this.head;
        while (currentNode != null){
            sb.append(currentNode.getValue()+" ");
            currentNode = currentNode.next();
        }
        return sb.toString();
    }

    public BaseLinkedList(Node head) {

        this.head = head;
    }
    /**
     * Get the size of our linked list
     * @return the number of elements in our linked list
     */
    public int getSize() {
        return size;
    }



    /**
     * Get head, well, get THE head
     * @return the head of our linked list
     */
    public Node getHead() {
        return head;
    }

    /**
     * Set the head of our linked list
     * @param head a head to use on our linked list
     */
    public void setHead(Node head) {
        this.head = head;
    }



    /**
     * Remove all elements from our linked list
     */

    public void clear() {
        this.head = null; //just set the head to null to delete our nodes
        this.size = 0; //set size to 0 since our linked list is empty
    }

    /**
     * Determine if our linked list is empty or not
     *
     * @return true if there are no elements in our linked list, false otherwise
     */

    public boolean isEmpty() {
        return this.head == null; //make it simple, ternary!
    }


    /**
     * Add a value to our linked list
     *
     * @param value the value to add to our linked list
     */
    public void add(Object value) {
        //handle the base case if our linked list is empty
        if(this.isEmpty()){
            this.head = new Node(value);
            size++; //increment the size because we've added an element
        }else{
            Node currentNode = this.head; //get the head of the linked list
            //just walk the linked list to get the last node
            while (currentNode.hasNext()){
                currentNode = currentNode.next();
            }
            currentNode.setNext(new Node(value));
            size++; //increment the size because we've added an element
        }
    }

    /**
     * Delete a node at the index specified. Zero indexed of course
     * @param index the index of the node we want to delete
     * @return  the number of operations we have done to execute the operation
     */
    public int delete(int index){
        int operations = 0; //the number of steps it takes to perform this operation
        //first, check to make sure we are not deleting something outsize the bounds of our linked list
        //otherwise, throw an exception
        if(index >= this.size || index < 0){
            throw new IndexOutOfBoundsException("The index you are trying to delete does not exist in this node");
        }
        //if we are deleting the first node
        if(index == 0){
            if(this.head.next() == null){
                this.head = null;
                operations++; //increment the number of operations because we have to check the next node
                size --;//decrement size because we have removed the node
                return  operations;
            }else {
                this.head = this.head.next();
                operations++; //increment the number of operations because we have to check the next node
                size --;//decrement size because we have removed the node
                return operations;
            }
        }

        Node currentNode = this.head;//start at the top
        for(int i = 0; i < index-1; i++, operations++){

            currentNode = currentNode.next(); // get the next element
            if (currentNode == null){
                throw  new IndexOutOfBoundsException("Trying to access an index that does not exist. Is something wrong with your linked list?");
            }
        }
        //once we have our current node, we can get hte next one and the one after that
        Node nextNode = currentNode.next();
        operations ++; //increment operations because we have to ge the next now
        currentNode.setNext(nextNode.next()); //from here, just attach the next node to the next node of our current operating node
        operations++;//increment operations because we have to now set the new node
        operations++;// increment operations because we have to grab the next of the next
        size--;
        return operations;

    }

}
