public class Case {
    private Piece p;
    boolean isComputer = false;

    public Case() {
        this.p = null;
    }

    public Case(Piece p) { 
        this.p = p;
    }

    public Case(Piece p, boolean isComputer) {
        this.p = p;
        this.isComputer = isComputer;
    }

    public Piece getPiece() { 
        return this.p;
    }

    public void setPiece(Piece nouvellePiece) { 
        this.p = nouvellePiece;
    }

    public String toString() { 
        if (this.p == null) {return " . ";} 
        else return p.isComputer() ?  Main.ANSI_BLUE+" O "+Main.ANSI_RESET : Main.ANSI_RED + "0" + Main.ANSI_RESET;
    }
}
