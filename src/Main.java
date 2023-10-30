


public class Main {
    public static void main(String[] args) {


        Sack sack = new Sack();
        Board b = new Board();
        b.insertWord(7,0,"pinga", true);
        b.insertWord(6,2,"union", false);
        System.out.println(b);
        System.out.println(b.verify());



    }
}