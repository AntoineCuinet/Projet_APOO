public class Main { 
    // déclaration des couleurs (pour la créativité)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String YELLOW_BG = "\u001B[43m";
    public static final String BLUE_BG = "\u001B[44m";
    public static final String BLACK_BG = "\u001B[40m";

    public static void main(String[] args) { 
        // déclaration des variables 
        Case [][] Grid = new Case[10][12];
        for(int i = 0; i<Grid.length; i++){
            for(int j = 0; j<Grid[0].length; j++){
                Grid[i][j] = new Case(null, false);
            }
        }
        String nameOrdi = "Yumi";
        

        // affichage à l'écran
        Ecran.afficherln("Saisisez votre pseudo: ");
        String nameJoueur = Clavier.saisirString();
        Ecran.afficherln("Bonjour " + ANSI_BLUE, nameJoueur, ANSI_RESET +", bienvenu sur notre jeu !");
        Ecran.afficherln("Vous allez jouer contre "+ ANSI_RED, nameOrdi, ANSI_RESET+" (l'ordinateur).");

        displayGrid(Grid);
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
        displayGrid(Grid); // l'afficher avec la pièce posée
    }



        // AFFICHAGES


    /**
     * affichage des pièces sur la grille: (O) pour le joueur et (#) pour l'ordinateur
     * 
     * @param grid        grille
     * @param canSeeBoats voir le bateau au point toucher
     */
    static void displayGrid(Case [][] Grid) {
        String res = "";
        int nbLigne = 0;
        int k = 9;
        for (int i = 0; i <Grid.length; i++) {
            nbLigne += i;
            res += "   +--- --- --- --- --- --- --- --- --- --- --- ---+\n";
            res += " " + k + " |";
            k -= 1;
            for (int j = 0; j <Grid[0].length; j++) {
                res += Grid [i][j]. toString(); //  res += " . |";
                res += "|";
            }
            res += "\n";
        }
        res += "   +--- --- --- --- --- --- --- --- --- --- --- ---+\n";
        res += "     A   B   C   D   E   F   G   H   I   J   K   L  \n";
        Ecran.afficher(res);
    }
}