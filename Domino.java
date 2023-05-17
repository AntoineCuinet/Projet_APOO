/* Gaspard QUENTIN & Antoine CUINET
 *
 * groupe TP I2-CMI
 * Université de Franche-Comte UFR-ST
 *
 * Domino.java
*/
public class Domino extends Piece { 
    
    private static int instanceNbr = 0;

    public Domino(boolean isComputer) {
        super.isComputer = isComputer;
        instanceNbr++;
        assert instanceNbr <= 3;
        super.type = instanceNbr > 1 ? 1: instanceNbr;
    }

    @Override
    public boolean isComputer() { 
        return super.isComputer;
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

    @Override
    public Position[] getPositions() { 
        return getPositions(Position.Orientation.EAST);
    }
    
    @Override
    public String toString(boolean isUnique) { 
        String res = "";
        res+=Main.ANSI_GREEN;
        res+="    +--- ---+  \n";
        res+=" 1. |   |   |  \n";
        res+="    +--- ---+  \n";
        res+=Main.ANSI_RESET;
        return res;
    }

    @Override
    public String toString(int index) {
        String res = "";
        res+=Main.ANSI_GREEN+"\n";
        res+="                     +---+  \n";
        res+="    +--- ---+        |   |  \n";
        res+=" 1. | • |   |     2. +---+  \n";
        res+="    +--- ---+        | • |  \n";
        res+="                     +---+  \n";
        res+="\n"+Main.ANSI_RESET;
        return res;
    } 
}