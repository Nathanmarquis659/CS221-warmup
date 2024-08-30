import java.io.*;
import java.util.*;

/** 
 * Makes MagicSquare objects that can create or check for valid magic squares.
 * 
 * @author Nathan Marquis and Mason Vail
 */

public class MagicSquare implements MagicSquareInterface{
    private boolean isMagic;
    private int[][] magicSquareArray;

    /**
     * First constructor only takes a filename to read from, creating an array and checking if valid magic square
     * 
     * @param filename takes a filename to read from and create a magicSquareArray
     * @throws FileNotFoundException 
     * 
     */
    public MagicSquare(String filename) throws FileNotFoundException {
        this.readMatrix(filename);
        this.isMagic = this.isMagicSquare();  
    }

    /**
     * Takes in a chosen filename to create with a magicSquareArray transferred to a matrix format, with dimension given on the 
     * first line
     * 
     * @param filename name of file to write (or write-ver) magicSquareArray to
     * @param dimension the side dimension to create a new matrix
     * @throws IOException
     */
    public MagicSquare(String filename, int dimension) throws IOException{
        int squareSize = dimension;
        this.isMagic = true; //True because created as so
        this.magicSquareArray = new int[squareSize][squareSize];
        int row = squareSize - 1;
        int col = squareSize / 2;
        int oldRow,oldCol;

        for (int i = 1; i <= (squareSize * squareSize); i++) {
            magicSquareArray[row][col] = i;
            oldRow = row;
            oldCol = col;
            row++;
            col++;

            if (row == squareSize) {
                row = 0;
            }
            if (col == squareSize) {
                col = 0;
            }

            if (magicSquareArray[row][col] > 0) {
                row = oldRow;
                col = oldCol;
                row--;
            }
        }

        this.writeMatrix(this.magicSquareArray, filename);
    }

    @Override
    public int[][] getMatrix(){
        int dimension = this.magicSquareArray[0].length;
        int[][] matrixCopy = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrixCopy[i][j] = this.magicSquareArray[i][j];
            }
        }
        return matrixCopy;
    }

    @Override
    public boolean isMagicSquare(){
        int[][] numMatrix = this.magicSquareArray;
        int dimension = numMatrix[0].length;
        final int magicNumber = (dimension * ((dimension * dimension) + 1)) / 2;
        int[] continuityCheck = new int[dimension * dimension];
        int verticalSum = magicNumber;
        int horizontalSum = magicNumber;
        int rhDiagonalSum = 0;
        int lhDiagonalSum = 0;

        
        for (int i = 0; i < dimension; i++) {
            if (horizontalSum != magicNumber) {
                return false;
            } else if (verticalSum != magicNumber) {
                return false;
            }
            
            
            horizontalSum = 0;
            verticalSum = 0;
            
            for (int j = 0; j < dimension; j++) {
                int quantity = numMatrix[i][j];
                
                horizontalSum += quantity; //normal quantity
                
                verticalSum += numMatrix[j][i]; //inverse quantity
                
                continuityCheck[quantity - 1] = quantity;
                
            }
            
            rhDiagonalSum += numMatrix[i][i];
            
            
            int xCord = i;
            int yCord = (dimension - 1) - i;

            lhDiagonalSum += numMatrix[xCord][yCord];
        }
        if (rhDiagonalSum != magicNumber) {
            return false;
        } else if (lhDiagonalSum != magicNumber) {
            return false;
        } 

        for (int i: continuityCheck) {
            if (i < 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        int dimension = this.magicSquareArray[0].length;
        String notString = "not ";
        String matrixString = "The matrix:";
        if (this.isMagic == true) {
            notString = "";
        }

        for (int i = 0; i < dimension; i++) {
            matrixString += "\n  ";
            for (int j = 0; j < dimension; j++) {
                matrixString += String.valueOf(this.magicSquareArray[i][j]);
                matrixString += " ";
            }
        }

        matrixString += "\nis " + notString + "a magic square.";
    
        return matrixString;
    }

    /**
     * Creates a file and writes the contents of the instance magicSquareArray to it as a matrix, formatted with first line 
     * being the dimension of said matrix
     * 
     * @param matrix
     * @param filename
     * @throws IOException
     */
    private void writeMatrix(int[][] matrix, String filename) throws IOException {
        int dimension = this.magicSquareArray[0].length;
        String matrixString = "";

        File file = new File(filename);
        PrintWriter outFile = new PrintWriter(new FileWriter(file));

        for (int i = 0; i < dimension; i++) {
            matrixString += "\n";
            for (int j = 0; j < dimension; j++) {
                matrixString += String.valueOf(this.magicSquareArray[i][j]);
                matrixString += " ";
            }
        }
        
        outFile.print(dimension);
        outFile.print(matrixString);
        outFile.close();

    }

    /**
     * Parses through a given file to write its contents to a instance of magicSquareArray, returns said array
     * 
     * @param filename is a String used to open a file to read
     * @return 2d int array for MagicSquare obj read from a file
     * @throws FileNotFoundException
     */
    private int[][] readMatrix(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scnr = new Scanner(file);
        int size = scnr.nextInt();
        this.magicSquareArray = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.magicSquareArray[i][j] = scnr.nextInt();
            }
        }
        scnr.close();
        
        return this.magicSquareArray;
    }

    public static void main(String[] args) {
    } 
}