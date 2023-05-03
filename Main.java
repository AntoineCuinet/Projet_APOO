public class Main { 
    // déclaration des couleurs utilisées pour l'affichage (pour la créativité)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static final String IA_NAME = "Yumi";
    private static boolean isWin = false;
    private static boolean isLoose = false;

    public static void main(String[] args) { 
        Grid grid = new Grid();
        Domino d = new Domino();
        Triomino t = new Triomino();
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
        Ecran.afficherln("Vous allez jouer contre "+ ANSI_RED, IA_NAME, ANSI_RESET+", notre IA.");
        Ecran.sautDeLigne();

        Ecran.afficherln("Voici la grille de jeu:");
        Ecran.afficherln(grid.toString());
        Ecran.sautDeLigne();

        Ecran.afficherln(ANSI_BLUE, nameJoueur, ANSI_RESET +", vous disposez de ",nbPiece ," pièces, dont ", nbDomino, " dominos(2cases), ", nbTriomino," triominos(3cases) et de ", nbTetromino, " tétrominos(4cases)."); 
        Ecran.afficherln(ANSI_RED, IA_NAME, ANSI_RESET+" possède les mêmes pièces que vous.");
        Ecran.sautDeLigne();

        Ecran.afficherln("Voici les différentes pièces dont vous disposez:");
        Ecran.afficher(d.toString(), t.toString());
        Ecran.sautDeLigne();

        Ecran.afficher(ANSI_BLUE, nameJoueur, ANSI_RESET +", c'est à vous de commencer ! ");
        Ecran.afficher("Vous désirez poser quelle pièce ? (entrez le numéro de la pièce)  ");
        int pieceCoisi = Clavier.saisirInt();
        Ecran.afficherln("Voici les dispositions possibles pour cette pièce:");
        switch(pieceCoisi){
            case 1:
                Ecran.afficher(d.toString(true));
            break;
            case 2:
                Ecran.afficher(t.toString(true));
            break;
            default:
            Ecran.afficher("Erreur dans le choix");
        }
        Ecran.sautDeLigne();

        Ecran.afficher(ANSI_BLUE, nameJoueur, ANSI_RESET + ", vous désirez poser la pièce choisie dans quelle disposition ? (entrez le numéro de la pièce)  ");
        int pieceDisposition = Clavier.saisirInt();
        Ecran.afficher(ANSI_BLUE, nameJoueur, ANSI_RESET +", vous désirez poser la pièce choisie à quel endroit ? (entrez la lettre de la colonne puis le numéro de la ligne)  ");
        String positionPiecePlace = Clavier.saisirString();
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
}