public class Main { 
    // déclaration des couleurs utilisées pour l'affichage (pour la créativité)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) { 
        // déclaration des variables 
        Case [][] Grid = new Case[10][12];
        for(int i = 0; i<Grid.length; i++){
            for(int j = 0; j<Grid[0].length; j++){
                Grid[i][j] = new Case(null, false);
            }
        }
        String nameOrdi = "Yumi";
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

        /////////////////////////////////////////////////////////////////////////////////////
        // transformer la chaine en position

        displayGrid(Grid); // l'afficher avec la pièce posée
    }

    /**
     * fonction permettant de nettoyer le teminal (utile pour avoir une présentation propore du jeu)
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



        // AFFICHAGE DE LA GRILLE

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