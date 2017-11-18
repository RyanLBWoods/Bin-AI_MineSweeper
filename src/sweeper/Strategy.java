package sweeper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class for logic strategies.
 * 
 * @author bl41
 *
 */
public class Strategy {

    /**
     * Random guessing strategy.
     */
    public static void RGS() {
        ArrayList<int[]> uncovered = Game.getUncovered();
        System.out.println("Random Guessing!");
        int rd = Game.getRandom(uncovered);

        int[] choice = uncovered.get(rd);
        Node pb = new Node(choice[0], choice[1], NettleSweeper.map[choice[0]][choice[1]]);
        System.out.println("Probing " + Arrays.toString(pb.getLocation()));
        if (Game.probe(pb)) {
            NettleSweeper.printKB();
            uncovered = Game.getUncovered();
            if (uncovered.size() == 0) {
                NettleSweeper.printKB();
                System.out.println("You WIN!!!");
            }
            rd = Game.getRandom(uncovered);
            choice = uncovered.get(rd);
            pb = new Node(choice[0], choice[1], NettleSweeper.map[choice[0]][choice[1]]);
        } else {
            System.out.println("BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOM!!!");
            System.out.println("YOU LOSE");
            System.exit(0);
        }
    }

    /**
     * Single point strategy.
     * 
     * @return Return true if successfully uncovered any cells
     */
    public static boolean SPS() {
        System.out.println("Single Point Strategy!");
        // Get unexplored cells
        ArrayList<int[]> uncovered = Game.getUncovered();
        if (uncovered.size() == 0) {
            return true;
        }
        ArrayList<Character> states = new ArrayList<>();
        for (char[] x : NettleSweeper.knowledgemap) {
            for (char y : x) {
                states.add(y);
            }
        }
        while (states.contains(Configurations.UNCOVER)) {

            for (int[] i : uncovered) {
                if (NettleSweeper.knowledgemap[i[0]][i[1]] == Configurations.UNCOVER) {
                    System.out.println("Attempting " + Arrays.toString(i));
                    Node current = new Node(i[0], i[1], NettleSweeper.knowledgemap[i[0]][i[1]]);
                    Game.setKBNeighbours(current, NettleSweeper.knowledgemap);
                    ArrayList<Node> neighbours = new ArrayList<>();
                    neighbours.addAll(current.getNeighbours());
                    int unknown = 0;
                    int mine = 0;
                    for (Node n : neighbours) {
                        Game.setKBNeighbours(n, NettleSweeper.knowledgemap);
                        // If the the node has been probed
                        if (n.getState() != Configurations.UNCOVER && n.getState() != Configurations.MARK) {
                            System.out.println("Checking " + Arrays.toString(n.getLocation()));

                            for (Node nei : n.getNeighbours()) {
                                if (nei.getState() == Configurations.UNCOVER) {
                                    unknown++;
                                }
                                if (nei.getState() == Configurations.MARK) {
                                    mine++;
                                }
                            }

                            System.out.println("Mine: " + mine);
                            System.out.println("Unknown: " + unknown);

                            if ((n.getState() - 48) >= unknown && (n.getState() - 48) > mine
                                    && unknown <= (n.getState() - 48 - mine)) {
                                // If all marked neighbour
                                System.out.println("Mark!");
                                current.mark();
                                NettleSweeper.nettlenum -= 1;
                                NettleSweeper.knowledgemap[current.getX()][current.getY()] = (char) current.getState();
                                NettleSweeper.printKB();
                                break;
                            } else if ((n.getState() - 48) == mine) {
                                // If all free neighbour
                                current.setState(current.getX(), current.getY());
                                System.out.println("Probe!");
                                if (!Game.probe(current)) {
                                    System.out.println("BOOOOOOOOOOOOOOOOOOOOOOM!!!");
                                    System.out.println("YOU LOSE");
                                    System.exit(0);
                                }
                                NettleSweeper.printKB();
                                break;
                            } else {
                                System.out.println("Can not decide yet...");
                            }
                            // Reset variable for next go
                            unknown = 0;
                            mine = 0;
                        }
                    }
                }
            }
            // Check if current round uncovered any cell
            // Return false when it didn't indicate no move can be make by this
            // strategy
            states = new ArrayList<>();
            for (char[] x : NettleSweeper.knowledgemap) {
                for (char y : x) {
                    states.add(y);
                }
            }
            int temp = uncovered.size();
            uncovered = Game.getUncovered();
            if (temp == uncovered.size()) {
                System.out.println("No Move Can Be Made, Resort to Random Guess...");
                NettleSweeper.printKB();
                return false;
            }
        }
        return true;
    }
}
