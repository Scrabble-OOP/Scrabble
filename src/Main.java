


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Starter start = new Starter();
        while(start.getOpen()){
            Thread.sleep(1000);
        }


        Game game = new Game(start.getPlayers());



    }
}