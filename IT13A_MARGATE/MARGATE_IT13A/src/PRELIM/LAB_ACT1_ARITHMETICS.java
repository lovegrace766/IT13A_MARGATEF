
package PRELIM;

import java.util.Scanner;



public class LAB_ACT1_ARITHMETICS {
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner (System.in);
      
        System.out.print("input first num");
        int num1 = scanner.nextInt();
        
        System.out.print("input second num");
        int num2 = scanner.nextInt();
      
        System.out.print("input third num");
        int num3 = scanner.nextInt();
        
        int num4 = 44;
        
        
       System.out.println(num1+"*"+num2+"+"+num3+"="+(num1*num2+num3));
       System.out.println("("+ num1+"-"+num2+")%"+num3+"+"+((num1-num2)%num3));
       System.out.println("("+num1+"+"+num2+"+"+num3+ ")/3="+((num1+num2+num3)/3));
       System.out.println(num1+"*"+num3+"-(" +num2+"*"+num2+")="+num4);
       
       scanner.close();
    }
}
