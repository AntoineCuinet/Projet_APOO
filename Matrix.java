/* Gaspard QUENTIN & Antoine CUINET
 *
 * Mini-projet APOO
 * 
 * groupe TP I2-CMI
 * Université de Franche-Comte UFR-ST 
 *
 * Année universitaire 2022/2023
 *
 * Matrix.java
*/

public class Matrix { 
    
    public int[][] matrix;
    private int[] type;

    /**
     * constructeur d'une matrice
     * @param m
    */
    public Matrix(int[][] m) { 
        this.matrix = m;
        this.type = new int[2];
        type[0] = m.length;
        if (m.length != 0) type[1] = m[0].length;
        else type[1] = 0;
    }

    /**
     * Constructeur d'une matrice représentant une position.
     * @param p
    */
    public Matrix(Position p) { 
        this(new int[][]{{p.getX(), p.getY()}});
    }

    /**
     * getter du type de la matrice (couple d'entiers représentant la taille (m,p) )
     * @return
    */
    public int[] getType() { 
        return type;
    }

    /**
     * Renvoie la matrice de rotation qui permet de tourner une vecteur de 
     * coordonnées (x, y) en fonction de l'orientation souhaitée.
     *
     * Ces matrices de rotation on été calculées à l'aide de la formule suivante :
     *
     *                             ( cos a  - sin a )
     *                             ( sin a    cos a )
     *
     * avec a prenant les valeurs respectives de pi/2, pi et -pi/2
     *
     * @param o une orientation (typé énuméré Position.Orientation)
     * @return la matrice de rotation convenant à l'orientation souhaitée
    */
    public static Matrix getRotationalMatrix(Position.Orientation o) { 
        switch(o) { 
            case EAST: return new Matrix(new int[][]{{1, 0}, {0, 1}});
            case NORTH: return new Matrix(new int[][]{{0, 1}, {-1, 0}});
            case WEST: return new Matrix(new int[][]{{-1, 0}, {0, -1}});
            default: return new Matrix(new int[][] {{0, -1}, {1, 0}});
        }
    }

    
    /**
     * Cette méthode tourne chaque Position représentant la pièce dans la grille 
     * en fonction d'une orientation choisie.
     * @param piece le tableau de positions représentant la pièce
     * @param o l'orientation souhaitée
     * @return le tableau de positions avec chaque coordonnées tournées dans la bonne direction
    */
    public static Position[] rotate(Position[] piece, Position.Orientation o) { 
        Position[] arr = new Position[piece.length];
        Matrix mat = getRotationalMatrix(o);
        for (int i = 0; i<piece.length; i++) { 
            arr[i] = matrixProduct(new Matrix(piece[i]), mat).matrix2ToPosition();
        }
        return arr;
    }

    /**
     * Fonction réalisant un produit matriciel 
     * @param m1 une matrice (doit être de type (n, p) )
     * @param m2 une matrice (doit être de type (p, k))
     * @return une matrice résultante du produit de m1 et m2 (de type (n, k) )
    */
    public static Matrix matrixProduct(Matrix m1, Matrix m2) { 
        assert m1.getType()[1] == m2.getType()[0];
        Matrix res = new Matrix(new int[m1.getType()[0]][m2.getType()[1]]);
        for (int i = 0; i<res.getType()[0]; i++) { 
            for (int j = 0; j < res.getType()[1]; j++) {
                int s = 0;
                for (int k = 0; k<m1.getType()[1]; k++) { 
                    s += m1.matrix[i][k] * m2.matrix[k][j];
                }
                res.matrix[i][j] = s;
            }
        }
        return res;
    }

    /**
     * Méthode transformant une matrice ligne de longueur 2 en une position.
     * @return la position correspondant aux coordonnées contenues dans la matrice
    */
    public Position matrix2ToPosition() {
        assert matrix[0].length == 2;
        return new Position(matrix[0][0], matrix[0][1]);
    }

}
