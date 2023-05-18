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
        if (!isComputer) { 
            if (instanceNbr <= Main.TRIO_I) { 
                super.type = 1;
            } else { 
                super.type = 2;
            }
            instanceNbr++;
        }
        else { 
            if (instanceNbrPC <= Main.TRIO_I) { 
                super.type = 1;
            } else { 
                super.type = 2;
            }
            instanceNbrPC++;
        }
        
    
    }

    public Triomino() {this(false);}

    @Override
    public Position[] getPositions(Position.Orientation o) { 
        Position[] arr = new Position[3];
        arr[0] = new Position();
        switch (super.type) { 
            case 1:
                switch(o) { 
                    case EAST, WEST : { 
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
            default: arr = Matrix.rotate(getPositions(), o);
        }
        return arr;
    }

    @Override
    public Position[] getPositions() { 
        switch(super.type) { 
            case 1: return getPositions(Position.Orientation.EAST);
            default: { 
                Position[] arr = new Position[3];
                arr[0] = new Position();
                arr[1] = new Position(0, -1);
                arr[2] = new Position(1, 0);
                return arr;
            }
        }
    }
    
    @Override
    public String toString(boolean isUnique) {  
        String res = "";
        res+=Main.ANSI_GREEN;
        res+="    +--- --- ---+  \n";
        res+=" 2. |   |   |   |  \n";
        res+="    +--- --- ---+  \n";
        res+=Main.ANSI_RESET;
        return res;
    }

    @Override
    public String toString(){
        String res = "";
        res+=Main.ANSI_GREEN;
        res+="                         +--- ---+  \n";
        res+="    +--- --- ---+        |   |   |  \n";
        res+=" 1. |   |   |   |     2. +--- ---+  \n";
        res+="    +--- --- ---+        |   |      \n";
        res+="                         +---+      \n";
        res+="\n"+Main.ANSI_RESET;
        return res;
    }

    @Override
    public String toString(int formePieceChoisi){
        String res = "";
        switch(formePieceChoisi){
            case 1:
                res+=Main.ANSI_GREEN+"\n";
                res+="                         +---+  \n"; 
                res+="                         |   |  \n";
                res+="    +--- --- ---+        +---+  \n";
                res+=" 1. | • |   |   |     2. |   |  \n";
                res+="    +--- --- ---+        +---+  \n";
                res+="                         | • |  \n";
                res+="                         +---+  \n";
                res+="\n"+Main.ANSI_RESET;
            break;
            case 2:
                res+=Main.ANSI_GREEN+"\n"; 
                res+="    +--- ---+        +---+                +---+        +--- ---+  \n";
                res+="    | • |   |        |   |                |   |        |   | • |  \n";
                res+=" 1. +--- ---+     2. +--- ---+     3. +--- ---+     4. +--- ---+  \n";
                res+="    |   |            | • |   |        |   | • |            |   |  \n";
                res+="    +---+            +--- ---+        +--- ---+            +---+  \n";
                res+="\n"+Main.ANSI_RESET;
            break;
            default: 
                res+="";
        }
        return res;
    }
}
