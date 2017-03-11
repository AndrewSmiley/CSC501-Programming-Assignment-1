import java.util.Arrays;

/**
 * Created by andrewsmiley on 3/10/17.
 */
public class ArrayOrderedList {
    private Integer list[];
    private int size;
    private int operations;

    /**
     * Get the array of the linked list
     * @return
     */
    public Integer[] getList() {
        return list;
    }

    /**
     * Set the array of the list
     * @param list the array we want to utilize
     */
    public void setList(Integer[] list) {
        this.list = list;
    }

    /**
     * Get the size of the list
     * @return the size of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Set the size of the list
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Single arg constuctor to preallocate the number of elements in the inner array
     * @param s
     */
    public ArrayOrderedList(int s) {
        if(s<=0) {
            s=100;
        }
        this.size=0;
//        this.
        this.list= new Integer[s];
    }

    /**
     * Default no-arg constructor
     */
    public ArrayOrderedList() {
        this(100);

    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * This method allows us to add a value to our current array
     * @param value the value to add
     */
    public void add(Integer value){
        //before we do anything, clear the operations
        this.operations = 0;
        //if we are addixng to an empty list just add the first element

        if(this.isEmpty()){
            this.list[0]  = value;
            this.operations++;//increase number of operations by 1;
            this.size++; //increase size by 1 because we've added an element
//            return this.operations;
        }else{
            //we can simplify this one by doing the shift and the traversal in one step
            int i;
            for( i = size-1; i >= 0; i--){
                //if the value is greater than the index we are looking at, go ahead and assign it
                if (value>= this.list[i]){
                    this.list[i+1]=value;//since we can assume that we've already done the shifting
                    this.operations++;//increase operations since we did the assignment
                    size++;
                    return;
                }else{
                    //otherwise, shift and move on
                    this.list[i+1] = this.list[i];
                    operations++;//increase operations because we just did a shift
                }
            }
            //the value is smaller that the smallest item in the array, go ahead and put it first
            if(i==-1){
                this.list[i+1]=value;
                operations++;//increase operations
                size++;
            }

        }


    }

    /**
     * Binary search functon that calls the built-in binarySearch function from Java's Array class.
     * @param value the value we wish to search from
     * @return the zero-indexed index of the value we want
     */
    public int binarySearch(Integer value){
        return Arrays.binarySearch(this.list,value);
    }

    /**
     * Function to write the contents of our list to the screen
     * @return
     */
    @Override
    public String toString() {

        //just itereate through and append them to a string
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.size; i++){
            sb.append(this.list[i]+" ");

        }
        return sb.toString();
    }
    /**
     * Just a simple function to validate that the order of our elements is correct
     * @return true if the order is valid, false otherwise
     */
    public boolean validate(){
        //iterate through n-1 where n = this.size and validate that i-1< i
        Integer lastValue = this.list[0];
        for(int i = 0; i < this.size; i++){
            if(lastValue > this.list[i]){
                return false;
            }
            lastValue = this.list[i];
        }
        return true;
    }

    /**
     * Delete the element residing at the given index
     * @param index
     */
    public void deleteIndex(int index){

    }

}
