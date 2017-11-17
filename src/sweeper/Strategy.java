package sweeper;

import java.util.ArrayList;
import java.util.Arrays;

public class Strategy {

    public static void RGS(){
        ArrayList<int[]> uncovered = Game.getUncovered();
        System.out.println(uncovered.size());
        int rd = Game.getRandom(uncovered);
        
        int[] choice = uncovered.get(rd);
        System.out.println(Arrays.toString(choice));
        Node pb = new Node(choice[0], choice[1], NettleSweeper.map[choice[0]][choice[1]]);
        
        while(Game.probe(pb)){
            NettleSweeper.printKB();
            uncovered = Game.getUncovered();
            System.out.println(uncovered.size());
            if(uncovered.size() == 0){
                NettleSweeper.printKB();
                System.out.println("You WIN!!!");
            }
            rd = Game.getRandom(uncovered);
            choice = uncovered.get(rd);
            System.out.println(Arrays.toString(choice));
            pb = new Node(choice[0], choice[1], NettleSweeper.map[choice[0]][choice[1]]);
        }
    }
    
    public static void SPS(){
        ArrayList<int[]> uncovered = Game.getUncovered();
        System.out.println(uncovered.size());
        
        for(int[] i : uncovered){
            Node current = new Node(i[0], i[1], NettleSweeper.knowledgemap[i[0]][i[1]]);
            Game.setKBNeighbours(current, NettleSweeper.knowledgemap);
            ArrayList<Node> neighbours = new ArrayList<>();
            neighbours.addAll(current.getNeighbours());
            
            for(Node n : neighbours){
                
            }
        }
    }
}
