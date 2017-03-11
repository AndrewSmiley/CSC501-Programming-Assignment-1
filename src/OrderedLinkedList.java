/**
 * Created by andrewsmiley on 3/10/17.
 */
public class OrderedLinkedList extends BaseLinkedList {
    @Override
    public int  add(Integer value) {
        int operations = 0; //the number of operations this will take
        this.size++;
        //handle the base case if our linked list is empty
        //this is the same as the other one
        if(this.isEmpty()){
            size++; //increment the size because we've added an element
            this.head = new Node(value);
        }else{
            Node currentNode = this.head; //get the head of the linked list
            while (currentNode.hasNext() && (currentNode.next().getValue() < value)){
                currentNode = currentNode.next();
                operations++; // increase operations because we have to traverse the node
            }
            Node newNode = new Node(value);
            if(currentNode == this.head){
                if(currentNode.getValue() > value){
                    newNode.setNext(currentNode);
                    operations++; //increase operations because we shift the ndoe
                    this.head = newNode;
                    operations++; //increase operations because we shift the ndoe
                    return operations;
                }else{
                    newNode.setNext(currentNode.next());
                    currentNode.setNext(newNode);
                    operations++; //increase operations because we shift the ndoe
                    return operations;
                }
            }
            newNode.setNext(currentNode.next());
            operations++; //increase operations because we shift the ndoe
            currentNode.setNext(newNode);
            operations++; // increase becasue we compelte the shift
        }
        return operations;
    }

    /**
     * Just a simple function to validate that the order of our nodes is correct
     * @return true if the order is valid, false otherwise
     */
    public boolean validate(){
        Integer currentValue = this.head.getValue();
        Node currentNode = this.head;
        while(currentNode.hasNext()){
            if (currentValue > currentNode.getValue()){
                return false;
            }
            currentValue = currentNode.getValue();
            currentNode = currentNode.next();

        }

        return true;
    }

//    public int binarySearch(Integer value, OrderedLinkedList list){
//        if(list.getSize() == 1){
//
//        }
//
//        return 0;
//    }

}
