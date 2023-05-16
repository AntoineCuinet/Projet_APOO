/* Gaspard QUENTIN & Antoine CUINET
 *
 * groupe TP I2-CMI
 * Université de Franche-Comte UFR-ST
 *
 * Piece.java
*/
public abstract class Piece {
    

    protected int type;
    public boolean isComputer;

    public abstract Position[] getPositions(Position.Orientation o);
    public abstract Position[] getPositions();
    //public abstract Piece[] getDispositions();
    public abstract String toString(int index);
    public abstract String toString(boolean seeAllDispositions);
    public boolean isComputer() {
        System.out.println(this.isComputer);
        return this.isComputer;}

}
