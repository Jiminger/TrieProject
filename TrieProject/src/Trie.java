import java.util.HashMap;

public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

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

    public void delete(String word) {
        delete(root, word, 0);
    }

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
