public class Triomino extends Piece { 
    
    @Override
    public Position[] getPositions(Position.Orientation o) { 
        Position[] arr = new Position[2];
        arr[0] = new Position();
        switch (o) {
            case NORTH : { arr[1] = new Position(0, -1);}
            case SOUTH: {arr[1] = new Position(0, 1);}
            case WEST: {arr[1] = new Position(-1, 0);}
            default : {
                arr[1] = new Position(1, 0);
            }
        }
        return arr;
    }

    @Override
    public Domino[] getDispositions() { 
        Domino[] d = new Domino[1];
        d[0] = new Domino();
        return d;
    }

    @Override
    public Position[] getPositions() { 
        return getPositions(Position.Orientation.EAST);
    }
    

    @Override
    public String toString() { 
        //TODO: faire l'affichage du domino
        String res = "";
        res += Main.ANSI_GREEN+"   +--- --- ---+\n";
        res += "2. | O | O | O |\n";
        res += "   +--- --- ---+\n"+Main.ANSI_RESET;
        return res;
    }

    @Override
    public String toString(boolean seeAllDispositions) {
        String res = "";
        res+=Main.ANSI_GREEN+"                    +---+\n"; 
        res+="                    | O |     +--- ---+     +--- ---+         +---+     +---+\n";
        res+="  +--- --- ---+     +---+     | O | O |     | O | O |         | O |     | O |\n";
        res+="1.| O | O | O |   2.| O |   3.+--- ---+   4.+--- ---+   5.+--- ---+   6.+--- ---+\n";
        res+="  +--- --- ---+     +---+     | O |             | O |     | O | O |     | O | O |\n";
        res+="                    | O |     +---+             +---+     +--- ---+     +--- ---+\n";
        res+="                    +---+\n"+Main.ANSI_RESET;
        return res;
    }
}