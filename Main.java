public class Main { 
    // déclaration des couleurs utilisées pour l'affichage (pour la créativité)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static final String IA_NAME = "Yumi";
    private static boolean isWin = false;
    private static boolean isLoose = false;

    public static void main(String[] args) { 

        Grid grid = new Grid();

        int nbPiece = 18;
        int nbDomino = 3;
        int nbTriomino = 6;
        int nbTetromino = 9;


        // affichage à l'écran
        Ecran.afficher("Saisisez votre pseudo: ");
        String nameJoueur = Clavier.saisirString();
        Ecran.sautDeLigne();
        clearScreen();
        Ecran.afficherln("Bonjour " + ANSI_BLUE, nameJoueur, ANSI_RESET +", bienvenu sur notre jeu !");

        Ecran.afficherln("Vous allez jouer contre "+ ANSI_RED, IA_NAME, ANSI_RESET+" (l'ordinateur).");

        Ecran.afficherln(grid.toString());

        Ecran.afficherln("Voici les pièces dont vous disposez:");

        Ecran.afficherln("Vous allez jouer contre "+ ANSI_RED, nameOrdi, ANSI_RESET+", notre IA.");
        Ecran.sautDeLigne();

        Ecran.afficherln("Voici la grille de jeu:");
        displayGrid(Grid);
        Ecran.sautDeLigne();

        Ecran.afficherln(ANSI_BLUE, nameJoueur, ANSI_RESET +", vous disposez de ",nbPiece ," pièces, dont ", nbDomino, " dominos(2cases), ", nbTriomino," triominos(3cases) et de ", nbTetromino, " tétrominos(4cases)."); 
        Ecran.afficherln(ANSI_RED, nameOrdi, ANSI_RESET+" possède les mêmes pièces que vous.");
        Ecran.afficherln("Voici les différentes pièces dont vous disposez:");
        /////////////////////////////////////////////////////////////////////////////////////

        // faire l'affichage de toutes les pieces possibles (appel à toString)

        Ecran.sautDeLigne();
        Ecran.afficher(ANSI_BLUE, nameJoueur, ANSI_RESET +", c'est à vous de commencer ! ");
        Ecran.afficher("Vous désirez poser quelle pièce ? (entrez le numéro de la pièce)");
        int pieceCoisi = Clavier.saisirInt();

        Ecran.afficherln("Voici les dispositions possibles pour cette pièce:");
        /////////////////////////////////////////////////////////////////////////////////////
        // faire l'affichage de la piece selectionner dans toutes les dispositions (appel à toString)

        Ecran.sautDeLigne();
        Ecran.afficher(ANSI_BLUE, nameJoueur, ANSI_RESET + ", vous désirez poser la pièce choisie dans quelle disposition ? (entrez le numéro de la pièce)");

        int pieceDisposition = Clavier.saisirInt();
        Ecran.afficher(ANSI_BLUE, nameJoueur, ANSI_RESET +", vous désirez poser la pièce choisie à quel endroit ? (entrez la lettre de la colonne puis le numéro de la ligne)");
        String positionPiecePlace = Clavier.saisirString();

    }
}
