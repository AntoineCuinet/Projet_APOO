

public class Matrix { 
    
    public int[][] matrix;
    private int[] type;

    public Matrix(int[][] m) { 
        this.matrix = m;
        this.type = new int[2];
        type[0] = m.length;
        if (m.length != 0) type[1] = m[0].length;
        else type[1] = 0;
    }

    public Matrix(Position p) { 
        this(new int[][]{{p.getX(), p.getY()}});
    }

    public int[] getType() { 
        return type;
    }

    public static Matrix getRotationalMatrix(Position.Orientation o) { 
        switch(o) { 
            case EAST: return new Matrix(new int[][]{{1, 0}, {0, 1}});
            case NORTH: return new Matrix(new int[][]{{0, 1}, {-1, 0}});
            case WEST: return new Matrix(new int[][]{{-1, 0}, {0, -1}});
            default: return new Matrix(new int[][] {{0, -1}, {1, 0}});
        }
    }

    public static Position[] rotate(Position[] piece, Position.Orientation o) { 
        Position[] arr = new Position[piece.length];
        Matrix mat = getRotationalMatrix(o);
        for (int i = 0; i<piece.length; i++) { 
            arr[i] = matrixProduct(new Matrix(piece[i]), mat).matrix2ToPosition();
        }
        return arr;
    }

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

    public Position matrix2ToPosition() {
        assert matrix[0].length == 2;
        return new Position(matrix[0][0], matrix[0][1]);
    }

}
