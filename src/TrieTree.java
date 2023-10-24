public class TrieTree {
    private Node head = new Node();

    public TrieTree(){
        head = new Node();
    }

    public void add(String word){
        int size = word.length();
        Node temp = head;
        for(int i = 0; i < size; i++){
            if(temp.getChild((int)word.charAt(i) - 97) == null){
                temp.setChild(new Node(word.charAt(i)), (int)word.charAt(i) - 97);
            }
            temp = temp.getChild((int)word.charAt(i) - 97);
            if(i == size -1) temp.setEnd(true);
        }
    }

    public void print(){
        printAux(head, "");
    }

    private void printAux(Node temp, String fill){
        if(temp.getEnd()){
            System.out.println(fill);
        }
        for(int i = 0; i < 26; i++){
            if(temp.getChild(i) != null){
                printAux(temp.getChild(i), fill + temp.getChild(i).getData());
            }
        }
    }
}
