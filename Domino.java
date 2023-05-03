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

    public Position[] getPositions() { 
        return getPositions(Position.Orientation.EAST);
    }
    


}
