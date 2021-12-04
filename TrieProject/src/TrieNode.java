import java.util.HashMap;

public class TrieNode {

    private char c;
    private final HashMap<Character,TrieNode> children = new HashMap<>();
    private boolean isWord;

    public TrieNode() {
    }

    public TrieNode(char c){
        this.c = c;
    }

    public HashMap<Character, TrieNode> getChildren(){
        return children;
    }

    public boolean isWord(){
        return isWord;
    }

    public void setIsWord(boolean isWord){
        this.isWord = isWord;
    }



}
