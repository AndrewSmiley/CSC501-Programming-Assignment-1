import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.nio.file.Path;
//import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Integer numbers[] = null;
        int size = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input1.txt")));

            String line;
            int lineCount = 1;
            while ((line = br.readLine()) != null) {

                if (lineCount == 1) {
                    size = Integer.parseInt(line);
                    numbers = new Integer[size];
                    lineCount++;

                } else {
                    numbers[lineCount - 2] = Integer.parseInt(line);
                    lineCount++;
                }
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //create our lists and our store of arrays
        UnorderedLinkedList ull = new UnorderedLinkedList();
        OrderedLinkedList oll = new OrderedLinkedList();
        ArrayOrderedList all = new ArrayOrderedList(size);
        //add our items to the array
        System.out.println("Adding our array elements to our lists....");
        for (Integer i : numbers) {
            oll.add(i);
            ull.add(i);
            all.add(i);
        }

//        System.out.println("Found item 4155 at index: "+all.recursiveBinarySearch(4155));
//        System.out.println(all.toString());

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
//        System.out.println(all.toString());
//        all.delete(4155);
//        System.out.println(all.toString());
//        delete every 5th datum
        //round up on this one
        System.out.println("Deleting every 5th element from the original array in our lists....");
        for(int i=1; i < (int) Math.ceil(size/5); i++){
//            System.out.println("Deleting item: "+5*i);
            all.delete(numbers[i*5]);
            ull.delete(numbers[i*5]);
            oll.delete(numbers[i*5]);
        }
        System.out.println("Operations to delete every 5th item from original array in OrderedLinkedList: "+oll.getOperations());
        System.out.println("Operations to delete every 5th item from original array in UnorderedLinkedList: "+ull.getOperations());
        System.out.println("Operations to delete every 5th item from original array in OrderedArrayList: "+all.getOperations()+"\n\n");

        System.out.println("Validating our ordered lists....");
        System.out.println("Validating OrderedLinkedList: "+oll.validate());
        System.out.println("Validating OrderedArrayList: "+all.validate()+"\n\n");
        System.out.println("Clearing our operations\n\n");
        all.setOperations(0);
        ull.setOperations(0);
        oll.setOperations(0);
        System.out.println("Searching for every element in the first half of our original array in our lists....");
        for(int i = 0; i < (int) Math.ceil(size/2); i++){
            all.recursiveBinarySearch(numbers[i]);
            oll.sequentialSearch(numbers[i]);
            ull.sequentialSearch(numbers[i]);
        }
        System.out.println("Operations to find every element in the first half of our original array in OrderedLinkedList: "+oll.getOperations());
        System.out.println("Operations to find every element in the first half of our original array in UnorderedLinkedList: "+ull.getOperations());
        System.out.println("Operations to find every element in the first half of our original array in OrderedArrayList: "+all.getOperations()+"\n\n");

        System.out.println("Final validation of our ordered lists....");
        System.out.println("Validating OrderedLinkedList: "+oll.validate());
        System.out.println("Validating OrderedArrayList: "+all.validate()+"\n\n");
    }
}
