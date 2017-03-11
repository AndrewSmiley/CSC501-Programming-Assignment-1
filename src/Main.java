import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);

        Integer numbers[] = null;
        int size = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input1.txt")));

            String line;
            int lineCount = 1;
            while ((line = br.readLine()) != null) {

                if (lineCount == 1) {
//                    all   = new ArrayOrderedList(Integer.parseInt(line));
                    size = Integer.parseInt(line);
                    numbers = new Integer[size];
                    lineCount++;

                } else {
                    //just a stupid thing to add all of our numbers to
//                    if(lineCount < size/2){
                    numbers[lineCount - 2] = Integer.parseInt(line);
//                    }
//                    oll.add(Integer.parseInt(line));
//                    ull.add(Integer.parseInt(line));
//                    all.add(Integer.parseInt(line));
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
        //add the elements from our
        for (Integer i : numbers) {
            oll.add(i);
            ull.add(i);
            all.add(i);
        }
        System.out.println(ull.toString());
        ull.delete(1872238);
        System.out.println(ull.toString());
        System.out.println(oll.toString());
        oll.delete(1872238);
        System.out.println(oll.toString());
//        int serachval = oll.sequentialSearch(4155);


//        System.out.println("Size of ALL: " + all.getSize());
//        System.out.println(all.toString());
//        System.out.println("Validity: "+all.validate());
//        System.out.println("Index of 69696969: "+all.binarySearch(69696969));
//        System.out.println(all.getList()[all.binarySearch(99634)]);
    }
}
