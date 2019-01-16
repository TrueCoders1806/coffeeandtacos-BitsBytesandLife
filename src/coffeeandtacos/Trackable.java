package coffeeandtacos;

public class Trackable {
    private String name;
    private Point location;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setLocation(Point location) {
        this.location = location;
    }
    
    public Point getLocation() {
        return this.location;
    }
}
