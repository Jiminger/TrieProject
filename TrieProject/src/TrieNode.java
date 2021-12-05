import java.util.HashMap;

/**
 * Trie nodes class
 * Each node has a character associated with it, a hashmap of child nodes
 * and a boolean value to show whether the node is the last letter of a complete word.
 */

public class TrieNode {

    private char c;
    private final HashMap<Character,TrieNode> children = new HashMap<>();
    private boolean isWord;

    /**
     * Empty constructor (used for root)
     */
    public TrieNode() {
    }

    /**
     * Constructor used for assigning character to trie node
     * @param c the character to assign to the trie node
     */
    public TrieNode(char c){
        this.c = c;
    }

    /**
     * Getter for character value of the node
     * @return character value
     */
    public char getC() {
        return c;
    }

    /**
     * Method used for getting the children of a specific node
     * @return map of children
     */
    public HashMap<Character, TrieNode> getChildren(){
        return children;
    }

    /**
     * Method used to see if the node is the last letter of a complete word
     * @return true/false based on if this node is the last letter of a complete word
     */
    public boolean isWord(){
        return isWord;
    }

    /**
     * Method used to set whether this node is the last letter of a complete word
     * @param isWord boolean signifying  whether this node is the last letter of a complete word
     */
    public void setIsWord(boolean isWord){
        this.isWord = isWord;
    }



}
