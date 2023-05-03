public abstract class Piece {
    

    protected int type;
    protected boolean isComputer = false;

    public abstract Position[] getPositions(Position.Orientation o);
    public abstract Position[] getPositions();
    public abstract Piece[] getDispositions();
    public abstract String toString();
    public abstract String toString(boolean voirDispositions);
    public boolean isComputer() {return this.isComputer;}

}
