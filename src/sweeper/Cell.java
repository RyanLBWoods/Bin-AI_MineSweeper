//package sweeper;
//
//import java.util.ArrayList;
//
//public class Cell {
//
//    private int x;
//    private int y;
//    private String state;
//    
//    private ArrayList<Cell> uncovered;
//    private int marked;
//    
//    Node luNeighbour;
//    Node uNeighbour;
//    Node ruNeighbour;
//    Node lNeighbour;
//    Node rNeighbour;
//    Node ldNeighbour;
//    Node dNeighbour;
//    Node rdNeighbour;
//    
//    ArrayList<Node> neighbours = new ArrayList<>();
//    
//    public Cell(int x, int y){
//        this.x = x;
//        this.y = y;
//        this.state = Configurations.UNCOVER;
//        uncovered = null;
//        marked = 0;
//    }
//    
//    public int getX(){
//        return x;
//    }
//    
//    public int getY(){
//        return y;
//    }
//    
//    public String getState(){
//        return state;
//    }
//    
//    
//    public void setState(String state){
//        this.state = state;
//    }
//    
//    public ArrayList<Cell> getUncoverd(){
//        return uncovered;
//    }
//    
//    public void marked(){
//        
//    }
//    
//    public int[] getLocation() {
//        int[] location = { x, y };
//        return location;
//    }
//    
//    public ArrayList<Node> getNeighbours(){
//        
//        if(this.luNeighbour != null){
//            neighbours.add(luNeighbour);
//        }
//        
//        if(this.uNeighbour != null){
//            neighbours.add(uNeighbour);
//        }
//        
//        if(this.ruNeighbour != null){
//            neighbours.add(ruNeighbour);
//        }
//        
//        if(this.lNeighbour != null){
//            neighbours.add(lNeighbour);
//        }
//        
//        if(this.rNeighbour != null){
//            neighbours.add(rNeighbour);
//        }
//        
//        if(this.ldNeighbour != null){
//            neighbours.add(ldNeighbour);
//        }
//        
//        if(this.dNeighbour != null){
//            neighbours.add(dNeighbour);
//        }
//        
//        if(this.rdNeighbour != null){
//            neighbours.add(rdNeighbour);
//        }
//        
//        return neighbours;
//    }
//}
