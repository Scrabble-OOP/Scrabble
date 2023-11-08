


public class Main {
    public static void main(String[] args) {


        Sack sack = new Sack();
        Board b = new Board();
        b.insertWord(14,0,"hola", true);
        b.insertWord(0,14,"union", false);
        System.out.println(b);
        System.out.println(b.verify());



    }
}