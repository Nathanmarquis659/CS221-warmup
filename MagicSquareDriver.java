import java.io.FileNotFoundException;
import java.io.IOException;

public class MagicSquareDriver {
    public static void main(String[] args) throws IOException, Exception, FileNotFoundException{
        String type = args[0];
        String filename = args[1];
        int dimension;
        MagicSquare squareObj;
        String usageMessage = "java MagicSquareDriver <-check | -create> <filename> <    |odd-size>";

        if (type.equals("-create")) {
            
            dimension = Integer.parseInt(args[2]);
            if ((dimension % 2) == 1) {
                squareObj = new MagicSquare(filename, dimension);
                System.out.println(squareObj.toString());
            } else {
                System.out.println(usageMessage);
            }
            
        } else if (type.equals("-check")) {
                squareObj = new MagicSquare(filename);
                System.out.println(squareObj.toString());
        } else {
            System.out.println(usageMessage);
        }
        
    }
}