import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FileIO Class used for handling the specific input file for this implementation/demo
 */

public class FileIO {

    private Scanner fileScanner;


    /**
     * FileIO constructor
     */
    public FileIO() {
        try {
            File inputFile = new File("Twas_the_Night_Before_Christmas.txt");
            fileScanner = new Scanner(inputFile);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Method used to process the text of the input file
     *
     * @return a list of the processed words from the input file
     */
    public List<String> processText() {
        List<String> stringList = new ArrayList<>();
        System.out.println("\nProcessing Text...");


        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if (line.isEmpty()) {
                continue;
            }


            // Skipping first line containing title of the story.
            if (line.charAt(0) != '#') {
                String[] words = line.split(" ");

                for (String s : words) {
                    // Punctuation handling specific to this input file.
                    if (!s.equals("-")) {
                        // Forcing string to be lowercase to limit amount of nodes
                        s = s.toLowerCase();
                        StringBuilder sb = new StringBuilder();

                        for (int i = 0; i < s.length(); i++) {
                            //Handling certain punctuation in the specified text.
                            if (s.charAt(i) != ',' && s.charAt(i) != '!' && s.charAt(i) != '.'
                                    && s.charAt(i) != '\"' && s.charAt(i) != '?' && s.charAt(i) != ';') {
                                sb.append(s.charAt(i));
                            }
                        }
                        stringList.add(sb.toString());
                    }
                }
            }
        }
        System.out.println("Text Processing Complete.");
        return stringList;
    }

}
