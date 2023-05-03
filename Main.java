public class Main { 
    
    public static void main(String[] args) { 
        displayGrid();
        Ecran.afficherln("Voici les pièces dont vous disposez:");
        // faire l'affichage de toutes les pieces possibles (appel à toString)
        Ecran.afficherln("Vous désirez poser quelle pièce ? (entrez le numéro de la pièce)");
        int pieceCoisi = Clavier.saisirInt();
        Ecran.afficherln("Vous désirez poser la pièce choisie dans quelle disposition ? (entrez le numéro de la pièce)");
        // faire l'affichage de la piece selectionner dans toutes les dispositions (appel à toString)
        int pieceDisposition = Clavier.saisirInt();
        Ecran.afficherln("Vous désirez poser la pièce choisie à quel endroit ? (entrez la lettre de la colonne puis le numéro de la ligne)");
        char positionPiecePlace = Clavier.saisirChar();
        // transformer la chaine en position
        displayGrid(); // l'afficher avec la pièce posée
    }




        // AFFICHAGES


    /**
     * affichage des pièces sur la grille: (O) pour le joueur et (#) pour l'ordinateur
     * 
     * @param grid        grille
     * @param canSeeBoats voir le bateau au point toucher
     */
    static void displayGrid() {
        char pj = 'O';
        char po = '#';
        char v = '.';
        String res = "";
        int nbLigne = 0;
        int k = 9;
        for (int i = 0; i <= 9; i++) {
            nbLigne += i;
            res += "   +--- --- --- --- --- --- --- --- --- --- --- ---+ \n";
            res += " " + k + " |";
            k -= 1;
            for (int j = 0; j <= 11; j++) {
            //  if () //joueur pose une case
            //      res += " " + pj +" |";
            //  else if () //ordinateur pose une case
            //      res += " " + po +" |"; 
            //  else //pas de case de poser pose une case
                    res += " " + v +" |";
            }
            res += "\n";
        }
        res += "   +--- --- --- --- --- --- --- --- --- --- --- ---+ \n";
        res += "     A   B   C   D   E   F   G   H   I   J   K   L   \n";
        Ecran.afficher(res);
    }
}