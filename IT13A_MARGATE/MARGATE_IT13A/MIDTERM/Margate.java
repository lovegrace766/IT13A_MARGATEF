
package MIDTERM;


import java.util.Scanner;

 class Margate {

  
    public static void main(String[] args) {
    
    
        Scanner scanner = new Scanner (System.in);
        boolean u = true;
        while (u){
        String word = "";
        String newWord = "";
        
        System.out.println("Enter a word:");
           word = scanner.nextLine();
           
         int i = word.length()-1;
         
        do {
            newWord = newWord + word.charAt(i);
            i--;
            
        } while (i>=0);
        
        if (newWord.equals(String.valueOf(word))){
               System.out.println("Palindrome.");
        
        }else{
                System.out.println("Not a Palindrome.");
                }
    
        }
    }


    
}
