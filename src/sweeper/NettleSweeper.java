package sweeper;

import java.util.Arrays;
import java.util.Scanner;

public class NettleSweeper {

    public static char[][] knowledgeBase1 = { { 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X' } };

    public static char[][] knowledgeBase2 = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

    public static char[][] knowledgeBase3 = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

    public static int[][] map;
    public static char[][] knowledgemap;

    public static int mapSize;
    public static Scanner sc = new Scanner(System.in);

    public static void printKB() {
        for(char[] row: knowledgemap){
            System.out.println(Arrays.toString(row));
        }
//        System.out.println(Arrays.toString(knowledgemap[0]));
//        System.out.println(Arrays.toString(knowledgemap[1]));
//        System.out.println(Arrays.toString(knowledgemap[2]));
//        System.out.println(Arrays.toString(knowledgemap[3]));
//        System.out.println(Arrays.toString(knowledgemap[4]));
        // System.out.println(Arrays.toString(knowledgemap[5]));
        // System.out.println(Arrays.toString(knowledgemap[6]));
        // System.out.println(Arrays.toString(knowledgemap[7]));
        // System.out.println(Arrays.toString(knowledgemap[8]));
        // System.out.println(Arrays.toString(knowledgemap[9]));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int l = selectLevel();
        int n = selectMap();
        switch (l) {
        case 1:
            map = EasyMap.getMap(n);
            knowledgemap = knowledgeBase1;
            mapSize = 5;
            break;

        case 2:
            map = MediumMap.getMap(n);
            knowledgemap = knowledgeBase2;
            mapSize = 9;
            break;

        case 3:
            map = HardMap.getMap(n);
            knowledgemap = knowledgeBase3;
            mapSize = 10;
            break;

        default:
            System.out.println("Invalid Selection");
            System.exit(0);
            break;
        }
        // map = EasyMap.getMap(1);
        // map = MediumMap.getMap(1);
        // map = HardMap.getMap(3);

        Node start = new Node(0, 0, map[0][0]);
        System.out.println("Start " + Arrays.toString(start.getLocation()));
        Game.deduce(start);

        // Strategy.RGS();
        if (!Strategy.SPS()) {
            Strategy.RGS();
        } else {
            System.out.println("You Win!!!");
        }

        // System.out.println("BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOM!");
        // System.out.println("You LOSE!!!");
        // System.exit(0);
    }

    public static int selectLevel() {
        int lvl = 0;
        System.out.println("Please Select Level(1, 2, 3) ");
        System.out.println("1. Easy: 5 * 5 with 5 nettles");
        System.out.println("2. Medium: 9 * 9 with 10 nettles");
        System.out.println("3. Hard: 10 * 10 with 20 nettles");
        lvl = sc.nextInt();
        return lvl;
    }

    public static int selectMap() {
        int num = 0;
        System.out.println("Please Select Map Number (1 ~ 5)");
        num = sc.nextInt();
        return num;
    }

}
