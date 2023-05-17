/* Gaspard QUENTIN & Antoine CUINET
 *
 * groupe TP I2-CMI
 * Université de Franche-Comte UFR-ST
 *
 * Triomino.java
*/
public class Triomino extends Piece { 
    
    private static int instanceNbr = 0;
    private static int instanceNbrPC = 0;

    public Triomino(boolean isComputer) { 
        super.isComputer = isComputer;
        if(!isComputer) instanceNbr++;
        else instanceNbrPC++;
        assert (instanceNbr <= 6 && instanceNbrPC <= 6);
        if (instanceNbr > 2) {
            super.type = ( (instanceNbr%2) == 0) ? 2: 1;
            if (instanceNbr%2==0) super.type = 2;
            else super.type = 1;
        }
        else {
            super.type = instanceNbr;
        }
        if (instanceNbrPC > 2) super.type = ( (instanceNbrPC % 2) == 0) ? 2: 1;
        else if (isComputer) super.type = instanceNbrPC;
        switch (instanceNbr) { 
            case 1,3: super.orientation = Position.Orientation.EAST;
            case 2,4: super.orientation = Position.Orientation.NORTH;
            case 5: super.orientation = Position.Orientation.WEST;
            default: super.orientation = Position.Orientation.SOUTH;
        }
    }

    public Triomino() {this(false);}

    @Override
    public Position[] getPositions() { 
        Position[] arr = new Position[3];
        arr[0] = new Position();
        switch (super.type) { 
            case 1:
                switch(super.orientation) { 
                    case NORTH, SOUTH : { 
                        arr[1] = new Position(1, 0);
                        arr[2] = new Position(2, 0);
                        break;
                    }
                    default: { 
                        arr[1] = new Position(0, 1);
                        arr[2] = new Position(0, 2);
                        break;
                    }
                }
                break;
            default:
                Position[] temp = new Position[3];
                temp[0] = new Position();
                temp[1] = new Position(0, 1);
                temp[2] = new Position(1, 0);

                Position rotationVector;
                switch(super.orientation) {
                    case EAST: {rotationVector = new Position(1, 1);break;}
                    case SOUTH: {rotationVector = new Position(-1, 1);break;}
                    case WEST: {rotationVector = new Position(-1, -1); break;}
                    default: {rotationVector = new Position(1, -1); break;}
                }
                for (int i=0; i<arr.length; i++) { 
                    arr[i] = Position.multiply(temp[i], rotationVector);
                }
                break;
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
    public String toString(boolean isUnique) {  
        String res = "";
        res += Main.ANSI_GREEN+"   +--- --- ---+\n";
        res += "2. | O | O | O |\n";
        res += "   +--- --- ---+\n"+Main.ANSI_RESET;
        return res;
    }

    /* 
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

    */

    @Override
    public String toString(){
        String res = "";
        res += Main.ANSI_GREEN+"                     +--- ---+\n";
        res += "   +--- --- ---+     | O | O |\n";
        res += "1. | O | O | O |   2.+--- ---+\n";
        res += "   +--- --- ---+     | O |    \n";
        res += "                     +---+   \n"+Main.ANSI_RESET;
        return res;
    }

    @Override
    public String toString(int formePieceChoisi){
        String res = "";
        switch(formePieceChoisi){
                case 1:
                res += "\n";
                res+=Main.ANSI_GREEN+"                    +---+\n"; 
                res+="                    |   |\n";
                res+="  +--- --- ---+     +---+\n";
                res+="1.| • |   |   |   2.|   |\n";
                res+="  +--- --- ---+     +---+\n";
                res+="                    | • |\n";
                res+="                    +---+\n"+Main.ANSI_RESET;
                res += "\n";
            break;
            case 2:
                res += "\n";
                res+=Main.ANSI_GREEN+"\n"; 
                res+="   +--- ---+     +--- ---+         +---+     +---+\n";
                res+="   | • |   |     |   | • |         |   |     |   |\n";
                res+=" 1.+--- ---+   2.+--- ---+   3.+--- ---+   4.+--- ---+\n";
                res+="   |   |             |   |     |   | • |     | • |   |\n";
                res+="   +---+             +---+     +--- ---+     +--- ---+\n";
                res+="\n"+Main.ANSI_RESET;
                res += "\n";
            break;
            default:
                res+="";
        }
        return res;
    }
}
