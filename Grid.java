/* Gaspard QUENTIN & Antoine CUINET
 *
 * Mini-projet APOO
 * 
 * groupe TP I2-CMI
 * Université de Franche-Comte UFR-ST 
 *
 * Année universitaire 2022/2023
 *
 * Grid.java
*/

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

    public Case getCaseAt(Position p) { 
        if (isInGrid(p)){ 
            return this.grid[9-p.getY()][p.getX()];
        }
        return null;
    }

    /**
     * Méthode vérifiant si une position se trouve sur la grille.
     * @param p une Position 
     * @return vrai si la position est sur la grille, faux sinon.
    */
    public boolean isInGrid(Position p) { 
        return (p.getX() >= 0 && p.getX() < SIZE_X) &&
            (p.getY() >= 0 && p.getY() < SIZE_Y);
    }

    /**
     * Méthode vérifiant si une pièce orientée placée à partir d'un point est sur la grille.
     * @param p la pièce
     * @param o l'orientation de la pièce
     * @param origin le point à partir duquel on souhaite poser la pièce
     * @return vrai si la pièce est posable (elle est dans la grille), faux sinon.
    */
    public boolean isInGrid(Piece p, Position.Orientation o, Position origin) { 
        boolean res = true;
        for (Position it: p.getPositions(o)) { 
            it.add(origin);
            res &= isInGrid(it);
        }
        return res;
    }


    /**
     * Méthode placeant une pièce sur la grille.
     * /!\ La saisie est supposée valide /!\
     * @param p une pièce (supposée posable)
     * @param o l'orientation de la pièce
     * @param origin le point à partir duquel on souhaite poser la pièce
    */
    public void placePiece(Piece p, Position.Orientation o, Position origin) { 
        for (Position it: p.getPositions(o)) { 
            it.add(origin);
            getCaseAt(it).setPiece(p);
            getCaseAt(it).setIsComputer(p.isComputer());
        }
    }

    /**
     * Méthode vérifiant si une pièce que l'on souhaite poser (à partir d'un point et avec une orientation)
     * est placeable, i.e. si la pièce est dans la grille et qu'une pièce n'est pas déjà posée.
     * @param p
     * @param o
     * @param origin
     * @return
    */
    public boolean isPiecePlaceable(Piece p, Position.Orientation o, Position origin) { 
        if (!isInGrid(p, o, origin)) return false;
        for (Position it: p.getPositions(o)) { 
            it.add(origin);
            if (getCaseAt(it).getPiece() != null) return false;
        }
        return true;
    }

    public boolean isPiecePlaceableInAnyPosition(Piece p, Position origin) { 
        return isPiecePlaceable(p, Position.Orientation.EAST, origin) ||
            isPiecePlaceable(p, Position.Orientation.NORTH, origin) ||
            isPiecePlaceable(p, Position.Orientation.SOUTH, origin) || 
            isPiecePlaceable(p, Position.Orientation.WEST, origin);
    }

    /**
     * affichage des pièces sur la grille: (O) pour le joueur et (#) pour l'ordinateur
     * 
     * @param grid        grille
     * @param canSeeBoats voir le bateau au point toucher
    */ 
     public String toString() {
        String res = "";
        int k = 9;
        for (int i = 0; i <grid.length; i++) {
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
