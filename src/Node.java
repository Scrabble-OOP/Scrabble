public class Node{
    private char data;

    private final int SIZE = 27;
    private Node[] children;
    private boolean isEnd;

    public Node(){
        data = ' ';
        children = new Node[SIZE];
        isEnd = false;
    }

    public Node(char letter){
        data = letter;
        children = new Node[SIZE];
        isEnd = false;
    }

    public char getData(){
        return data;
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
