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

    public static String Player_Name = "";
    private static boolean isWin = false;
    private static boolean isLoose = false;

    // Déclaration des constantes
    private static final int NB_PIECE = 18;
    private static final int NB_DOMINO = 3;
    private static final int NB_TRIOMINO = 6;
    private static final int NB_TETROMINO = 9;

    public static final int TRIO_I = 3;
    public static final int TRIO_T = 3;
    public static final int TETRO_I = 2; 
    public static final int TETRO_J = 1;
    public static final int TETRO_L = 1;
    public static final int TETRO_0 = 1;
    public static final int TETRO_T = 2;
    public static final int TETRO_S = 1;
    public static final int TETRO_Z = 1;

    // Déclaration des variables
    private static int trioI = 0;
    private static int trioT = 0;
    private static int tetroI = 0;
    private static int tetroJ = 0;
    private static int tetroL = 0;
    private static int tetro0 = 0;
    private static int tetroT = 0;
    private static int tetroS = 0;
    private static int tetroZ = 0;

    private static int pieceChoisi = 0;
    private static int formePieceChoisi = 0;
    private static int pieceSelected = 0;
    private static int pieceDisposition = 0;

    public enum Type {Domino, Triomino, Tetromino};


    // Main
    public static void main(String[] args) { 
        Grid grid = new Grid();
        Domino d = new Domino();
        Triomino t = new Triomino();
        Tetromino te = new Tetromino();
        Computer c = new Computer(grid);

        // Initialisation tableau de pièces
        Piece[] piece = new Piece[NB_PIECE];
        for (int i=0; i<piece.length; i++) { 
            if (i<NB_DOMINO) piece[i] = new Domino();
            else if (i<NB_TRIOMINO+NB_DOMINO) piece[i] = new Triomino();
            else piece[i] = new Tetromino(); 
        }

        // affichage début du jeu 
        beginDisplay(grid);
        // boucle de jeu 
        while(!isWin || !isLoose){
            isLoose(piece, grid);
            // affichage à l'écran du tour du joueur
            choicePiecePlayer(grid, d, t, te, piece);
            clearScreen();
            Ecran.afficherln(grid.toString());
            c.choicePieceComputer(grid);
            Ecran.afficherln(grid.toString());
            // affichage à l'écran du tour de l'ordinateur
        } 
    }




    /**
     * Fonction qui affiche à l'écran le début du jeu
     * @param grid
     */
    public static void beginDisplay(Grid grid){
        clearScreen();
        Ecran.afficher("Saisisez votre pseudo: "+ ANSI_BLUE);
        Player_Name += Clavier.saisirString();
        Ecran.sautDeLigne();
        clearScreen();
        Ecran.afficherln(ANSI_RESET +"Bonjour " + nomJoueur() +", bienvenu sur notre jeu !");
        Ecran.afficherln("Vous allez jouer contre "+ Computer.IA_NAME +", notre IA.");
        Ecran.sautDeLigne();

        Ecran.afficherln(nomJoueur() +", vous disposez de ",NB_PIECE ," pièces, dont ", NB_DOMINO, " dominos(2cases), ", NB_TRIOMINO," triominos(3cases) posable en 2 positions, et de ", NB_TETROMINO, " tétrominos(4cases) posable en 7 positions."); 
        Ecran.afficherln(Computer.IA_NAME +" possède les mêmes pièces que vous.");
        Ecran.sautDeLigne();

        Ecran.afficherln("Dans ce mode de jeu, vous allez jouer tour à tour contre "+ Computer.IA_NAME +" sur une grille de 12 cases par 10.\nLa première personne ne pouvant plus poser de pièce à perdue.");
        Ecran.sautDeLigne();
    }




    /**
     * Fonction permet d'afficher la saisie et le placement d'une pièce par la joueur
     * @param grid
     * @param d
     * @param t
     * @param te
     * @param piece
     */
    public static void choicePiecePlayer(Grid grid, Domino d, Triomino t, Tetromino te, Piece[] piece){
        choixTypePiece(grid, d, t, te, piece);
        choixFormePiece(grid, d, t, te, piece);
        choixOrientationPiece(grid, d, t, te, piece);
        positionnementPieceChoisi(grid, d, t, te, piece);
    }



    /**
     * Fonction qui permet au joueur de choisir le type de pièce qu'il souhaite poser
     * @param grid
     * @param d
     * @param t
     * @param te
     * @param piece
     */
    public static void choixTypePiece(Grid grid, Domino d, Triomino t, Tetromino te, Piece[] piece){
        Ecran.afficherln("Voici les différentes pièces dont vous disposez:");
        Ecran.afficher(d.toString(true), t.toString(true), te.toString(true));
        Ecran.sautDeLigne();

        Ecran.afficher(nomJoueur() +", c'est à vous de jouer ! ");
        Ecran.afficherln("Il vous reste ", NB_DOMINO, " dominos, ", NB_TRIOMINO," triominos et ", NB_TETROMINO, " tétrominos.");
        Ecran.afficher("Vous désirez poser quelle pièce ? Entrez le numéro de la pièce: ");
        pieceChoisi = Clavier.saisirInt();
        // vérification de la saisie
        while(pieceChoisi<1 || pieceChoisi>3 || (NB_DOMINO==0 && pieceChoisi==1) || (NB_TRIOMINO==0 && pieceChoisi==2) || (NB_TETROMINO==0 && pieceChoisi==3)){
            Ecran.afficherln(YELLOW_BG+"/!\\ " + Player_Name + ", vous vous êtes trompé dans votre saisie ! Recommencer. /!\\"+RESET_BG);
            Ecran.afficher("Vous désirez poser quelle pièce ? Entrez le numéro de la pièce: ");
            pieceChoisi = Clavier.saisirInt();
        }
    }


    /**
     * Fonction qui permet au joueur de choisir la forme de la pièce qu'il souhaite poser
     * @param grid
     * @param d
     * @param t
     * @param te
     * @param piece
     */
    public static void choixFormePiece(Grid grid, Domino d, Triomino t, Tetromino te, Piece[] piece){
        // choix de la forme à faire 
        // pas de choix si domino
        // choix entre 2 formes si triomino
        // choix entre 7 formes si tetromino
        clearScreen();
        if(pieceChoisi == 3){
            Ecran.afficher(te.toString()); // afficher les 7 formes de tetromino
            Ecran.sautDeLigne();
            Ecran.afficher("Choisisez l'une des 7 formes que vous souhaitez poser. Il vous reste "+ tetroI +" Tetromino(s) de forme I, "+ tetroT +" Tetromino(s) de forme T, "+ tetro0 +" Tetromino(s) de forme 0, "+ tetroJ +" Tetromino(s) de forme J, "+ tetroL +" Tetromino(s) de forme L, "+ tetroS +" Tetromino(s) de forme S, "+ tetroZ +" Tetromino(s) de forme Z.\nEntrez le numéro de la pièce: ");
            formePieceChoisi = Clavier.saisirInt();
            // vérification de la saisie
            while(formePieceChoisi<1 || formePieceChoisi>7 || (tetroI==TETRO_I && formePieceChoisi==1) || (tetroT==TETRO_T && formePieceChoisi==2) || (tetro0==TETRO_0 && formePieceChoisi==3) || (tetroJ==TETRO_J && formePieceChoisi==4) || (tetroL==TETRO_L && formePieceChoisi==5) || (tetroS==TETRO_S && formePieceChoisi==6) || (tetroZ==TETRO_Z && formePieceChoisi==7)){
                Ecran.afficherln(YELLOW_BG+"/!\\ " + Player_Name + ", vous vous êtes trompé dans votre saisie ! Recommencer. /!\\"+RESET_BG);
                Ecran.afficher("Choisisez l'une des 7 formes que vous souhaitez poser. Il vous reste "+ Integer.toString( TETRO_I-tetroI )+" Tetromino(s) de forme I, "+ Integer.toString( TETRO_T - tetroT )+" Tetromino(s) de forme T, "+Integer.toString( TETRO_0 - tetro0 )+" Tetromino(s) de forme 0, "+ Integer.toString( TETRO_J - tetroJ )+" Tetromino(s) de forme J, "+Integer.toString( TETRO_L - tetroL )+" Tetromino(s) de forme L, "+ Integer.toString( TETRO_S - tetroS ) +" Tetromino(s) de forme S, "+Integer.toString( TETRO_Z-tetroZ )+" Tetromino(s) de forme Z.\nEntrez le numéro de la pièce: ");
                formePieceChoisi = Clavier.saisirInt();
            }
        } else if(pieceChoisi == 2){
            Ecran.afficher(t.toString()); // afficher les 2 forme de triomino 
            Ecran.sautDeLigne();
            Ecran.afficher("Choisisez l'une des 2 formes que vous souhaitez poser. Il vous reste "+ trioI +" Triomino(s) de forme I et "+ trioT +" Triomino(s) de forme T.\nEntrez le numéro de la pièce: ");
            formePieceChoisi = Clavier.saisirInt();
            // vérification de la saisie
            while(formePieceChoisi<1 || formePieceChoisi>2 || (trioI==TRIO_I && formePieceChoisi==1) || (trioT==TRIO_T && formePieceChoisi==2)){
                Ecran.afficherln(YELLOW_BG+"/!\\ " + Player_Name + ", vous vous êtes trompé dans votre saisie ! Recommencer. /!\\"+RESET_BG);
                Ecran.afficher("Choisisez l'une des 2 formes que vous souhaitez poser. Il vous reste "+ Integer.toString(TRIO_I-trioI) +" Triomino(s) de forme I et "+Integer.toString(  TRIO_T - trioT) +" Triomino(s) de forme T.\nEntrez le numéro de la pièce: ");
                formePieceChoisi = Clavier.saisirInt();
            }
        }
    }

   
    /**
     * Fonction qui permet au joueur de choisir la disposition de la pièce qu'il souhaite poser
     * @param grid
     * @param d
     * @param t
     * @param te
     * @param piece
     */
    public static void choixOrientationPiece(Grid grid, Domino d, Triomino t, Tetromino te, Piece[] piece){
        clearScreen(); // choix dans l'orientation 
        Ecran.afficherln("Voici les dispositions possibles pour cette pièce:");
        switch(pieceChoisi){
            case 1:
               Ecran.afficher(d.toString(pieceSelected));
            break;
            case 2:
                switch(formePieceChoisi){
                    case 1:
                        //TODO: if (trioI == TRIO_I) recommencer la saisie
                        Ecran.afficher(t.toString(formePieceChoisi));
                        pieceSelected = NB_DOMINO + trioI;
                        trioI++;
                    break;
                    case 2:
                        Ecran.afficher(t.toString(formePieceChoisi));
                        pieceSelected = TRIO_I + NB_DOMINO + trioT;
                        trioT++;
                    break;
                }
            break;
            case 3:
                switch(formePieceChoisi){ 
                    case 1:
                        Ecran.afficher(te.toString(formePieceChoisi));
                        pieceSelected = NB_TRIOMINO + NB_DOMINO + tetroI;
                        tetroI++;
                    break;
                    case 2:
                        Ecran.afficher(te.toString(formePieceChoisi));
                        pieceSelected = NB_TRIOMINO + NB_DOMINO + TETRO_I + tetroJ;
                        tetroJ++;
                    break;
                    case 3:
                        Ecran.afficher(te.toString(formePieceChoisi));
                        pieceSelected = NB_TRIOMINO + NB_DOMINO + TETRO_I + TETRO_J + tetroL;
                        tetroL++;
                    break;
                    case 4:
                        Ecran.afficher(te.toString(formePieceChoisi));
                        pieceSelected = NB_TRIOMINO + NB_DOMINO + TETRO_I + TETRO_J + TETRO_L + tetroT;
                        tetroT++;
                    break;
                    case 5:
                        Ecran.afficher(te.toString(formePieceChoisi));
                        pieceSelected = NB_TRIOMINO + NB_DOMINO + TETRO_I + TETRO_J + TETRO_L + TETRO_T;
                        tetroT++;
                    break;
                    case 6:
                        Ecran.afficher(te.toString(formePieceChoisi));
                        pieceSelected = NB_TRIOMINO + NB_DOMINO + TETRO_I + TETRO_J + TETRO_L + TETRO_T + tetroS;
                        tetroS++;
                    break;
                    case 7:
                        Ecran.afficher(te.toString(formePieceChoisi));
                        pieceSelected = NB_TRIOMINO + NB_DOMINO + TETRO_I + TETRO_J + TETRO_L + TETRO_T + TETRO_S + tetro0;
                        tetro0++;
                    break;
                }
            break;
            default:
                Ecran.afficher("Erreur dans le choix");
        }
        Ecran.sautDeLigne();

        Ecran.afficher(nomJoueur() + ", vous désirez poser la pièce choisie dans quelle disposition ? Entrez le numéro de la pièce: ");
        pieceDisposition = Clavier.saisirInt();
        // Vérification de saisie
        while((pieceDisposition<1 || pieceDisposition>2 && pieceChoisi ==1)|| ((pieceDisposition<1 || pieceDisposition>4) && pieceChoisi !=1)){
            Ecran.afficherln(YELLOW_BG+"/!\\ " + Player_Name + ", vous vous êtes trompé dans votre saisie ! Recommencer. /!\\"+RESET_BG);
            Ecran.afficher("Choisisez l'une des 2 formes que vous souhaitez poser. Il vous reste "+ trioI +" Triomino(s) de forme I et "+ trioT +" Triomino(s) de forme T.\nEntrez le numéro de la pièce: ");
            pieceDisposition = Clavier.saisirInt();
        }

    }


    /**
     * Fonction qui permet de gérer l'orientation de la pièce ainsi que de la poser dans la grille
     * @param grid
     * @param d
     * @param t
     * @param te
     * @param piece
     */
    public static void positionnementPieceChoisi(Grid grid, Domino d, Triomino t, Tetromino te, Piece[] piece){
        Position.Orientation orientationChoisie;
        switch(pieceDisposition){
            case 1:
                orientationChoisie = Position.Orientation.EAST;
            break;
            case 2:
                orientationChoisie = Position.Orientation.NORTH;
            break;
            case 3:
                orientationChoisie = Position.Orientation.WEST;
            break;
            default:
                orientationChoisie = Position.Orientation.SOUTH;
        }

        clearScreen();
        Ecran.afficherln("Voici la grille de jeu: ");
        Ecran.afficherln(grid.toString());
        Ecran.afficher(nomJoueur() +", vous désirez poser la pièce choisie à quel endroit ? Entrez la lettre de la colonne puis le numéro de la ligne: ");
        String positionPiecePlace = Clavier.saisirString();
        int placeColonne = (int) positionPiecePlace.charAt(0) - 'A';
        int placeLigne = Character.getNumericValue(positionPiecePlace.charAt(1));

        
        while (!grid.isPiecePlaceable(piece[pieceSelected], orientationChoisie, new Position(placeColonne, placeLigne))){
            clearScreen();
            Ecran.afficherln(YELLOW_BG+"/!\\ " + Player_Name + ", vous vous êtes trompé dans votre saisie ! Recommencer. /!\\"+RESET_BG);
            Ecran.afficherln("Voici la grille de jeu: ");
            Ecran.afficherln(grid.toString());
            Ecran.afficher(nomJoueur() +", vous désirez poser la pièce choisie à quel endroit ? Entrez la lettre de la colonne puis le numéro de la ligne: ");
            positionPiecePlace = Clavier.saisirString();
            placeColonne = (int) positionPiecePlace.charAt(0) - 'A';
            placeLigne = Character.getNumericValue(positionPiecePlace.charAt(1));
        } 
        grid.placePiece(piece[pieceSelected], orientationChoisie, new Position(placeColonne, placeLigne));
        
        System.out.println(pieceSelected);
        System.out.println(piece[pieceSelected].type);
    
        pieceChoisi = 0;
        formePieceChoisi = 0;
        pieceSelected = 0;
    
    }




    /**
     * Fonction qui créer le nom du joueur
     * @return
     */
    public static String nomJoueur(){
        return ANSI_BLUE + Player_Name + ANSI_RESET;
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

    public static String displayPieces(Piece[] arr, Type t) { 
        String res = "";
        for (int i=0; i<arr.length; i++) { 
            if (arr[i]!=null && isPieceOfType(arr[i], t)){
                res += arr[i].toString(i) + "\t";
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
}
