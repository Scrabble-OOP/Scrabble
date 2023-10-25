import java.io.Serializable;

public class TrieTree implements Serializable {
    private Node head;

    public TrieTree(){
        head = new Node();
    }

    public void add(String word){

        int size = word.length();
        Node temp = head;
        int index;

        for(int i = 0; i < size; i++){

            char currentChar = word.charAt(i);

            if(currentChar == 'ñ'){
                index = 26;
            } else {
                index = (int)currentChar - 97;
            }

            if(temp.getChild(index) == null){

                temp.setChild(new Node(currentChar), index);
            }

            temp = temp.getChild(index);
            //if(i == size - 1) temp.setEnd(true);

        }temp.setEnd(true);
    }





    public boolean search(String s){
        Node aux = head;
        int index;
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);

            if(currentChar == 'ñ'){
                index = 26; //
            } else {
                index = (int)currentChar - 97;
            }

            if(aux.getChild(index) == null)  return false;
            aux = aux.getChild(index);
        }
        return true;
    }







    public void print(){
        printAux(head, "");
    }

    private void printAux(Node temp, String fill){
        if(temp.getEnd()){
            System.out.println(fill);
        }
        for(int i = 0; i < 27; i++){ // Cambiado el límite de 26 a 27 para incluir 'ñ'
            if(temp.getChild(i) != null){
                char currentChar;
                if(i == 26){
                    currentChar = 'ñ';
                } else {
                    currentChar = (char) (i + 97);
                }
                printAux(temp.getChild(i), fill + currentChar);
            }
        }
    }
}
