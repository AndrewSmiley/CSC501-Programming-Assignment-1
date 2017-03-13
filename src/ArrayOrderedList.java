/**
 * Created by andrewsmiley on 03/08/17.
 */
public class ArrayOrderedList {
    //this is our inner array
    private Integer list[];
    //the size (number of elements) in our inner array
    private int size;

    /**
     * Get our operations
     * @return the number of operations
     */
    public int getOperations() {
        return operations;
    }

    /**
     * Set the number of operations
     * @param operations the number of operations to set
     */
    public void setOperations(int operations) {
        this.operations = operations;
    }

    private int operations;

    /**
     * Get the array of the linked list
     *
     * @return
     */
    public Integer[] getList() {
        return list;
    }

    /**
     * Set the array of the list
     *
     * @param list the array we want to utilize
     */
    public void setList(Integer[] list) {
        this.list = list;
    }

    /**
     * Get the size of the list
     *
     * @return the size of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Set the size of the list
     *
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Single arg constuctor to preallocate the number of elements in the inner array
     *
     * @param s
     */
    public ArrayOrderedList(int s) {
        if (s <= 0) {
            s = 100;
        }
        this.size = 0;

        this.list = new Integer[s];
    }

    /**
     * Default no-arg constructor
     */
    public ArrayOrderedList() {
        this(100);

    }

    /**
     * Simple function to tell us if our array is empty or not.
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * This method allows us to add a value to our current array
     *
     * @param value the value to add
     */
    public void add(Integer value) {
        //before we do anything, clear the operations
//        this.operations = 0;
        //if we are addixng to an empty list just add the first element

        if (this.isEmpty()) {
            this.list[0] = value;
            this.operations++;//increase number of operations by 1;
            this.size++; //increase size by 1 because we've added an element

        } else {
            //we can simplify this one by doing the shift and the traversal in one step
            int i;
            for (i = size - 1; i >= 0; i--) {
                //if the value is greater than the index we are looking at, go ahead and assign it
                this.operations++;//increase operations because we are doing a value check
                if (value >= this.list[i]) {
                    this.list[i + 1] = value;//since we can assume that we've already done the shifting
                    this.operations++;//increase operations since we did the assignment
                    size++;
                    return;
                } else {
                    //otherwise, shift and move on
                    this.list[i + 1] = this.list[i];
                    operations++;//increase operations because we just did a shift
                }
            }
            //the value is smaller that the smallest item in the array, go ahead and put it first
            if (i == -1) {
                this.list[i + 1] = value;
                operations++;//increase operations
                size++;
            }

        }


    }

    /**
     * Helper function that allows us to call our recursive binary search by specifying only the
     * value we want to find
     * @param value the value to find
     * @return the index of the element we are looking for
     */
    public int find(int value) {
        return binarySearch(this.list, 0, this.list.length - 1, value);
    }

    /**
     * The actual binary search function. This is plain old binary search, no need to document this one too heavily
     * @param list the array we are searching
     * @param start the start of the array (or subarray) to search
     * @param end the end of the array (or subarray) to search
     * @param value the value we want
     * @return the index of the element we are looking for
     */
    private int binarySearch(Integer[] list, int start, int end, int value) {
        int middle = (start + end) / 2;
        this.operations++; //increase operations because we do this comparison
        if (end < start) {
            return UnorderedLinkedList.VALUE_NOT_FOUND;
        }
        //increase operations because we do 2 comparisons
        this.operations++;
        this.operations++;
        if (value == list[middle]) {
            return middle;
        } else if (value < list[middle]) {
            return binarySearch(list, start, middle - 1, value);
        } else {
            return binarySearch(list, middle + 1, end, value);
        }
    }



    /**
     * Function to write the contents of our list to the screen
     *
     * @return the string value of our arraylist contents
     */
    @Override
    public String toString() {

        //just itereate through and append them to a string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            sb.append(this.list[i] + " ");

        }
        return sb.toString();
    }

    /**
     * Just a simple function to validate that the order of our elements is correct
     *
     * @return true if the order is valid, false otherwise
     */
    public boolean validate() {
        //iterate through n-1 where n = this.size and validate that i-1< i
        Integer lastValue = this.list[0];
        for (int i = 0; i < this.size; i++) {
            if (lastValue > this.list[i]) {
                return false;
            }
            lastValue = this.list[i];
        }
        return true;
    }

    /**
     * Delete the element residing at the given index
     *
     * @param index the index to delete
     */
    public void remove(int index) {
//        decrease size
        this.size--;
        this.operations++; //increase operations because we nullify the element at the index
        this.list[index] = null;
        //next, shift all the elements
        for(int i =index+1;  i < this.size; i++){
            this.list[i-1]=this.list[i];
            this.operations++;//increase operations because we shift each item
        }
    }

    /**
     * Delete a value from our list. This one finds the element using binary search and then deletes the element at that
     * index  using the
     * @param value The value to delete
     */
    public void delete(int value){
        //first get the vlaue
        int index = this.find(value);
        //make sure it exists in the list
        if(index != UnorderedLinkedList.VALUE_NOT_FOUND){
            this.remove(index);
        }
    }

}
