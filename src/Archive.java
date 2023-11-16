import java.util.List;
import  java.util.HashMap;
public class Archive {

    private HashMap<String, Integer> data;

    public Archive(){

        data = new HashMap<String, Integer>();

    }

    private void update(String name, int points){

        Integer aux = data.get(name);
        if(aux == null) data.put(name, points);
        else data.put(name, aux+points);

    }

    //Esta función se encarga de actualizar el archivo con los puntos de los jugadores

    public void update(List<Player> players){

        for(int i = 0; i<players.size(); i++){
            update(players.get(i).getName(), players.get(i).getScore());
        }

    }


    //Esto es para la interfaz
    public HashMap<String, Integer> getData() {
        return data;
    }



    //Etsa funcion devuelve el nombre del ganador cuando termina el "torneo"
    public String getWinner(){

        String winner = null;
        int maxPoints = Integer.MIN_VALUE;

        for (HashMap.Entry<String, Integer> entry : data.entrySet()) {
            String key = entry.getKey();//se inserta nombre del jugador
            Integer value = entry.getValue();//se le insertan y conectan los puntos a cada jugador
            //se encuentra el jugador con la mayor cantidad de puntos
            if (value > maxPoints) {
                maxPoints = value;
                winner = key;
            }
        }return winner;

    }





}
