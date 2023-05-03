public class Main { 
    // déclaration des couleurs (pour la créativité)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String YELLOW_BG = "\u001B[43m";
    public static final String BLUE_BG = "\u001B[44m";
    public static final String BLACK_BG = "\u001B[40m";

    public static final String IA_NAME = "Yumi";
    private static boolean isWin = false;
    private static boolean isLoose = false;

    public static void main(String[] args) { 
        Grid grid = new Grid();

        // affichage à l'écran
        Ecran.afficherln("Saisisez votre pseudo: ");
        String nameJoueur = Clavier.saisirString();
        Ecran.afficherln("Bonjour " + ANSI_BLUE, nameJoueur, ANSI_RESET +", bienvenu sur notre jeu !");
        Ecran.afficherln("Vous allez jouer contre "+ ANSI_RED, IA_NAME, ANSI_RESET+" (l'ordinateur).");

        Ecran.afficherln(grid.toString());

        Ecran.afficherln("Voici les pièces dont vous disposez:");
        // faire l'affichage de toutes les pieces possibles (appel à toString)
        Ecran.afficherln("Vous désirez poser quelle pièce ? (entrez le numéro de la pièce)");
        int pieceCoisi = Clavier.saisirInt();
        Ecran.afficherln("Vous désirez poser la pièce choisie dans quelle disposition ? (entrez le numéro de la pièce)");
        // faire l'affichage de la piece selectionner dans toutes les dispositions (appel à toString)
        int pieceDisposition = Clavier.saisirInt();
        Ecran.afficherln("Vous désirez poser la pièce choisie à quel endroit ? (entrez la lettre de la colonne puis le numéro de la ligne)");
        String positionPiecePlace = Clavier.saisirString();
        // transformer la chaine en position
    }
}
