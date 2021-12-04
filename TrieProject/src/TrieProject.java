import java.util.List;
import java.util.Scanner;

public class TrieProject {

    public static void main(String[] args) {

        TrieProject trieProject = new TrieProject();
        trieProject.start();

    }

    public void start() {
        FileIO io = new FileIO();
        List<String> wordList = io.processText();
        Trie trie = new Trie();
        for (String s : wordList) {
            trie.insert(s);
        }
        System.out.println();
        printInstructions();
        boolean stopProgram = false;
        Scanner scanner = new Scanner(System.in);
        while (!stopProgram) {

            String[] input = scanner.nextLine().toLowerCase().split(" ");

            switch (input[0]) {
                case "insert":
                    trie.insert(input[1]);
                    System.out.println(input[1] + " inserted.");
                    break;
                case "search":
                    if (trie.search(input[1])) {
                        System.out.println(input[1] + " found!");
                    } else {
                        System.out.println(input[1] + " NOT found.");
                    }
                    break;
                case "delete":
                    trie.delete(input[1]);
                    break;
                case "?":
                    printInstructions();
                    break;
                case "exit":
                    stopProgram = true;
                    break;
                default:
                    System.out.println("Input not recognized. Please try again.");
                    break;
            }
        }
    }

    public void printInstructions() {
        System.out.println("Please use one of the following commands: ");
        System.out.println("Insert abc  ----  where abc is the word you would like to insert.");
        System.out.println("Search abc  ----  where abc is the word you would like to search for.");
        System.out.println("Delete abc  ----  where abc is the word you would like to delete.");
        System.out.println("?           ----  to print out the list of commands.");
        System.out.println("Exit        ----  to exit the program.");

    }
}
