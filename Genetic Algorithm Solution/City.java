
public class City {
    String name;
    int x;
    int y;
    
    
    // Constructs a randomly placed city
    public City(){
        this.name="random";
        this.x =  Math.random()*200;
        this.y =  Math.random()*200;
    }
    
    // Constructs a city at chosen x, y location
    public City(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    // Gets city's x coordinate
    public String getName(){
        return this.name;
    }
    
    // Gets city's x coordinate
    public int getX(){
        return this.x;
    }
    
    // Gets city's y coordinate
    public int getY(){
        return this.y;
    }
    
    // Gets the distance to given city
    public double distanceTo(City city){
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    @Override
    public String toString(){
        return ""+getName()+"("+getX()+","+getY()+") --->";
    }
}
