/**
 *
 *
 */

public class Computer {
    
    private Piece[] pieceComputer;
    private boolean hasLost;
    private Grid grid;


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String IA_NAME = ANSI_RED + "Yumi" + ANSI_RESET;
    private static final int NB_PIECE = 18;
    private static final int NB_DOMINO = 3;
    private static final int NB_TRIOMINO = 6;
    private static final int NB_TETROMINO = 9;
    
    private static int nbDominoPlaced = 0;
    private static int nbTriominoPlaced = 0;
    private static int nbTetrominoPlaced = 0;
    


    Computer(Grid grid){
        this.hasLost = false;
        this.grid = grid;
        // Initialisation tableau de pièces
        this.pieceComputer = new Piece[NB_PIECE];
        for (int i=0; i<this.pieceComputer.length; i++) { 
            if (i<NB_DOMINO) this.pieceComputer[i] = new Domino(true);
            else if (i<NB_TRIOMINO+NB_DOMINO) this.pieceComputer[i] = new Triomino(true);
            else this.pieceComputer[i] = new Tetromino(true); 
        }

    }


    private static int randomRange(int bInf, int bSup) { 
        return (int) (Math.random()*(bSup-bInf)) + bInf;
    }

    private static int randomRange(int bSup) { 
        return randomRange(0, bSup);
    }
    /**
     * Cette méthode privée permet de retourner une forme de pièce choisie 
     * aléatoirement. Cette fonction renvoie -1 si le nombre aléatoire calculé 
     * représente une pièce déjà posée.
     * */
    private int selectPieceShape(int type) {
        int res;
        switch (type) { 
            case 1 : { 
                res = randomRange(NB_DOMINO);
                if (this.pieceComputer[res] == null) res = -1;
                break;
            }case 2 : { 
                res = randomRange(NB_DOMINO, NB_DOMINO + NB_TRIOMINO);
                if (this.pieceComputer[res] == null) res = -1;
                break;
            }case 3 : { 
                res = randomRange(NB_DOMINO + NB_TRIOMINO, NB_DOMINO + NB_TRIOMINO + NB_TETROMINO);
                if (this.pieceComputer[res] == null) res = -1;
                break;
            }default : { 
                res = -1;
                break;
            }
        }
        return res;
    }

    /**
     * Fonction qui permet à l'odinateur de choisir et de placer une piece sur la grille
     * @param grid
     */
    public void choicePieceComputer(){
        hasYumiLost();
        int selectedPieceType = randomRange(1, 4);
        while((NB_DOMINO==nbDominoPlaced && selectedPieceType==1) || (NB_TRIOMINO==nbTriominoPlaced && selectedPieceType==2) || (NB_TETROMINO==nbTetrominoPlaced && selectedPieceType==3)){
            selectedPieceType = randomRange(1, 4);
        }

        nbDominoPlaced += (selectedPieceType == 1 ? 1: 0); 
        nbTriominoPlaced += (selectedPieceType == 2 ? 1: 0); 
        nbTetrominoPlaced += (selectedPieceType == 3 ? 1: 0); 

        int pieceChoisi = -1;
        do { 
            pieceChoisi = selectPieceShape(selectedPieceType);
        }while(pieceChoisi == -1);


        int pieceDisposition = randomRange(4);
        Position.Orientation orientationChoisie;
        switch(pieceDisposition){
            case 1:
                orientationChoisie = Position.Orientation.NORTH;
            break;
            case 2:
                orientationChoisie = Position.Orientation.EAST;
            break;
            case 3:
                orientationChoisie = Position.Orientation.SOUTH;
            break;
            default:
                orientationChoisie = Position.Orientation.WEST;
        }

        
        int placeColonne = randomRange(11);
        int placeLigne = randomRange(9);

        while (!grid.isPiecePlaceable(pieceComputer[pieceChoisi], orientationChoisie, new Position(placeColonne, placeLigne))){
            placeColonne = randomRange(11);
            placeLigne = randomRange(9);
        } 
        grid.placePiece(pieceComputer[pieceChoisi], orientationChoisie, new Position(placeColonne, placeLigne));
        pieceComputer[pieceChoisi] = null;
        

        String pieceJouer = "";
        switch(selectedPieceType){
            case 1:
                pieceJouer = "Domino";
            break;
            case 2:
                pieceJouer = "Triomino";
            break;
            case 3:
                pieceJouer = "Tetromino";
            break;
        }

        String positionPiecePlace = (new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"})[placeColonne];

        positionPiecePlace += placeLigne;
        Ecran.afficherln(IA_NAME + " à posée un "+ pieceJouer +" à la position "+ positionPiecePlace +".");
        hasYumiLost();
    }

    /**
     * Méthode qui modifie l'état de l'attribut hasLost de l'ordinateur.
     * hasLost prends la valeur true si l'ordinateur a perdu (il est incapable de placer ses pièces restantes)
     */
    public void hasYumiLost() { 
        boolean res = true;
        for (int i = 0; i<Grid.SIZE_X; i++) { 
            for (int j=0; j<Grid.SIZE_Y; j++) { 
                Position origin = new Position(i, j);
                for (Piece p: this.pieceComputer) { 
                    if (p != null)
                        res &= !grid.isPiecePlaceableInAnyPosition(p, origin);
                }
            }
        }
        this.hasLost = res;
    }

    public boolean hasPlayerWon() { 
        return this.hasLost;
    }

}
