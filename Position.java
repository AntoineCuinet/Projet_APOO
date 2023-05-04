/* Gaspard QUENTIN & Antoine CUINET
 *
 * groupe TP I2-CMI
 * Université de Franche-Comte UFR-ST
 *
 * Position.java
*/
public class Position {
    public enum Orientation { 
        EAST, WEST, NORTH, SOUTH
    }

    private int x;
    private int y;

    public Position(int x, int y) { 
        this.x = x;
        this.y = y;
    }

    public Position() {this(0, 0);}
    
    public int getX() {return this.x;}

    public int getY() {return this.y;}

    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

    public void add(Position p) { 
        this.x += p.getX();
        this.y += p.getY();
    }

    public void multiply(Position vect) { 
        this.x *= vect.getX();
        this.y *= vect.getY();
    }

    public static Position multiply(Position v1, Position v2) { 
        return new Position(v1.getX()*v2.getX(), v1.getY()*v2.getY());
    }

    public static Position add(Position p1, Position p2) { 
        return new Position(p1.getX() + p2.getX(), p1.getY() + p2.getY());
    }
}
