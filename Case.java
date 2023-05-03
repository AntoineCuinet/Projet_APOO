public class Case {
    private Piece p;
    boolean isComputer = false;

    public Case() {
        this.p = null;
    }

    public Case(Piece p) { 
        this.p = p;
    }

    public Case(Piece p, boolean isComputer )

    public Piece getPiece() { 
        return this.p;
    }

    public void setPiece(Piece nouvellePiece) { 
        this.p = nouvellePiece;
    }

    public String toString() { 
        if (this.p == null) {return " . |";} 
        else return " O |";
    }
}
