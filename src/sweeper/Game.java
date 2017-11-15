package sweeper;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    public static void getNettlePosition(){
        ArrayList<int[]> nettles = new ArrayList<>();

        int a = 0;
        int[][] map = EasyMap.getMap(1);
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == -1){
                    int[] nettle_position = {i, j};
                    nettles.add(nettle_position);
                    System.out.println(Arrays.toString(nettles.get(a)));
                    a++;
                }
            }
        }
        
        
    }
}
