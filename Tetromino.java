/* Gaspard QUENTIN & Antoine CUINET
 *
 * groupe TP I2-CMI
 * Université de Franche-Comte UFR-ST
 *
 * Tetromino.java
*/
public class Tetromino extends Piece { 
    
    @Override
    public Position[] getPositions() { 
        Position[] arr = new Position[2];
        arr[0] = new Position();
        switch (super.orientation) {
            case NORTH : { arr[1] = new Position(0, -1);}
            case SOUTH: {arr[1] = new Position(0, 1);}
            case WEST: {arr[1] = new Position(-1, 0);}
            default : {
                arr[1] = new Position(1, 0);
            }
        }
        return arr;
    }
    /*
    @Override
    public Tetromino[] getDispositions() { 
        Tetromino[] te = new Tetromino[1];
        te[0] = new Tetromino();
        return te;
    }
    */

    public Tetromino(boolean isComputer) { 

        super.isComputer = isComputer;
        super.orientation = Position.Orientation.EAST;
    }

    public Tetromino() { 
        this(false);
    }

    /*
    @Override
    public Position[] getPositions() { 
        return getPositions(Position.Orientation.EAST);
    }
    */

    @Override
    public String toString(boolean isUnique) { 
        String res = "";
        res += Main.ANSI_GREEN+"   +--- --- --- ---+\n";
        res += "3. | O | O | O | O |\n";
        res += "   +--- --- --- ---+\n"+Main.ANSI_RESET;
        return res;
    }

    @Override
    public String toString(int index) {
        String res = "";
        res+=Main.ANSI_GREEN+"                        +---+\n"; 
        res+="                        | O |     +--- ---+     +--- ---+         +---+     +---+\n";
        res+="                        +---+     | O | O |     | O | O |         | O |     | O |         +--- ---+\n";
        res+="  +--- --- --- ---+     | O |     +--- ---+     +--- ---+         +---+     +---+         | O | O |\n";
        res+="1.| O | O | O | O |   2.+---+   3.| O |       4.    | O |   5.    | O |   6.| O |       7.+--- ---+\n";
        res+="  +--- --- --- ---+     | O |     +---+             +---+     +--- ---+     +--- ---+     | O | O |\n";
        res+="                        +---+     | O |             | O |     | O | O |     | O | O |     +--- ---+\n";
        res+="                        | O |     +---+             +---+     +--- ---+     +--- ---+\n";
        res+="                        +---+\n";
        res+="\n";
        res+="                                           +---+      +---+          +---+              +---+\n";
        res+="  +--- --- ---+         +---+              | O |      | O |          | O |              | O |\n";
        res+="  | O | O | O |         | O |          +--- ---+      +--- ---+      +--- ---+      +--- ---+\n";
        res+="8.+--- --- ---+   9.+--- --- ---+   10.| O | O |   11.| O | O |   12.| O | O |   13.| O | O |\n";
        res+="      | O |         | O | O | O |      +--- ---+      +--- ---+      +--- ---+      +--- ---+\n";
        res+="      +---+         +--- --- ---+          | O |      | O |              | O |      | O |\n";
        res+="                                           +---+      +---+              +---+      +---+\n";
        res+="\n";
        res+="       +--- ---+      +--- ---+          +---+              +--- --- ---+              +---+      +--- --- ---+\n";
        res+="       | O | O |      | O | O |          | O |              | O | O | O |              | O |      | O | O | O |\n";
        res+="14.+--- --- ---+   15.+--- --- ---+   16.+--- --- ---+   17.+--- --- ---+   18.+--- --- ---+   19.+--- --- ---+\n";
        res+="   | O | O |              | O | O |      | O | O | O |      | O |              | O | O | O |              | O |\n";
        res+="   +--- ---+              +--- ---+      +--- --- ---+      +---+              +--- --- ---+              +---+\n";
        res+="\n"+Main.ANSI_RESET;
        return res;
    }
}
