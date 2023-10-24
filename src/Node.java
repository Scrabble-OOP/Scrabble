public class Node {
    private char data;
    private Node[] children = new Node[26];
    private boolean isEnd = false;

    public Node(){
        data = ' ';
        children = new Node[26];
        isEnd = false;
    }

    public Node(char letter){
        data = letter;
        children = new Node[26];
        isEnd = false;
    }

    public char getData(){
        return data;
    }

    public Node[] getChildren(){
        return children;
    }

    public Node getChild(int i){
        return children[i];
    }

    public void setChild(Node letter, int index){
        this.children[index] = letter;
    }

    public void setEnd(boolean end){
        isEnd = end;
    }

    public boolean getEnd(){
        return isEnd;
    }
}
