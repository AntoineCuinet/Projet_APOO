public class Main { 
    
    public static void main(String[] args) { 
        displayGrid();
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