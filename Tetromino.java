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
        int cond = Main.TETRO_I + Main.TETRO_J + Main.TETRO_L ;
        if (!isComputer) {
            if (instanceNbr <= Main.TETRO_I) { 
                super.type = 1;
            }else if (instanceNbr > cond && instanceNbr < cond + Main.TETRO_T) { 
                super.type = cond;
            }else { 
                super.type = instanceNbr + (instanceNbr > cond ? -2 : - 1);
            }
            instanceNbr++;
        }
        else { 
            instanceNbrPC++;
            if (instanceNbrPC <= 2) { 
                super.type = 1;
            }else if (instanceNbrPC > cond && instanceNbrPC <= cond + Main.TETRO_T) { 
                super.type = cond ;
            }else {
                super.type = instanceNbrPC + (instanceNbr > cond ? -2 : -1);
            }
        }
    }

    /*
    @Override
    public Position[] getPositions(Position.Orientation o) { 
        Position rotationVector = Position.getRotationVector(o);
        Position[] piece = getPositions();
        for (Position e: piece) { 
            e.multiply(rotationVector);
        }
        return piece;
    }
    */
    public Position[] getPositions(Position.Orientation o) { 
        return Matrix.rotate(getPositions(), o);
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
            case 2 : { // TETRO L
                arr[1] = new Position(1, 0);
                arr[2] = new Position(0, -1);
                arr[3] = new Position(0, -2);
                break;
            }
            case 3 : { 
                arr[1] = new Position(1, 0);
                arr[2] = new Position(1, -2);
                arr[3] = new Position(1, -1);
                break;
            } 
            case 4 : { 
                arr[1] = new Position(0, -1);
                arr[2] = new Position(-1, -1);
                arr[3] = new Position(0, -2);
                break;
            }
            case 5 : {
                arr[1] = new Position(0, -1);
                arr[2] = new Position(1, -1);
                arr[3] = new Position(1, -2);
                break;
            }
            case 6 : { 
                arr[1] = new Position(-1, -1);
                arr[2] = new Position(0, -1);
                arr[3] = new Position(-1, -2);
                break;
            }
            case 7 : { // TETRO 0
                arr[1] = new Position(1, 0);
                arr[2] = new Position(0, -1);
                arr[3] = new Position(1, -1);
                break;
            }
            default : { 
                System.out.println("FATAL ERROR in <Tetromino.java> : no tetromino with type > 7 or type < 1");
                return null;
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
    public String toString(){
        String res = "";
        res+=Main.ANSI_GREEN;
        res+="                         +--- ---+     +--- ---+         +---+     +---+             +---+               \n";
        res+="                         |   |   |     |   |   |         |   |     |   |             |   |     +--- ---+ \n";
        res+="   +--- --- --- ---+     +--- ---+     +--- ---+     +--- ---+     +--- ---+     +--- ---+     |   |   | \n";
        res+=" 1.|   |   |   |   |   2.|   |       3.    |   |   4.|   |   |   5.|   |   |   6.|   |   |   7.+--- ---+ \n";
        res+="   +--- --- --- ---+     +---+             +---+     +--- ---+     +--- ---+     +--- ---+     |   |   | \n";
        res+="                         |   |             |   |         |   |         |   |     |   |         +--- ---+ \n";
        res+="                         +---+             +---+         +---+         +---+     +---+                   \n";
        res+="\n"+Main.ANSI_RESET;
        return res;
    }

    @Override
    public String toString(int formePieceChoisi) {
        String res = "";
        switch(formePieceChoisi){
            case 1:
                res+=Main.ANSI_GREEN;
                res+="                         +---+ \n"; 
                res+="                         |   | \n";
                res+="                         +---+ \n";
                res+="   +--- --- --- ---+     |   | \n";
                res+=" 1.| • |   |   |   |   2.+---+ \n";
                res+="   +--- --- --- ---+     |   | \n";
                res+="                         +---+ \n";
                res+="                         | • | \n";
                res+="                         +---+ \n";
                res+="\n"+Main.ANSI_RESET;
            break;
            case 2:
                res+=Main.ANSI_GREEN;
                res+="   +--- ---+                           +---+                   \n";
                res+="   | • |   |     +---+                 |   |     +--- --- ---+ \n";
                res+="   +--- ---+     |   |                 +---+     |   |   | • | \n";
                res+=" 1.|   |       2.+--- --- ---+   3.    |   |   4.+--- --- ---+ \n";
                res+="   +---+         | • |   |   |     +--- ---+             |   | \n";
                res+="   |   |         +--- --- ---+     |   | • |             +---+ \n";
                res+="   +---+                           +--- ---+                   \n";
                res+="\n"+Main.ANSI_RESET;
            break;
            case 3:
                res+=Main.ANSI_GREEN;
                res+="   +--- ---+                       +---+                       \n";
                res+="   | • |   |     +--- --- ---+     |   |                 +---+ \n";
                res+="   +--- ---+     |   |   |   |     +---+                 | • | \n";
                res+=" 1.    |   |   2.+--- --- ---+   3.|   |       4.+--- --- ---+ \n";
                res+="       +---+     | • |             +--- ---+     |   |   |   | \n";
                res+="       |   |     +---+             |   | • |     +--- --- ---+ \n";
                res+="       +---+                       +--- ---+                   \n";
                res+="\n"+Main.ANSI_RESET;
            break;
            case 4:
                res+=Main.ANSI_GREEN;
                res+="       +---+                       +---+                       \n";
                res+="       | • |     +--- --- ---+     |   |             +---+     \n";
                res+="   +--- ---+     | • |   |   |     +--- ---+         |   |     \n";
                res+=" 1.|   |   |   2.+--- --- ---+   3.|   |   |   4.+--- --- ---+ \n";
                res+="   +--- ---+         |   |         +--- ---+     |   |   | • | \n";
                res+="       |   |         +---+         | • |         +--- --- ---+ \n";
                res+="       +---+                       +---+                       \n";
                res+="\n"+Main.ANSI_RESET;
            break;
            case 5:
                res+=Main.ANSI_GREEN;
                res+="   +---+                       \n";
                res+="   | • |             +--- ---+ \n";
                res+="   +--- ---+         |   |   | \n";
                res+=" 1.|   |   |   2.+--- --- ---+ \n";
                res+="   +--- ---+     | • |   |     \n";
                res+="       |   |     +--- ---+     \n";
                res+="       +---+                   \n";
                res+="\n"+Main.ANSI_RESET;
            break;
            case 6:
                res+=Main.ANSI_GREEN;
                res+="       +---+                   \n";
                res+="       | • |     +--- ---+     \n";
                res+="   +--- ---+     | • |   |     \n";
                res+=" 1.|   |   |   2.+--- --- ---+ \n";
                res+="   +--- ---+         |   |   | \n";
                res+="   |   |             +--- ---+ \n";
                res+="   +---+                       \n";
                res+="\n"+Main.ANSI_RESET;
            break;
            case 7:
                res+=Main.ANSI_GREEN;
                res+="   +--- ---+ \n";
                res+="   | • |   | \n";
                res+=" 1.+--- ---+ \n";
                res+="   |   |   | \n";
                res+="   +--- ---+ \n";
                res+="\n"+Main.ANSI_RESET;
            break;
        }
        return res;
    }
}
