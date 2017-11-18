package sweeper;

import java.util.Arrays;

public class NettleSweeper {

    public static char[][] knowledgemap = { {'X', 'X', 'X', 'X', 'X'},
                                            {'X', 'X', 'X', 'X', 'X'},
                                            {'X', 'X', 'X', 'X', 'X'},
                                            {'X', 'X', 'X', 'X', 'X'},
                                            {'X', 'X', 'X', 'X', 'X'} };
    
//    public static char[][] knowledgemap = { {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'} };
    
//    public static char[][] knowledgemap = { {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//                                            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'} };
    
    public static int[][] map;
    
    public static void printKB(){
        System.out.println(Arrays.toString(knowledgemap[0]));
        System.out.println(Arrays.toString(knowledgemap[1]));
        System.out.println(Arrays.toString(knowledgemap[2]));
        System.out.println(Arrays.toString(knowledgemap[3]));
        System.out.println(Arrays.toString(knowledgemap[4]));
//        System.out.println(Arrays.toString(knowledgemap[5]));
//        System.out.println(Arrays.toString(knowledgemap[6]));
//        System.out.println(Arrays.toString(knowledgemap[7]));
//        System.out.println(Arrays.toString(knowledgemap[8]));
//        System.out.println(Arrays.toString(knowledgemap[9]));
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        map = EasyMap.getMap(1);
//        map = MediumMap.getMap(1);
//        map = HardMap.getMap(3);
        
        Node start = new Node(0, 0, map[0][0]);
        System.out.println("Start " + Arrays.toString(start.getLocation()));
        Game.deduce(start);
        
//        Strategy.RGS();
        Strategy.SPS();
        
//        System.out.println("BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOM!");
//        System.out.println("You LOSE!!!");
//        System.exit(0);
    }

    
}
