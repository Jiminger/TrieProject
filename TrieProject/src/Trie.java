import java.util.HashMap;
import java.util.Stack;

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
     * Method used to delete a specified word from the trie
     * @param wordToDelete word meant to be deleted from the trie
     * @return boolean based on whether the word was successfully deleted or not from the trie
     */
    public boolean delete(String wordToDelete){

        if(!search(wordToDelete)){
            return false;
        }

        Stack<TrieNode> stack = new Stack<>();
        TrieNode currentNode = this.root;
        stack.push(currentNode);
        boolean isLastLetter = true;

        for(int i = 0; i < wordToDelete.length(); i++){
            currentNode = currentNode.getChildren().get(wordToDelete.charAt(i));
            stack.push(currentNode);
        }

        while(!stack.isEmpty()){
            currentNode = stack.pop();

            if(isLastLetter){
                currentNode.setIsWord(false);
                isLastLetter = false;
            }

            if(currentNode.isWord()){
                break;
            }

            if(!stack.isEmpty() && currentNode.getChildren().isEmpty()){
                stack.peek().getChildren().remove(currentNode.getC());
            }
        }
        return true;
    }

}
