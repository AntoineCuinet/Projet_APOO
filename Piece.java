public abstract class Piece {
    

    private int type;
    private boolean isComputer = false;

    public abstract Position[] getPositions(Position.Orientation o);
    public abstract Position[] getPositions();
    public abstract Piece[] getDispositions();
    public abstract String toString();
    public abstract String toString(boolean voirDispositions);
    public boolean isComputer() {return this.isComputer;}

}
