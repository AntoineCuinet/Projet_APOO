public class Domino extends Piece { 
    
    private static int instanceNbr = 0;

    public Domino(boolean isComputer) { 
        super.isComputer = isComputer;
        instanceNbr++;
        assert instanceNbr <= 3;
        super.type = instanceNbr > 1 ? 1: instanceNbr;
    }

    public Domino() {
        this(false);
    }

    @Override
    public Position[] getPositions(Position.Orientation o) { 
        Position[] arr = new Position[2];
        arr[0] = new Position();
        switch (o) {
            case NORTH, SOUTH : { arr[1] = new Position(0, 1); break;}
            default : {arr[1] = new Position(1, 0); break;}
        }
        return arr;
    }
    /*
    @Override
    public Domino[] getDispositions() { 
        Domino[] d = new Domino[1];
        d[0] = new Domino();
        return d;
    }
    */

    @Override
    public Position[] getPositions() { 
        return getPositions(Position.Orientation.EAST);
    }
    
    @Override
    public String toString() { 
        //TODO: faire l'affichage du domino
        String res = "";
        res += Main.ANSI_GREEN+"   +--- ---+\n";
        res += "1. | O | O |\n";
        res += "   +--- ---+\n"+Main.ANSI_RESET;
        return res;
    }

    @Override
    public String toString(boolean seeAllDispositions) {
        String res = "";
        res+=Main.ANSI_GREEN+"                       +---+\n"; 
        res+="   +--- ---+           | O |\n";
        res+="1. | O | O |        2. +---+\n";
        res+="   +--- ---+           | O |\n";
        res+="                       +---+\n"+Main.ANSI_RESET;
        return res;
    }
}
