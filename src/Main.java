/**
 * Created by andrewsmiley on 03/08/17.
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        //this is our array of elements from the text file
        Integer numbers[] = null;
        //the number of items in the text file
        int size = 0;

        //attempt to open the file
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input2.txt")));
            //reference for our line
            String line;

            //the line count
            int lineCount = 1;
            while ((line = br.readLine()) != null) {

                if (lineCount == 1) {
                    size = Integer.parseInt(line);
                    numbers = new Integer[size];
                    lineCount++;

                } else {
                    //just add to numbers the line count. This is lineCount-2 because line 1 is the number of lines in the
                    //file
                    numbers[lineCount - 2] = Integer.parseInt(line);
                    lineCount++;
                }
            }

            //close the file
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //create our lists and our store of arrays
        UnorderedLinkedList ull = new UnorderedLinkedList();
        OrderedLinkedList oll = new OrderedLinkedList();
        ArrayOrderedList all = new ArrayOrderedList(size);
        //add our items to the array
        /**
         * Start working the steps
         * 1. insert datum into all three lists
         */
        System.out.println("Adding our array elements to our lists....");
        for (Integer i : numbers) {
            oll.add(i);
            ull.add(i);
            all.add(i);
        }
        //just some feedback for the user
        System.out.println("Operations to insert "+size+" elements into OrderedLinkedList: "+oll.getOperations());
        System.out.println("Operations to insert "+size+" elements into UnorderedLinkedList: "+ull.getOperations());
        System.out.println("Operations to insert "+size+" elements into OrderedArrayList: "+all.getOperations()+"\n\n");
        System.out.println("Validating our ordered lists....");
        System.out.println("Validating OrderedLinkedList: "+oll.validate());
        System.out.println("Validating OrderedArrayList: "+all.validate()+"\n\n");
        System.out.println("Clearing our operations\n\n");
        all.setOperations(0);
        ull.setOperations(0);
        oll.setOperations(0);
        //2. delete every 5th datum from the array from all three lists (delete items 0, 5,10, 15, etc)
        //round up on this one
        System.out.println("Deleting every 5th element from the original array in our lists....");
        //basically iterate over the length of the list /5 rounded up.
        for(int i=1; i < (int) Math.ceil(size/5); i++){
            all.delete(numbers[i*5]);
            ull.delete(numbers[i*5]);
            oll.delete(numbers[i*5]);
        }

        //more user feedback
        System.out.println("Operations to delete every 5th item from original array in OrderedLinkedList: "+oll.getOperations());
        System.out.println("Operations to delete every 5th item from original array in UnorderedLinkedList: "+ull.getOperations());
        System.out.println("Operations to delete every 5th item from original array in OrderedArrayList: "+all.getOperations()+"\n\n");
        //validate that our order is maintained
        System.out.println("Validating our ordered lists....");
        System.out.println("Validating OrderedLinkedList: "+oll.validate());
        System.out.println("Validating OrderedArrayList: "+all.validate()+"\n\n");
        System.out.println("Clearing our operations\n\n");
        all.setOperations(0);
        ull.setOperations(0);
        oll.setOperations(0);

        //last step
        //3. search for every item from the first half of the array in all three lists (note: 1/5th of these
        //items will have been deleted in step 2)
        System.out.println("Searching for every element in the first half of our original array in our lists....");
        for(int i = 0; i < (int) Math.ceil(size/2); i++){
            all.find(numbers[i]);
            oll.find(numbers[i]);
            ull.find(numbers[i]);
        }
        //final user output
        System.out.println("Operations to find every element in the first half of our original array in OrderedLinkedList: "+oll.getOperations());
        System.out.println("Operations to find every element in the first half of our original array in UnorderedLinkedList: "+ull.getOperations());
        System.out.println("Operations to find every element in the first half of our original array in OrderedArrayList: "+all.getOperations()+"\n\n");
        //just do a final validation check
        System.out.println("Final validation of our ordered lists....");
        System.out.println("Validating OrderedLinkedList: "+oll.validate());
        System.out.println("Validating OrderedArrayList: "+all.validate()+"\n\n");
    }
}
