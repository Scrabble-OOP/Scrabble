
public class TrieTree{
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

        }temp.setEnd(true);
    }





    public boolean search(String s){

        System.out.println("Searching for: " + s);
        Node root = head;
        return searchAux(root ,0, s);

    }


    private boolean searchAux(Node root, int index, String word){

        if(root == null) return false;

        if(index == word.length()) return root.getEnd();

        char currChar = word.charAt(index);

        if(currChar == '☻'){  //Si nos encontramos algun joker, ocupamos que alguna de las letras calce.

            for(int i = 0; i<27; ++i)

                if(searchAux(root.getChild(i), index+1, word)) return true;

            return false;

        }return searchAux(root.getChild((currChar == 'ñ')? 26: currChar - 'a'), index+1, word);  //Llamada recursiva pero desde el siguiente char de la palabra

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
