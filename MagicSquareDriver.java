import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MagicSquareDriver {
    public static void main(String[] args) throws IOException, Exception, FileNotFoundException{
        String type = args[0];
        String filename = args[1];
        int dimension;
        MagicSquare squareObj;

        if (type.equals("-create")) {
            
            dimension = Integer.parseInt(args[2]);
            if ((dimension % 2) == 1) {
                squareObj = new MagicSquare(filename, dimension);
            } else {
                System.out.println("Use an odd integer for the dimension");
            }
            
        } else if (type.equals("-check")) {
                squareObj = new MagicSquare(filename);
        } else {
            System.out.println("java MagicSquareDriver <-check | -create> <filename> <    |odd-size>");
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