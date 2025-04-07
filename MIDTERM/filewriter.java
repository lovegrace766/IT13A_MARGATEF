
package MIDTERM;

import java.io.FileWriter;
import java.io.IOException;


public class filewriter {
    public static void main(String [] args){
       try{
           try (FileWriter myWriter = new FileWriter("C:\\Users\\ACER\\Desktop\\MargateEncryptFileHandling.java.txt")) {
               myWriter.write("I love you!\n Gwapa ko!\n Buotan si Ma'am!");
           }
           System.out.println("Successfully wrote to the file.");
       } catch (IOException e){
           System.out.println("An error occured.");
        }
    }
            
    
}


