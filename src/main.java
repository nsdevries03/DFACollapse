import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        final String filepath = "input.txt";
        ArrayList<ArrayList<String>> initStates = getinitStates(filepath);
    }

    public static ArrayList<ArrayList<String>> getinitStates(String filepath) throws FileNotFoundException {
        ArrayList<ArrayList<String>> initStates = new ArrayList<>();
        File file = new File(filepath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            ArrayList<String> initStatesLine = new ArrayList<>();
            String line = scanner.nextLine();
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNext()) {
                initStatesLine.addLast(lineScan.next());
            }
            initStates.addLast(initStatesLine);
        }
        return initStates;
    }
}
