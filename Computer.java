public class Computer {
    
    Piece[] pieceComputer;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String IA_NAME = ANSI_RED + "Yumi" + ANSI_RESET;
    private static final int NB_PIECE = 18;
    private static int NB_DOMINO = 3;
    private static int NB_TRIOMINO = 6;
    private static int NB_TETROMINO = 9;
    private static int trioI = 3;
    private static int trioT = 3;
    private static int tetroI = 2;
    private static int tetroJ = 1;
    private static int tetroL = 1;
    private static int tetro0 = 1;
    private static int tetroT = 2;
    private static int tetroS = 1;
    private static int tetroZ = 1;


    Computer(Grid grid){
        // Initialisation tableau de pièces
        pieceComputer = new Piece[NB_PIECE];
        for (int i=0; i<pieceComputer.length; i++) { 
            if (i<NB_DOMINO) pieceComputer[i] = new Domino(true);
            else if (i<NB_TRIOMINO+NB_DOMINO) pieceComputer[i] = new Triomino(true);
            else pieceComputer[i] = new Tetromino(true); 
        }
    }


    /**
     * Fonction qui permet à l'odinateur de choisir et de placer une piece sur la grille
     * @param grid
     */
    public void choicePieceComputer(Grid grid){
        int pieceChoisi = (int) (Math.random()*3)+1;
        // vérification de la saisie
        while(pieceChoisi<1 || pieceChoisi>3 || (NB_DOMINO==0 && pieceChoisi==1) || (NB_TRIOMINO==0 && pieceChoisi==2) || (NB_TETROMINO==0 && pieceChoisi==3)){
            pieceChoisi = (int) (Math.random()*3);
        }

        int formePieceChoisi = 0;
        if(pieceChoisi == 3){
            formePieceChoisi = (int) (Math.random()*7);
            // vérif à faire en fonction su nombre donné et de si il reste ou non des pièces de ce type
        } else if(pieceChoisi == 2){
            formePieceChoisi = (int) (Math.random()*2);
            // vérif à faire en fonction su nombre donné et de si il reste ou non des pièces de ce type
        }


        int pieceDisposition = (int) (Math.random()*4);
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

        
        int placeColonne = (int) (Math.random()*11);
        int placeLigne = (int) (Math.random()*9);

        while (!grid.isPiecePlaceable(pieceComputer[pieceChoisi], orientationChoisie, new Position(placeColonne, placeLigne))){
            placeColonne = (int) Math.random()*11;
            placeLigne = (int) Math.random()*9;
        } 
        grid.placePiece(pieceComputer[pieceChoisi], orientationChoisie, new Position(placeColonne, placeLigne));

        String pieceJouer = "";
        switch(pieceChoisi){
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

        String positionPiecePlace = "";
        switch(placeColonne){
            case 0:
            positionPiecePlace += "A";
            break;
            case 1:
            positionPiecePlace += "B";
            break;
            case 2:
            positionPiecePlace += "C";
            break;
            case 3:
            positionPiecePlace += "D";
            break;
            case 4:
            positionPiecePlace += "E";
            break;
            case 5:
            positionPiecePlace += "F";
            break;
            case 6:
            positionPiecePlace += "G";
            break;
            case 7:
            positionPiecePlace += "H";
            break;
            case 8:
            positionPiecePlace += "I";
            break;
            case 9:
            positionPiecePlace += "J";
            break;
            case 10:
            positionPiecePlace += "K";
            break;
            case 11:
            positionPiecePlace += "L";
            break;
        }
        positionPiecePlace += placeLigne;
        Ecran.afficherln(IA_NAME + " à posée un "+ pieceJouer +" à la position "+ positionPiecePlace +".");
    }
}
