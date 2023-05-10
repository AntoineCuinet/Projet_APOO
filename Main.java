/* Gaspard QUENTIN & Antoine CUINET
 *
 * groupe TP I2-CMI
 * Université de Franche-Comte UFR-ST
 *
 * Main.java
*/

public class Main { 
    // déclaration des couleurs utilisées pour l'affichage (pour la créativité)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String YELLOW_BG = "\u001B[43m";
    public static final String RESET_BG = "\u001B[40m";

    public static final String IA_NAME = "Yumi";
    private static boolean isWin = false;
    private static boolean isLoose = false;

    private static final int NB_PIECE = 18;
    private static int NB_DOMINO = 3;
    private static int NB_TRIOMINO = 6;
    private static int NB_TETROMINO = 9;

    public enum Type {Domino, Triomino, Tetromino};

    public static void main(String[] args) { 
        Grid grid = new Grid();
        Domino d = new Domino();
        Triomino t = new Triomino();
        Tetromino te = new Tetromino();
        int trioI = 3;
        int trioT = 3;
        int tetroI = 2;
        int tetroJ = 1;
        int tetroL = 1;
        int tetro0 = 1;
        int tetroT = 2;
        int tetroS = 1;
        int tetroZ = 1;
        Piece[] piece = new Piece[NB_PIECE];

        for (int i=0; i<piece.length; i++) { 
            if (i<NB_DOMINO) piece[i] = new Domino();
            else if (i<NB_TRIOMINO+NB_DOMINO) piece[i] = new Triomino();
            else piece[i] = new Tetromino(); 
        }


        // affichage à l'écran
        Ecran.afficher("Saisisez votre pseudo: "+ ANSI_BLUE);
        String nameJoueur = Clavier.saisirString();
        Ecran.sautDeLigne();
        clearScreen();
        Ecran.afficherln(ANSI_RESET +"Bonjour " + ANSI_BLUE, nameJoueur, ANSI_RESET +", bienvenu sur notre jeu !");
        Ecran.afficherln("Vous allez jouer contre "+ ANSI_RED, IA_NAME, ANSI_RESET+", notre IA.");
        Ecran.sautDeLigne();

        Ecran.afficherln("Voici la grille de jeu:");
        Ecran.afficherln(grid.toString());
        Ecran.sautDeLigne();

        Ecran.afficherln(ANSI_BLUE, nameJoueur, ANSI_RESET +", vous disposez de ",NB_PIECE ," pièces, dont ", NB_DOMINO, " dominos(2cases), ", NB_TRIOMINO," triominos(3cases) posable en 2 positions, et de ", NB_TETROMINO, " tétrominos(4cases) posable en 7 positions."); 
        Ecran.afficherln(ANSI_RED, IA_NAME, ANSI_RESET+" possède les mêmes pièces que vous.");
        Ecran.sautDeLigne();

        Ecran.afficherln("Voici les différentes pièces dont vous disposez:");
        Ecran.afficher(d.toString(), t.toString(true), te.toString());
        Ecran.sautDeLigne();

        Ecran.afficher(ANSI_BLUE, nameJoueur, ANSI_RESET +", c'est à vous de commencer ! ");
        Ecran.afficherln("Il vous reste ", NB_DOMINO, " dominos, ", NB_TRIOMINO," triominos et ", NB_TETROMINO, " tétrominos.");
        Ecran.afficher("Vous désirez poser quelle pièce ? Entrez le numéro de la pièce: ");
        int pieceChoisi = Clavier.saisirInt();
        // vérification de la saisie
        while(pieceChoisi<1 || pieceChoisi>3 || (NB_DOMINO==0 && pieceChoisi==1) || (NB_TRIOMINO==0 && pieceChoisi==2) || (NB_TETROMINO==0 && pieceChoisi==3)){
            Ecran.afficherln(YELLOW_BG+"/!\\ ", nameJoueur, ", vous vous êtes trompé dans votre saisie ! Recommencer. /!\\"+RESET_BG);
            Ecran.afficher("Vous désirez poser quelle pièce ? Entrez le numéro de la pièce: ");
            pieceChoisi = Clavier.saisirInt();
        }

        clearScreen();
        int pieceSelected = 0;
        Ecran.afficherln("Voici les dispositions possibles pour cette pièce:");
        switch(pieceChoisi){
            case 1:
                Ecran.afficher(displayPieces(piece, Type.Domino));
            break;
            case 2:
                Ecran.afficher(displayPieces(piece, Type.Triomino));
                pieceSelected = 3;
            break;
            case 3:
                Ecran.afficher(displayPieces(piece, Type.Tetromino));
                pieceSelected = 9;
            break;
            default:
                Ecran.afficher("Erreur dans le choix");
        }
        Ecran.sautDeLigne();

        Ecran.afficher(ANSI_BLUE, nameJoueur, ANSI_RESET + ", vous désirez poser la pièce choisie dans quelle disposition ? Entrez le numéro de la pièce: ");
        int pieceDisposition = Clavier.saisirInt();
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

        clearScreen();
        Ecran.afficherln(grid.toString());
        Ecran.afficher(ANSI_BLUE, nameJoueur, ANSI_RESET +", vous désirez poser la pièce choisie à quel endroit ? Entrez la lettre de la colonne puis le numéro de la ligne: ");
        String positionPiecePlace = Clavier.saisirString();
        int placeColonne = (int) positionPiecePlace.charAt(0) - 'A';
        int placeLigne = Character.getNumericValue(positionPiecePlace.charAt(1));

        if (grid.isPiecePlaceable(piece[pieceSelected], orientationChoisie, new Position(placeColonne, placeLigne))){
            grid.placePiece(piece[pieceSelected], orientationChoisie, new Position(placeColonne, placeLigne));
        }

        clearScreen();
        Ecran.afficherln(grid.toString());
    }



    /**
     * fonction permettant de nettoyer le terminal (utile pour avoir une présentation propre du jeu)
     */
    public static void clearScreen() {
        for(int i=0; i<10; i++){
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } 
    }


    public static String displayPieces(Piece[] arr) { 
        String res = "";
        for (Piece p: arr) { 
            if (p != null) { 
                res += p.toString() + "\t";
            }
        }
        return res;
    }

    public static boolean isLoose(Piece[] pieces, Grid grid) { 
        boolean res = true;
        for (int i = 0; i<Grid.SIZE_Y; i++) { 
            for (int j=0; j<Grid.SIZE_Y; j++) { 
                Position origin = new Position(i, j);
                for (Piece p: pieces) { 
                    res &= !grid.isPiecePlaceableInAnyPosition(p, origin);
                }
            }
        }
        return res;
    }

    private static boolean isPieceOfType(Piece p, Type t) { 
        return (p instanceof Domino && t == Type.Domino) || 
            (p instanceof Triomino && t == Type.Triomino) ||
            (p instanceof Tetromino && t == Type.Tetromino);
    }

    public static String displayPieces(Piece[] arr, Type t) { 
        String res = "";
        for (Piece p: arr) { 
            if (p!=null && isPieceOfType(p, t)){
                res += p.toString() + "\t";
            }
        }
        return res;
    }
}