


public class Main {
    public static void main(String[] args) {


        Sack sack = new Sack();
        Board b = new Board();
        System.out.println(sack.size());

        Player a = new Player("daniel", sack);

        System.out.println(a);
        System.out.println(sack.size());



    }
}