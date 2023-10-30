


public class Main {
    public static void main(String[] args) {


        Sack sack = new Sack();
        Board b = new Board();
        b.insertWord(7,0,"adios");
        System.out.println(b);
        System.out.println(b.verify());


    }
}