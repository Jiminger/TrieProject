import java.util.List;
import java.util.Scanner;

/**
 * @author : James Ritchie
 * Date : December 04, 2021
 * Dourse : COSC-310: Data Structures and Algorithms (Fall 2021)
 * Description:
 * This project is to demonstrate the implementation of the trie data structure in java.
 * The program reads from a text input file and creates a trie tree based on the text.
 * In the case of this program the text of "'Twas the Night Before Christmas" was used.
 * After the text is process the main program runs and offers the user a selection of options to manipulate the
 * trie tree further, such as: insert, search, or delete words in the trie.
 */

public class TrieProject {


    /**
     * Main method of the program
     *
     * @param args -
     */
    public static void main(String[] args) {
        TrieProject trieProject = new TrieProject();
        trieProject.start();
    }

    /**
     * Method to start the program once TrieProject object is created.
     */
    public void start() {
        FileIO io = new FileIO();
        List<String> wordList = io.processText();
        Trie trie = new Trie();
        for (String s : wordList) {
            trie.insert(s);
        }
        System.out.println();
        printCommands();
        boolean stopProgram = false;
        Scanner scanner = new Scanner(System.in);
        while (!stopProgram) {

            String[] input = scanner.nextLine().toLowerCase().split(" ");

            switch (input[0]) {
                case "insert":
                    if (!trie.search(input[1])) {
                        trie.insert(input[1]);
                        System.out.println(input[1] + " successfully inserted.");
                    } else {
                        System.out.println(input[1] + " already exists.");
                    }

                    break;
                case "search":
                    if (trie.search(input[1])) {
                        System.out.println(input[1] + " found!");
                    } else {
                        System.out.println(input[1] + " NOT found.");
                    }
                    break;
                case "delete":
                    if (trie.delete(input[1])) {
                        System.out.println(input[1] + " successfully deleted!");
                    } else {
                        System.out.println("Error deleting, " + input[1] + " not found in tree.");
                    }
                    break;
                case "?":
                    printCommands();
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

    /**
     * Method to print the command list for the user.
     */
    public void printCommands() {
        System.out.println("Please use one of the following commands: ");
        System.out.println("Insert abc  ----  where abc is the word you would like to insert.");
        System.out.println("Search abc  ----  where abc is the word you would like to search for.");
        System.out.println("Delete abc  ----  where abc is the word you would like to delete.");
        System.out.println("?           ----  to print out the list of commands.");
        System.out.println("Exit        ----  to exit the program.");

    }
}
