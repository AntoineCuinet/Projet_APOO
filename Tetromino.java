/* Gaspard QUENTIN & Antoine CUINET
 *
 * groupe TP I2-CMI
 * Université de Franche-Comte UFR-ST
 *
 * Tetromino.java
*/
public class Tetromino extends Piece { 

    private static int instanceNbr = 0;
    private static int instanceNbrPC = 0;
    
    public Tetromino(boolean isComputer) { 
        super.isComputer = isComputer;
        if (!isComputer) {
            instanceNbr++;
            if (instanceNbr <= 2) { 
                super.type = 1;
            }else { 
                super.type = instanceNbr - 1;
            }
        }
        else { 
            instanceNbrPC++;
            if (instanceNbrPC <= 2) { 
                super.type = 1;
            }else { 
                super.type = instanceNbrPC - 1;
            }
        }
    }

    @Override
    public Position[] getPositions(Position.Orientation o) { 
        Position rotationVector = Position.getRotationVector(o);
        Position[] piece = getPositions();
        for (Position e: piece) { 
            e.multiply(rotationVector);
        }
        return piece;
    }
    /*
    @Override
    public Tetromino[] getDispositions() { 
        Tetromino[] te = new Tetromino[1];
        te[0] = new Tetromino();
        return te;
    }
    */


    public Tetromino() { 
        this(false);
    }

    @Override
    public Position[] getPositions() { 
        Position[] arr = new Position[4];
        arr[0] = new Position();
        switch (super.type) { 
            case 1 : { 
                arr[1] = new Position(1, 0);
                arr[2] = new Position(2, 0);
                arr[3] = new Position(3, 0);
                break;
            }
            case 2 : { 
                arr[1] = new Position(1, 0);
                arr[2] = new Position(0, -1);
                arr[3] = new Position(0, -2);
                break;
            }
            case 3 : { 
                arr[1] = new Position(1, 0);
                arr[2] = new Position(0, -1);
                arr[3] = new Position(1, -1);
                break;
            } 
            case 4 : { 
                arr[1] = new Position(1, 0);
                arr[2] = new Position(2, 0);
                arr[3] = new Position(1, -1);
                break;
            }
            case 5 : {
                arr[1] = new Position(0, -1);
                arr[2] = new Position(1, -1);
                arr[3] = new Position(1, -2);
                break;
            }
            default : {
                arr[1] = new Position(0, -1);
                arr[2] = new Position(1, -1);
                arr[3] = new Position(2, -1);
                break;
            }
        }
        return arr;
    }
    

    @Override
    public String toString(boolean isUnique) { 
        String res = "";
        res+=Main.ANSI_GREEN;
        res+="    +--- --- --- ---+  \n";
        res+=" 3. |   |   |   |   |  \n";
        res+="    +--- --- --- ---+  \n";
        res+=Main.ANSI_RESET;
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
