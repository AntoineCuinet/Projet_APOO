/* Gaspard QUENTIN & Antoine CUINET
 *
 * Mini-projet APOO
 * 
 * groupe TP I2-CMI
 * Université de Franche-Comte UFR-ST 
 *
 * Année universitaire 2022/2023
 *
 * Piece.java
*/

public abstract class Piece {
    
    public int type;
    public boolean isComputer;

    public abstract Position[] getPositions(Position.Orientation o);
    public abstract Position[] getPositions();
    //public abstract Piece[] getDispositions();
    public abstract String toString(int index);
    public abstract String toString(boolean seeAllDispositions);
    public boolean isComputer() {
        return this.isComputer;
    }
    
}
