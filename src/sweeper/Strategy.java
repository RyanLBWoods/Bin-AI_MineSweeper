package sweeper;

import java.util.ArrayList;
import java.util.Arrays;

public class Strategy {

    public static void RGS() {
        ArrayList<int[]> uncovered = Game.getUncovered();
        System.out.println(uncovered.size());
        int rd = Game.getRandom(uncovered);

        int[] choice = uncovered.get(rd);
        System.out.println(Arrays.toString(choice));
        Node pb = new Node(choice[0], choice[1], NettleSweeper.map[choice[0]][choice[1]]);

        while(true){
            if(Game.probe(pb)){
                NettleSweeper.printKB();
                uncovered = Game.getUncovered();
                System.out.println(uncovered.size());
                if (uncovered.size() == 0) {
                    NettleSweeper.printKB();
                    System.out.println("You WIN!!!");
                    break;
                }
                rd = Game.getRandom(uncovered);
                choice = uncovered.get(rd);
                System.out.println(Arrays.toString(choice));
                pb = new Node(choice[0], choice[1], NettleSweeper.map[choice[0]][choice[1]]);
            } else {
                System.out.println("BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOM!!!");
                System.out.println("YOU LOSE");
                break;
            }
        }
//        while (Game.probe(pb)) {
//            NettleSweeper.printKB();
//            uncovered = Game.getUncovered();
//            System.out.println(uncovered.size());
//            if (uncovered.size() == 0) {
//                NettleSweeper.printKB();
//                System.out.println("You WIN!!!");
//            }
//            rd = Game.getRandom(uncovered);
//            choice = uncovered.get(rd);
//            System.out.println(Arrays.toString(choice));
//            pb = new Node(choice[0], choice[1], NettleSweeper.map[choice[0]][choice[1]]);
//        }
    }

    public static void SPS() {
        ArrayList<int[]> uncovered = Game.getUncovered();
        System.out.println(uncovered.size());
        ArrayList<Character> states = new ArrayList<>();
        for(char[] x : NettleSweeper.knowledgemap){
            for(char y : x){
                states.add(y);
            }
        }
        while(states.contains('X')){
            for (int[] i : uncovered) {
            if (NettleSweeper.knowledgemap[i[0]][i[1]] == 'X') {
                System.out.println("Probing " + Arrays.toString(i));
                Node current = new Node(i[0], i[1], NettleSweeper.knowledgemap[i[0]][i[1]]);
                Game.setKBNeighbours(current, NettleSweeper.knowledgemap);
                ArrayList<Node> neighbours = new ArrayList<>();
                neighbours.addAll(current.getNeighbours());
                int unknown = 0;
                int mine = 0;
                for (Node n : neighbours) {
                    Game.setKBNeighbours(n, NettleSweeper.knowledgemap);
                    if (n.getState() != 'X' && n.getState() != 'P') {
                        System.out.println(Arrays.toString(n.getLocation()) + " ");

                        for (Node nei : n.getNeighbours()) {
                            System.out.println((char) nei.getState());
                            if (nei.getState() == 'X') {
                                unknown++;
                            }
                            if (nei.getState() == 'P') {
                                mine++;
                            }
                        }

                        System.out.println("Mine: " + mine);
                        System.out.println("Unknown: " + unknown);

                        if ((n.getState() - 48) >= unknown && (n.getState() - 48) > mine
                                && unknown <= (n.getState() - 48 - mine)) {
                            current.mark();
                            NettleSweeper.knowledgemap[current.getX()][current.getY()] = (char) current.getState();
                            System.out.println((char) current.getState());
                            NettleSweeper.printKB();
                            break;
                        } else if ((n.getState() - 48) == mine) {
                            current.setState(current.getX(), current.getY());
                            if(!Game.probe(current)){
                                System.out.println("BOOOOOOOOOOOOOOOOOOOOOOM!!!");
                                System.out.println("YOU LOSE");
                                System.exit(0);
                            }
                            NettleSweeper.printKB();
                            break;
                        }
                        unknown = 0;
                        mine = 0;
                    }
                }
            }
        }
            states = new ArrayList<>();
            for(char[] x : NettleSweeper.knowledgemap){
                for(char y : x){
                    states.add(y);
                }
            }
            uncovered = Game.getUncovered();
        }
        
    }
}
