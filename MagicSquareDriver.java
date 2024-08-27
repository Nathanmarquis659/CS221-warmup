import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MagicSquareDriver {
    public static void main(String[] args) {
        String type = args[0];
        String filename = args[1];
        int dimension;
        MagicSquare squareObj;

        if (type.equals("-create")) {
            try {
                dimension = Integer.parseInt(args[2]);
                if ((dimension % 2) == 1) {
                    squareObj = new MagicSquare(filename, dimension);
                } else {
                    System.out.println("Use an odd integer for the dimension");
                }
            } catch (Exception e) {
                System.out.println("No dimension found, try again");
            }
        } else if (type.equals("-check")) {
            try {
                squareObj = new MagicSquare(filename);
            } catch (FileNotFoundException ex) {
                System.out.println("File '" + filename + "' not found... try again");
            }
        } else {
            System.out.println("Use '-create' or '-check' when using MagicSquareDriver");
        }


        //Check for -create or -check
        
        /* If -create
         *      check that # is odd
         *          if not odd, tell user
         *      create MagicSquare(#, filename)
         *      call method that outputs array to console
         */

         /* If -check
          *     
          */
        
    }
}