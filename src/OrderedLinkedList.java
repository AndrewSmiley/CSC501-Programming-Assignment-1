/**
 * Created by andrewsmiley on 03/08/17.
 */
public class OrderedLinkedList extends UnorderedLinkedList {
        @Override
        public void  add(Integer value) {
            this.size++;
            //handle the base case if our linked list is empty
            //this is the same as the other one
            if(this.isEmpty()){
                size++; //increment the size because we've added an element
                this.head = new Node(value);
            }else{
                Node currentNode = this.head; //get the head of the linked list
                //iterate over the nodes till we find a spot that it matches
                while (currentNode.hasNext() && (currentNode.next().getValue() < value)){
                    currentNode = currentNode.next();
                    this.operations++; // increase operations because we have to traverse the node
                }
                Node newNode = new Node(value);
                if(currentNode == this.head){
                    if(currentNode.getValue() > value){
                        newNode.setNext(currentNode);
                        this.operations++; //increase operations because we shift the ndoe
                        this.head = newNode;
                        this.operations++; //increase operations because we shift the ndoe
                        return ;//operations;
                    }else{
                        newNode.setNext(currentNode.next());
                        currentNode.setNext(newNode);
                        this.operations++; //increase operations because we shift the ndoe
                        return ;//operations;
                    }
                }
                newNode.setNext(currentNode.next());
                this.operations++; //increase operations because we shift the ndoe
                currentNode.setNext(newNode);
                this.operations++; // increase becasue we compelte the shift
            }
            return;// operations;
        }

    /**
     * Just a simple function to validate that the order of our nodes is correct
     *
     * @return true if the order is valid, false otherwise
     */
    public boolean validate() {
        Integer currentValue = this.head.getValue();
        Node currentNode = this.head;
        while (currentNode.hasNext()) {
            if (currentValue > currentNode.getValue()) {
                return false;
            }
            currentValue = currentNode.getValue();
            currentNode = currentNode.next();

        }

        return true;
    }

    /**
     * This is esntially the same find method in the unordered linked list class, except we stop if we
     * reach a value that is larger than the value we are searching for
     * @param value the value to search for/
     * @return
     */
    @Override
    public int find(int value){
        Node currentNode = this.head; //start at the head
        operations++;//increase operations for this assignment
        int index = 0; //this is our current working index like if we were iterating over an array
        //traverse the nodes. Go to the end of the node or stop when we get to a node with a value greater than the value we are searching for
        while(currentNode != null && currentNode.getValue() < value){
            operations++;//increase operations for the comparison
            if(currentNode.getValue() == value){ //if the node we are on contains the value we want, then we return the index
                return index; //return the index of the found value
            }else{
                //move to the next node in the series
                currentNode = currentNode.next(); //some extra comments
                index++; //increase the index
                operations++;//increase operations for moving to the next
            }
        }
        return VALUE_NOT_FOUND; //if not found, return the error code
    }

    /**
     * Delete the value specified from the array
     * @param value the value we want to delete
     */
    public void delete(Integer value){
        Node currentNode = this.head; //start at the head
        operations++;//increase operations for this assignment
        //traverse the nodes with sequential serach until we reach the end or the node value is > than the value we are searching for
        while(currentNode != null && currentNode.getValue() < value){
            operations++;//increase operations for the comparison
            if(currentNode.getValue() == value){ //if the node we are on contains the value we want, then we return the index
                //once we have our current node, we can get hte next one and the one after that
                Node nextNode = currentNode.next();
                this.operations ++; //increment operations because we have to ge the next now
                currentNode.setNext(nextNode.next()); //from here, just attach the next node to the next node of our current operating node
                operations = operations+1;//increment operations because we have to now set the new node
                break;

            }else{
                //move to the next node in the series
                currentNode = currentNode.next();
                operations++;//increase operations for moving to the next
                operations = operations+1;// increment operations because we have to grab the next of the next
                this.size--;
            }
        }

    }


}
