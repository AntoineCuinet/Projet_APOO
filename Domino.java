public class Domino extends Piece { 
    
    static int instanceNbr = 0;

    public Domino(boolean isComputer) { 
        super.isComputer = isComputer;
        instanceNbr++;
        super.type = instanceNbr;
    }

    public Domino() {
        this(false);
    }
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
        return "[][]";
    }

    @Override
    public String toString(boolean seeAllDispositions) {
        Position[] p = getPositions();
        return "";
    }


}
