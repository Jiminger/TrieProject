import java.util.HashMap;

/**
 * The Trie class
 */
public class Trie {

    private final TrieNode root;


    /**
     * Trie constructor,
     * Creates and empty trie node object as the root.
     */
    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Method used to insert a word into the trie
     * @param wordToAdd word to add to the trie
     */
    public void insert(String wordToAdd) {

        HashMap<Character, TrieNode> children = root.getChildren();
        for (int i = 0; i < wordToAdd.length(); i++) {

            char c = wordToAdd.charAt(i);
            TrieNode node;

            if (children.containsKey(c)) {
                node = children.get(c);
            } else {
                node = new TrieNode(c);
                children.put(c, node);
            }
            children = node.getChildren();

            if (i == wordToAdd.length() - 1) {
                node.setIsWord(true);
            }
        }
    }

    /**
     * Method used to search the trie for a specific word
     * @param wordToSearch word to search the trie tree for
     * @return true or false based on whether the word was found
     */
    public boolean search(String wordToSearch) {

        HashMap<Character, TrieNode> children = root.getChildren();

        TrieNode node = null;
        for (int i = 0; i < wordToSearch.length(); i++) {
            char c = wordToSearch.charAt(i);
            if (children.containsKey(c)) {
                node = children.get(c);
                children = node.getChildren();
            } else {
                node = null;
                break;
            }
        }

        return node != null && node.isWord();
    }

    /**
     * Method for deleting a word from the trie
     * @param word  the word to delete.
     */

    public void delete(String word) {
        delete(root, word, 0);
    }

    /**
     * Private method to carry out the deleting process requested by the user.
     * @param current current node during traversal
     * @param word word to delete
     * @param index index of the word
     * @return boolean based on whether to delete a node, used for recursion.
     */

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isWord()) {
                return false;
            }
            current.setIsWord(false);
            return current.getChildren().isEmpty();
        }
        char c = word.charAt(index);
        TrieNode node = current.getChildren().get(c);
        if (node == null) {
            return false;
        }
        boolean deleteCurrentNode = delete(node, word, index + 1) && !node.isWord();

        if (deleteCurrentNode) {
            current.getChildren().remove(c);
            return current.getChildren().isEmpty();
        }
        return false;
    }

}
