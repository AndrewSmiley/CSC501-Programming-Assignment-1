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
        UnorderedLinkedList ull = new UnorderedLinkedList();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input1.txt")));

            String line;
            while ((line = br.readLine()) != null) {
                ull.add(Integer.parseInt(line));
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
//        for(int i = 0; i < 5; i++){
//            ull.add(i);
//        }

        System.out.println(ull.toString());
        System.out.println(ull.size);
        ull.delete(2);
        System.out.println(ull.toString());
        System.out.println(ull.size);
        ull.add(69);
        System.out.println(ull.toString());
        System.out.println(ull.size);
        ull.delete(0);
        System.out.println(ull.toString());
        System.out.println(ull.size);
    }
}
