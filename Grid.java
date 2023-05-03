public class Grid { 
    
    final static int SIZE_X = 12;
    final static int SIZE_Y = 10;
    
    private Case[][] grid;

    public Grid() { 
        this.grid = new Case[SIZE_Y][SIZE_X];
        for (int i=0; i<this.grid.length; i++) {
            for (int j=0; j<this.grid[0].length; j++) {
                this.grid[i][j] = new Case();
            }
        }
    }

    /**
     * affichage des pièces sur la grille: (O) pour le joueur et (#) pour l'ordinateur
     * 
     * @param grid        grille
     * @param canSeeBoats voir le bateau au point toucher
    */ 
     public String toString() {
        String res = "";
        int nbLigne = 0;
        int k = 9;
        for (int i = 0; i <grid.length; i++) {
            nbLigne += i;
            res += "   +--- --- --- --- --- --- --- --- --- --- --- ---+\n";
            res += " " + k + " |";
            k -= 1;
            for (int j = 0; j <grid[0].length; j++) {
                res += grid[i][j].toString(); //  res += " . |";
                res += "|";
            }
            res += "\n";
        }
        res += "   +--- --- --- --- --- --- --- --- --- --- --- ---+\n";
        res += "     A   B   C   D   E   F   G   H   I   J   K   L  \n";
        return res;
    }
}

