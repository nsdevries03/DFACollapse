import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        final String filepath = "input.txt";

        // Initial file
        System.out.println("Initial file:");
        ArrayList<ArrayList<String>> initStates = getinitStates(filepath);
        for (ArrayList<String> state : initStates) {
            System.out.println(state);
        }
        System.out.println();

        // Step 1
        System.out.println("Step 1:");
        ArrayList<ArrayList<String>> pairs = getPairs(initStates);
        for (ArrayList<String> state : pairs) {
            System.out.println(state);
        }
        System.out.println();

        // Step 2
        System.out.println("Step 2:");
        pairs = removeMismatch(pairs);
        for (ArrayList<String> state : pairs) {
            System.out.println(state);
        }
        System.out.println();

        // Step 3
        System.out.println("Step 3:");
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
                String token = lineScan.next();
                if (token.equals("0S")) {
                    initStatesLine.add("0");
                } else {
                    initStatesLine.add(token);
                }
            }
            initStates.add(initStatesLine);
        }
        return initStates;
    }

    public static ArrayList<ArrayList<String>> getPairs(ArrayList<ArrayList<String>> initStates) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 0; i < initStates.size() - 1; i++) {
            ArrayList<String> line = new ArrayList<>();
            for (int j = 0; j < initStates.size() - 1; j++) {
                if (j >= i) {
                    line.add("X");
                } else {
                    line.add(initStates.get(j + 1).get(0) + " " + initStates.get(i + 1).get(0));
                }
            }
            result.add(line);
        }
        return result;
    }

    public static ArrayList<ArrayList<String>> removeMismatch(ArrayList<ArrayList<String>> pairs) {
        for (int i = 0; i < pairs.size(); i++) {
            for (int j = 0; j < pairs.size(); j++) {
                if (pairs.get(i).get(j).length() == 4) {
                    pairs.get(i).set(j, "X");
                }
            }
        }
        return pairs;
    }

    public static ArrayList<ArrayList<String>> getStates(ArrayList<ArrayList<String>> pairs, ArrayList<ArrayList<String>> initStates) {
        for (int i = 0; i < pairs.size(); i++) {
            for (int j = 0; j < pairs.size(); j++) {
                Scanner s = new Scanner(pairs.get(i).get(j));
                String token = s.next();
                String a = "";
            }
        }
        return pairs;
    }
}