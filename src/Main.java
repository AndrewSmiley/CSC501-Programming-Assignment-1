import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.nio.file.Path;
//import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
//        Path currentRelativePath = Paths.get("");
//        String s = currentRelativePath.toAbsolutePath().toString();
//        System.out.println("Current relative path is: " + s);

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

        for (Integer i : numbers) {
            oll.add(i);
            ull.add(i);
            all.add(i);
        }

        System.out.println("Operations to insert "+size+" elements into OrderedLinkedList: "+oll.getOperations());
        System.out.println("Operations to insert "+size+" elements into UnorderedLinkedList: "+ull.getOperations());
        System.out.println("Operations to insert "+size+" elements into OrderedArrayList: "+all.getOperations()+"\n\n");
        System.out.println("Validating our ordered lists....");
        System.out.println("Validating OrderedLinkedList: "+oll.validate());
        System.out.println("Validating OrderedArrayList: "+all.validate()+"\n\n");
        System.out.println("Clearing our operations");
        all.setOperations(0);
        ull.setOperations(0);
        oll.setOperations(0);



    }
}
