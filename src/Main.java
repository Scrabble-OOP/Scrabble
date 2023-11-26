


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Starter start = new Starter();
        while(start.getOpen()){
            Thread.sleep(100);
        }


        Game game = new Game(start.getPlayers());
        while(game.isVisible()){
            Thread.sleep(100);
        }

        Archive archive = new Archive();
        archive.update(game.getPlayers());
        Scores scores = new Scores(archive);



    }
}