import java.io.*;
import java.util.*;

public class MagicSquare implements MagicSquareInterface{
    private boolean isMagic;
    private int[][] magicSquareArray;
    
    public MagicSquare() {
        System.out.println("No args contructor");
    }

    // -create
    public MagicSquare(String filename, int dimension) throws Exception{
        int squareSize = dimension;
        this.isMagic = true;
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

        //REMOVE
        System.out.println(Arrays.deepToString(magicSquareArray));

       
            File file = new File(filename);
            PrintWriter outFile = new PrintWriter(new FileWriter(file));

            //Figure out what to do here
            outFile.println("The matrix:");
            
            outFile.close();
        
    }

    // -check
    public MagicSquare(String filename) throws FileNotFoundException, IOException {
        this.readMatrix(filename);

        //REMOVE
        System.out.print(Arrays.deepToString(this.magicSquareArray));
        
    }

    @Override
    public int[][] getMatrix() {
        if (this.isMagicSquare()) {

        }
        String matrix = new String("The matrix:");
        return null;
    }

    @Override
    public boolean isMagicSquare() {
        // TODO Auto-generated method stub
        return false;
    }

    private int[][] readMatrix(String filename) throws FileNotFoundException, IOException {
        
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

    public static void main(String[] args) throws IOException, Exception, FileNotFoundException{

        //REMOVE
        MagicSquare create = new MagicSquare("test", 3);
        MagicSquare check = new MagicSquare("valid4x4");
    } 
}