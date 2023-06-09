/* Gaspard QUENTIN & Antoine CUINET
 *
 * groupe TP I2-CMI
 * Université de Franche-Comte UFR-ST
 *
 * Piece.java
*/
public abstract class Piece {
    
    protected int type;
    protected boolean isComputer;
    protected Position.Orientation orientation;

    public abstract Position[] getPositions(); // Position.Orientation o
    //public abstract Position[] getAllPositions();
    //public abstract Piece[] getDispositions();
    public abstract String toString(int index);
    public abstract String toString(boolean seeAllDispositions);
    public boolean isComputer() {
        return this.isComputer;
    }
}
